package com.lp.medium_demo;

import com.lp.medium_demo.globe.CommonGlobe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2023/4/17 9:10
 * @Version 1.0
 */
@Slf4j
@Component
@PropertySource("classpath:application.properties")
public class SystemInit implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${common.web.index}")
    private String webIndexPath;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 初始化全局变量
        CommonGlobe.webIndexPath = this.webIndexPath;

        log.info("项目启动成功");
    }
}
