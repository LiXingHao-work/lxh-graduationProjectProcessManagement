package com.lxh.controller;

import com.lxh.pojo.dox.User;
import com.lxh.pojo.info.StudentInfo;
import com.lxh.pojo.vo.Result;
import com.lxh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)//解决MP注入Mapper对象时报null
@SpringBootTest
public class StudentControllerTest {
    @Autowired
    private UserService userService;
    @Test
    public Result ss(){
        User student = User.builder()
                .student(StudentInfo.of(null,null,2,"78"))
                .groupNumber(2)
                .role(User.STUDENT)
                .account("3")
                .password("hfh")
                .name("jdj")
                .build();
        userService.save(student);
        System.out.println(student);
        return Result.success(Map.of("student", student));
    }
}
