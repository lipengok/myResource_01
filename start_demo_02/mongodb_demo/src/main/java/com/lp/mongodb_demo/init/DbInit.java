package com.lp.mongodb_demo.init;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2022/8/17 9:11
 * @Version 1.0
 */
@Component
public class DbInit implements ApplicationListener<ContextRefreshedEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ProperInit.initDbProperties();
    }
}
