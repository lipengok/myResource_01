package com.lp.listener_demo.listeners.self.init;

import com.lp.listener_demo.listeners.self.EmailEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2022/7/15 10:27
 * @Version 1.0
 */
@Component
public class InitSystem {
    @Autowired
    private ApplicationContext applicationContext;

    public void test(){
        System.out.println(applicationContext);
    }

    public void init() {
        EmailEvent event = new EmailEvent("hello","abc@163.com","This is a test");
        //主动触发该事件
        applicationContext.publishEvent(event);
    }
}
