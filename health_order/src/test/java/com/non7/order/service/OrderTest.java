package com.non7.order.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void findById() throws Exception {
        Map map = orderService.findById(1);

        System.out.println(map);

    }
}
