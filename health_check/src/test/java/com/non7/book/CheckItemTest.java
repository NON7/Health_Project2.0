package com.non7.book;

import com.non7.check.service.CheckItemService;
import com.non7.common.pojo.CheckItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckItemTest {
    @Autowired
    private CheckItemService checkItemService;

    @Test
    public void findById(){
        CheckItem checkItem = checkItemService.findById(30);
        System.out.println(checkItem.getName());
    }
}
