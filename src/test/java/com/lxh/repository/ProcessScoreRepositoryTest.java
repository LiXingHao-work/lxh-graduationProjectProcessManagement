package com.lxh.repository;

import com.lxh.dto.ProcessScore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProcessScoreRepositoryTest {

    @Autowired
    private ProcessScoreRepository processScoreRepository;

    @Test
    public void addProcessScoreTest() {
        ProcessScore processScore = ProcessScore.builder()
                .process_id("1")
                .student_id("2")
                .teacher_id("3")
                //'{"teacherName", "score", detail: [{"number", "score"}]}'
                .detail("{\"teacherName\":  \"王老师\", \"score\": \"99\", \"detail\": [{\"number\": \"1\", \"score\" : \"99\"}]}")
                .build();
        processScoreRepository.save(processScore);
    }
}
