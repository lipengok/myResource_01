package com.lp.queue_task_demo.queue.deal.bus;

import com.lp.queue_task_demo.globe.ObjGlobe;

import java.util.Queue;

/**
 * @Author lipeng
 * @Date 2022/10/11 15:42
 * @Version 1.0
 */
public class BusDeal implements Runnable{

    @Override
    public void run() {

        // 将任务从任务队列中取出来
        Queue<Runnable> queue = ObjGlobe.busQueue;
        for (int i = 0; i < queue.size(); i++) {
            Runnable thread = queue.peek();
            thread.run();
        }
    }
}
