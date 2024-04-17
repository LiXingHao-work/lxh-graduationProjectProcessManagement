package com.lxh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxh.mapper.UserMapper;
import com.lxh.pojo.dox.User;
import com.lxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

//    @Override
//    public User addSelection(String uid, String tid) {
//        // 获取更新计数的结果
//        //int result = userMapper.updateCount(tid); // block() 用于等待反应完成
//
//
//        // 根据学生ID和教师ID查找用户
//        User student = userMapper.selectById(uid);
//        User teacher = this.getById(tid);
//        if (student == null || student.getStudent() != null) {
//            throw new XException(Code.REPEAT_SELECTION);
//        }
//
//        // 构建教师JSON字符串并设置给学生
//        student.getStudent().setTeacherId(tid);
//        student.getStudent().setTeacherName(teacher.getName());
//
//        // 保存学生信息
//        userMapper.insert(student);
//        return student;
//    }

    @Override
    public List<User> listUsers(int role) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("role",role);
        return this.list(wrapper);
    }

    @Override
    public LocalDateTime getStartTime() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("role",User.ADMIN);
        return userMapper.selectOne(wrapper).getDescription();
    }

    @Override
    public List<User> listStudent(String tid) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("student->>'$.teacherId'",tid);
        return this.list(wrapper);
    }

    @Override
    public List<User> listStudent(int role, int g) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .eq("role",role)
                .eq("group_number", g);
        return this.list(wrapper);
    }

    @Override
    public List<User> listUnSelectedStudents() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNull("JSON_CONTAINS(json_array_column, 'teacherId')");
        return this.list(wrapper);
    }

}
