package com.lp.springbootbuslog.listener;

import com.lp.springbootbuslog.entity.SysLog;
import com.lp.springbootbuslog.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2022/10/28 14:06
 * @Version 1.0
 */
@Slf4j
@Component
public class MyEventListener {

    @Autowired
    private TestService testService;

    // 开启异步
    @Async
    // 开启监听
    @EventListener(SysLog.class)
    public void saveSysLog(SysLog event) {
        log.info("=====即将异步保存到数据库======");
        testService.saveLog(event);
    }

}

