package com.lxh.pojo.dox;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.lxh.pojo.info.DetailInfo;
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
@TableName(value = "process_score", autoResultMap = true)
public class ProcessScore {
    @Id
    @CreatedBy
    private String id;
    private String student_id;
    private String process_id;
    private String teacher_id;
    //json
    @TableField(typeHandler = JacksonTypeHandler.class)
    private DetailInfo detail;
    private LocalDateTime update_time;
    private LocalDateTime create_time;
}
