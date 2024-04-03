package com.lxh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    //'角色: 1.教师 2.学生 5.管理员'
    public static final int TEACHER = 1;
    public static final int STUDENT = 2;
    public static final int ADMIN = 5;
    @Id
    @CreatedBy
    private String id;
    private String name;
    private String account;
    private String password;
    private Integer role;
    private Integer groupNumber;
    //json
    private String student;
    //json
    private String teacher;
    @ReadOnlyProperty
    private LocalDateTime updateTime;
    @ReadOnlyProperty
    private LocalDateTime insertTime;
}
