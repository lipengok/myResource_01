package com.lp.xml_demo.thread;

import com.lp.xml_demo.globe.DemoGlobe;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2023/5/7 15:06
 * @Version 1.0
 */
public class DemoThread2{

    public synchronized void run() throws InterruptedException {

        System.out.println(DemoGlobe.line.size());
        for (int i = 0; i < DemoGlobe.line.size(); i++) {
            DemoGlobe.line.poll();
            System.out.println(i+"已经消费掉了");
            System.out.println(DemoGlobe.line.size());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new DemoThread2().run();
    }
}
