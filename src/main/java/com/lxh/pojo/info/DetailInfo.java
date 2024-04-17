package com.lxh.pojo.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class DetailInfo {
    private String teacherName;
    private Integer score;
    private Map<Integer,Integer> detail;

}

