package com.lxh.controller;

import com.lxh.exception.Code;
import com.lxh.exception.XException;
import com.lxh.pojo.dox.Process;
import com.lxh.pojo.dox.User;
import com.lxh.pojo.info.StudentInfo;
import com.lxh.pojo.info.TeacherInfo;
import com.lxh.pojo.vo.Result;
import com.lxh.service.ProcessService;
import com.lxh.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/student/")
public class StudentController {
    private final ProcessService processService;
    private final UserService userService;

    /**
     * 查询所有过程
     *
     * @return
     */
    @GetMapping("processes")
    public Result getProcesses() {
        List<Process> processes = processService.list();
        return Result.success(Map.of("processes", processes));
    }

    //
    @PutMapping("tutors/{tid}")
    public Result putSelection(@PathVariable String tid/* @RequestAttribute("uid") String uid*/) {
        String uid = "1779829667700707330";

        //获取开始时间
        LocalDateTime startTime = userService.getStartTime();

        //获取对象
        List<User> teachers = userService.listUsers(User.TEACHER);
        User teacher = userService.getById(tid);
        User student = userService.getById(uid);

        //获取对应json数据对象
        TeacherInfo teacherInfo = teacher.getTeacher();
        StudentInfo studentInfo = student.getStudent();

        if (LocalDateTime.now().isBefore(startTime)) {
            return Result.error(Code.NOT_START);
        }

        if ((teacherInfo.getTotal() - teacherInfo.getCount()) < 1) {
            return Result.success(Code.QUANTITY_FULL, Map.of("teachers", teachers));
        }

        if (student == null || studentInfo.getTeacherId() != null) {
            return Result.error(Code.REPEAT_SELECTION);
        }

        teacherInfo.setCount(teacherInfo.getCount() + 1);
        teacher.setTeacher(teacherInfo);
        userService.updateById(teacher);

        studentInfo.setTeacherId(tid);
        studentInfo.setTeacherName(teacher.getName());
        student.setStudent(studentInfo);
        userService.updateById(student);

        // 保存学生信息
        return Result.success(Map.of("user",student));

    }
}
