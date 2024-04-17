package com.lxh.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lxh.pojo.dox.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testSaveUser(){
        userService.save(User.builder()
                .name("lxh")
                .account("lxh")
                .password("lxh")
                .role(User.STUDENT)
                .groupNumber(1)
                .build());
    }

    @Test
    void testQuery(){
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("student->>'$.teacherId'","1779791797380313089");
        List<User> users = userService.list(wrapper);
        System.out.println(users);
    }

}