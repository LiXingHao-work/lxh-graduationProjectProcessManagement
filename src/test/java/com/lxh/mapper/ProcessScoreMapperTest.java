package com.lxh.mapper;

import com.lxh.pojo.dox.ProcessScore;
import com.lxh.pojo.info.DetailInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)//解决MP注入Mapper对象时报null
@SpringBootTest
public class ProcessScoreMapperTest {

    @Autowired
    private ProcessScoreMapper processScoreMapper;

    @Test
    public void addProcessScoreT2est() {
        processScoreMapper.insert(ProcessScore.builder()
                .process_id("1")
                .student_id("2")
                .teacher_id("3")
                //'{"teacherName", "score", detail: [{"number", "score"}]}'
                .detail(DetailInfo.of("BO", 90, Map.of(1,90,2,90,3,90)))
                .build());
    }
}
