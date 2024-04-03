package com.lxh.repository;

import com.lxh.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUserTest(){
        User user = User.builder()
                .name("lkj")
                .account("admin")
                .password("admin")
                .role(User.ADMIN)
                .groupNumber(1)
                .build();
        //System.out.println(user.getName());
        userRepository.save(user);
    }
}
