package com.lp.login_jwt.system;

import com.lp.login_jwt.util.RedisUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2022/7/27 14:40
 * @Version 1.0
 */
@Component
public class SystemInit implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        RedisUtil redisUtil = contextRefreshedEvent.getApplicationContext().getBean(RedisUtil.class);
        redisUtil.init();
    }
}
