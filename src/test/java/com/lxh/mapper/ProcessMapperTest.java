package com.lxh.mapper;

import com.lxh.pojo.dox.Process;
import com.lxh.pojo.info.ItemsInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)//解决MP注入Mapper对象时报null
@SpringBootTest
public class ProcessMapperTest {

    @Autowired
    private ProcessMapper processMapper;;

    @Test
    public void addProcessTest() {

        processMapper.insert(Process.builder()
                .name("期中审查")
                .items(ItemsInfo.of(1,"其中审查",0.3))
                .build());
    }
}
