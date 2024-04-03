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
public class Process {
    @Id
    @CreatedBy
    private String id;
    private String name;
    private String items;
    private LocalDateTime update_time;
    private LocalDateTime create_time;
}
