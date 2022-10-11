package com.lp.queue_task_demo.queue.task;

/**
 * @Author lipeng
 * @Date 2022/10/11 10:33
 * @Version 1.0
 */
public class RedisInit implements Runnable {
    @Override
    public void run() {
        System.out.println("redis init");
    }
}
