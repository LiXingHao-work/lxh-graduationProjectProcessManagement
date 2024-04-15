package com.lxh.mapper;

import com.lxh.pojo.dox.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)//解决MP注入Mapper对象时报null
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUserTest(){
//        User user = User.builder()
//                .name("lkj")
//                .account("admin")
//                .password("admin")
//                .role(User.ADMIN)
//                .groupNumber(1)
//                .build();
//        //System.out.println(user.getName());
//        userRepository.save(user);
        userMapper.insert(User.builder()
                .name("lkj")
                .account("sdf")
                .password("sdf")
                .role(User.ADMIN)
                .groupNumber(1)
                .build());
    }
}
