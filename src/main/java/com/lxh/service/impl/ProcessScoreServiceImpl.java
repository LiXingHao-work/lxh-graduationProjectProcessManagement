package com.lxh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxh.mapper.ProcessScoreMapper;
import com.lxh.pojo.dox.ProcessScore;
import com.lxh.service.ProcessScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractCollection;
import java.util.List;

@Service
public class ProcessScoreServiceImpl extends ServiceImpl<ProcessScoreMapper, ProcessScore> implements ProcessScoreService {

    @Autowired
    private ProcessScoreMapper processScoreMapper;


}
