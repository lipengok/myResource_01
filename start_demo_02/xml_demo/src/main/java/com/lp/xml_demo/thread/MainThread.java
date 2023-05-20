package com.lp.xml_demo.thread;


/**
 * @Author lipeng
 * @Date 2023/5/7 15:07
 * @Version 1.0
 */
public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        // 往队列中加数据
        new DemoThread1().run();
    }
}
