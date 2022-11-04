package com.lp.springbootbuslog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lp.springbootbuslog.entity.SysLog;
import com.lp.springbootbuslog.mapper.TestMapper;
import com.lp.springbootbuslog.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/10/28 14:18
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public int saveLog(SysLog sysLog) {

        return testMapper.insert(sysLog);
    }

    public List<SysLog> logList(){
        return testMapper.selectList(null);
    }

    public List<SysLog> logList(SysLog sysLog){
        QueryWrapper wrapper = new QueryWrapper<SysLog>();
        wrapper.eq("id", sysLog.getId());
        return testMapper.selectList(wrapper);
    }
}
