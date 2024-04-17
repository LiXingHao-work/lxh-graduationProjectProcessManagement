package com.lxh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxh.mapper.ProcessMapper;
import com.lxh.pojo.dox.Process;
import com.lxh.service.ProcessService;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl extends ServiceImpl<ProcessMapper, Process> implements ProcessService {
}
