package com.lxh.pojo.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class StudentInfo {
    private String teacherId;
    private String teacherName;
    private Integer gradeRanking;
    private String projectTitle;
}
