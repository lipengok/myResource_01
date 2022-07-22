package com.lp.logback_demo;

import com.lp.logback_demo.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class LogbackDemoApplicationTests {

    @Test
    void contextLoads() {
        LogUtil.init();
    }

    @Test
    void logTest(){
        log.debug("项目路径=>{[]}", System.getProperty("user.dir"));
    }

}
