package com.lp.map_demo.init;

import com.lp.map_demo.globe.CommGlobe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2023/7/12 14:39
 * @Version 1.0
 */
@Slf4j
@Component
public class SysInit implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${http.map.key}")
    private String mapKey;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        log.info("开始配置基础信息");

        CommGlobe.mapKey = mapKey;
        log.info("【配置】高德地图的key[{}]", CommGlobe.mapKey);

        log.info("配置基础信息结束");
    }
}
