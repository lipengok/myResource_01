package com.lp.xml_demo.thread;

import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2023/5/7 15:06
 * @Version 1.0
 */
@Component
public class TestThread extends Thread{

    @Override
    public void run(){
        System.out.println("ok");
    }
}
