package com.lxh.dto;

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
public class ProcessScore {
    @Id
    @CreatedBy
    private String id;
    private String student_id;
    private String process_id;
    private String teacher_id;
    private String detail;
    private LocalDateTime update_time;
    private LocalDateTime create_time;
}
