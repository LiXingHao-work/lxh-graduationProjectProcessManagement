package com.lxh.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.lxh.pojo.dox.User;


import java.time.LocalDateTime;
import java.util.List;

public interface UserService extends IService<User> {

//    /**
//     * 选导师
//     *
//     * @param uid
//     * @param tid
//     * @return
//     */
//    User addSelection(String uid, String tid);

    /**
     * 返回所有教师
     * @param role
     * @return
     */
    List<User> listUsers(int role);

    List<User> listStudent(String tid);

    List<User> listStudent(int student, int g);

    List<User> listUnSelectedStudents();

    LocalDateTime getStartTime();
}
