package com.non7.book;

import com.non7.check.service.CheckGroupService;
import com.non7.common.pojo.CheckGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckGroupTest {
    @Autowired
    public CheckGroupService checkGroupService;

    @Test
    public void findById(){
        CheckGroup checkGroup = checkGroupService.findById(5);
        System.out.println(checkGroup.getName());
    }
}
