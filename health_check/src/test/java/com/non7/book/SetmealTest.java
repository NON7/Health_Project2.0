package com.non7.book;

import com.non7.check.dao.SetmealDao;
import com.non7.check.service.SetmealService;
import com.non7.common.pojo.Setmeal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisPool;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SetmealTest {
    @Autowired
    public SetmealService setmealService;


    @Test
    public void findById(){
//        jedisPool.getResource().mget();
        Setmeal setlmeal = setmealService.findById(10);
        System.out.println("查询某个数据："+setlmeal.getName());

    }
}
