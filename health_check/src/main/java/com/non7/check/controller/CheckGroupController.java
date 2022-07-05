package com.non7.check.controller;


import com.non7.check.service.CheckGroupService;
import com.non7.common.pojo.CheckGroup;
import com.non7.common.constant.MessageConstant;
import com.non7.common.entity.PageResult;
import com.non7.common.entity.QueryPageBean;
import com.non7.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 检查组管理
 */
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {

    @Autowired
    private CheckGroupService checkGroupService;

//    新增检查组
    @PostMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup, Integer[] checkitemIds){
        try {
            checkGroupService.add(checkGroup,checkitemIds);
            return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);//新增成功
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_CHECKGROUP_FAIL);//新增失败
        }


    }

//    分页查询
    @GetMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){

        return checkGroupService.pageQuery(queryPageBean);
    }

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable Integer id){
        try {
            CheckGroup checkGroup=checkGroupService.findById(id);
            return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroup);//查询成功
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);//查询失败
        }

    }

    @GetMapping("/findCheckItemIdsByCheckGroupId/{id}")
    public Result findCheckItemIdsByCheckGroupId(@PathVariable Integer id){
        List<Integer> checkitemIds= null;
        try {
            checkitemIds = checkGroupService.findCheckItemIdsByCheckGroupId(id);
            return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkitemIds);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
        }

    }

    @PutMapping("/edit")
    public Result edit(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        try {
            checkGroupService.edit(checkGroup,checkitemIds);
            return new Result(true,MessageConstant.EDIT_CHECKGROUP_SUCCESS);//修改成功
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.EDIT_CHECKGROUP_FAIL);//修改失败
        }
    }
//    查询所有检查组
    @GetMapping("/findAll")
    public Result findAll(){
        try {
            List<CheckGroup> checkGroups=checkGroupService.findAll();
            return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroups);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
        }
    }
}




























