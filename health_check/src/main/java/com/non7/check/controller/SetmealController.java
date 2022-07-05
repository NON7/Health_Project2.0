package com.non7.check.controller;


import com.non7.common.pojo.Setmeal;
import com.non7.check.service.SetmealService;
import com.non7.common.constant.MessageConstant;
import com.non7.common.constant.RedisConstant;
import com.non7.common.entity.PageResult;
import com.non7.common.entity.QueryPageBean;
import com.non7.common.entity.Result;
import com.non7.common.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 体检套餐管理
 */

@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    //使用JedisPool操作Redis服务
    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private SetmealService setmealService;
//    文件上传
    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile imgFile){
//        获取原始文件名的图片类型
        String originalFilename = imgFile.getOriginalFilename();
        int i = originalFilename.lastIndexOf(".");
        String extention = originalFilename.substring(i - 1);//.jpg

//        随机产生文件名
        String fileName= UUID.randomUUID().toString()+extention;//36位字符串

        try {
//            将文件上传到七牛云服务器
            QiniuUtils.upload2Qiniu(imgFile.getBytes(),fileName);
            jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES,fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.PIC_UPLOAD_FAIL);
        }
        return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS,fileName);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Setmeal setmeal, Integer[] checkgroupIds){
        try {
//            System.out.println("SetmealController>>>>>>>>>>>>>>>>>>");
            setmealService.add(setmeal,checkgroupIds);
            return new Result(true,MessageConstant.ADD_SETMEAL_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_SETMEAL_FAIL);
        }

    }

    @GetMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){

        return setmealService.findPage(queryPageBean);
    }

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable Integer id){
        try {
            Setmeal setmeal = setmealService.findById(id);
            return new Result(true,MessageConstant.QUERY_SETMEAL_SUCCESS,setmeal);

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_SETMEAL_FAIL);

        }
    }

    @GetMapping("/findAll")
    public Result findAll(){
        try {
            List<Setmeal> list=setmealService.findAll();
            return new Result(true,MessageConstant.QUERY_SETMEALLIST_SUCCESS,list);

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_SETMEALLIST_FAIL);

        }
    }
    @GetMapping("/findCheckSetmealIdsByCheckgroupId/{id}")
    public Result findCheckSetmealIdsByCheckgroupId(@PathVariable Integer id){
        try {
            List<Integer> checkgroupIds=setmealService.findCheckSetmealIdsByCheckgroupId(id);
            return new Result(true,MessageConstant.QUERY_SETMEALLIST_SUCCESS,checkgroupIds);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_SETMEALLIST_FAIL);
        }
    }


    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
        try {
            setmealService.deleteById(id);
            return new Result(true,MessageConstant.DELETE_SETMEAL_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_SETMEAL_FAIL);
        }
    }



    @PutMapping("/edit")
    public Result edit(@RequestBody Setmeal setmeal,Integer[] checkgroupIds){
        try {
            setmealService.edit(setmeal,checkgroupIds);
            return new Result(true,MessageConstant.EDIT_SETMEAL_SUCCESS);//修改成功
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_SETMEAL_FAIL);
        }
    }


}
