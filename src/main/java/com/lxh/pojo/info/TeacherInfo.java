package com.lxh.pojo.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class TeacherInfo {
    private Integer count;
    private Integer total;
}
