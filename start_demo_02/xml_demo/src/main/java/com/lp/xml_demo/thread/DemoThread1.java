package com.lp.xml_demo.thread;

import com.lp.xml_demo.globe.DemoGlobe;
import com.lp.xml_demo.util.FixedThreadPool;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2023/5/7 15:06
 * @Version 1.0
 */
public class DemoThread1{

    public synchronized void run() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                DemoGlobe.line.add("test");
            }
            System.out.println("数据已经全部加到队列"+DemoGlobe.line.size());
            new DemoThread2().run();
            while (true){
                if (DemoGlobe.line.size()<1){
                    break;
                }
                System.out.println("循环");
            }
            System.out.println("加载完，开始加载第二波");
        }
    }
}
