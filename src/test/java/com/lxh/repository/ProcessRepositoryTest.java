package com.lxh.repository;

import com.lxh.dto.Process;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProcessRepositoryTest {

    @Autowired
    private ProcessRepository processRepository;;

    @Test
    public void addProcessTest() {
        Process process = Process.builder()
                .name("期中审查")
                .build();
        processRepository.save(process);
    }
}
