package com.lxh.pojo.dox;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.lxh.pojo.info.ItemsInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "process", autoResultMap = true)
public class Process {
    @Id
    @CreatedBy
    private String id;
    private String name;
    //json
    @TableField(typeHandler = JacksonTypeHandler.class)
    private ItemsInfo items;
    private LocalDateTime update_time;
    private LocalDateTime create_time;
}
