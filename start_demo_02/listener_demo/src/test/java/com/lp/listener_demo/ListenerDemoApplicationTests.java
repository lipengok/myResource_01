package com.lp.listener_demo;

import com.lp.listener_demo.listeners.self.init.InitSystem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ListenerDemoApplicationTests {
    @Autowired
    InitSystem initSystem;

    @Test
    void contextLoads() {
        initSystem.init();
    }

}
