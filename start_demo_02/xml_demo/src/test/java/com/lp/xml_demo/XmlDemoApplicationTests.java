package com.lp.xml_demo;

import com.lp.xml_demo.thread.TestThread;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XmlDemoApplicationTests {

    @Test
    void contextLoads() {
        TestThread testThread = new TestThread();
        testThread.start();
    }

}
