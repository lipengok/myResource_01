package com.lp.springbootbuslog.listener;

import com.lp.springbootbuslog.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2022/10/28 14:04
 * @Version 1.0
 */
@Component
public class EventPubListener {
    @Autowired
    private ApplicationContext applicationContext;

    // 事件发布方法
    public void pushListener(SysLog sysLogEvent) {
        applicationContext.publishEvent(sysLogEvent);
    }
}

