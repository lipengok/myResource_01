package com.lp.quartz_demo.thread;

import com.lp.quartz_demo.modle.templates.TaskTemplate;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author lipeng
 * @Date 2022/7/7 9:45
 * @Version 1.0
 */
public class ProcessThread extends Thread {
    private static ConcurrentLinkedQueue<TaskTemplate> concurrentLinkedQueue;
    private static Object object;

    @Override
    public void run(){

        synchronized (object){

        }
    }
}
