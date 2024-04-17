package com.lxh.pojo.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class ItemsInfo {
    private Integer number;
    private String name;
    private Double point;

}
