package com.lxh.mapper;

import com.lxh.pojo.dox.User;
import com.lxh.pojo.info.StudentInfo;
import com.lxh.pojo.info.TeacherInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)//解决MP注入Mapper对象时报null
@SpringBootTest

public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUserTest(){

        userMapper.insert(User.builder()
                .name("lkj")
                .account("sdf")
                .password("sdf")
                .description(LocalDateTime.now())
                .role(User.ADMIN)
                .build());

        userMapper.insert(User.builder()
                .name("qwe")
                .account("qwe")
                .password("qwe")
                .groupNumber(1)
                .role(User.STUDENT)
                .student(StudentInfo.of(null, null, 1, "999"))
                .build());

        userMapper.insert(User.builder()
                .name("bo")
                .account("bo")
                .password("bo")
                .groupNumber(1)
                .teacher(TeacherInfo.of(0, 10))
                .role(User.TEACHER)
                .build());
    }

//    @Test
//    public void getStartTimeTest(){
////        System.out.println(userMapper.findStartTime());
//        userMapper.updateCount("1779791797380313089");
//    }
}
