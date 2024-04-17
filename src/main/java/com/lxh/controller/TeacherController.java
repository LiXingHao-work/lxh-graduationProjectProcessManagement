package com.lxh.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lxh.pojo.dox.Process;
import com.lxh.pojo.dox.ProcessScore;
import com.lxh.pojo.dox.User;
import com.lxh.pojo.vo.Result;

import com.lxh.service.ProcessScoreService;
import com.lxh.service.ProcessService;
import com.lxh.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/teacher/")
@RequiredArgsConstructor
public class TeacherController {

    private final UserService userService;
    private final ProcessScoreService processScoreService;
    private final ProcessService processService;

    /**
     * 获取所有自己带的学生
     * @param tid
     * @return
     */
    @GetMapping("{tid}/students")
    public Result getStudents(@PathVariable String tid){
        List<User> users = userService.listStudent(tid);
        return Result.success(Map.of("students", users));

    }

    /**
     * 获取所有未选择导师的学生
     * @return
     */
    @GetMapping("unselected")
    public Result getUnselected() {
        List<User> users = userService.listUnSelectedStudents();
        return Result.success(Map.of("students", users));
    }

    /**
     * 获取所有学生
     * @return
     */
    @GetMapping("students")
    public Result getStudents() {
        List<User> users = userService.listUsers(User.STUDENT);
        return Result.success(Map.of("students", users));
    }

    /**
     * 获取所有老师
     * @return
     */
    @GetMapping("teachers")
    public Result getTeachers() {
        List<User> users = userService.listUsers(User.TEACHER);
        return Result.success(Map.of("teachers", users));
    }

    /**
     * 获取所有过程项
     * @return
     */
    @GetMapping("processscores")
    public Result getProcessScores() {
        List<ProcessScore> processScores = processScoreService.list();
        return Result.success(Map.of("processScores", processScores));
    }

    /**
     * 获取所有过程
     * @return
     */
    @GetMapping("processes")
    public Result getProcesses() {
        List<Process> processes = processService.list();
        return Result.success(Map.of("processes", processes));
    }

}
