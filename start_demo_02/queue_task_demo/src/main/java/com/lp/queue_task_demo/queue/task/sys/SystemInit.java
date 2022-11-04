package com.lp.queue_task_demo.queue.task.sys;

import com.lp.queue_task_demo.globe.ObjGlobe;
import com.lp.queue_task_demo.queue.task.KafkaInit;
import com.lp.queue_task_demo.queue.task.MysqlInit;
import com.lp.queue_task_demo.queue.task.RedisInit;
import com.lp.queue_task_demo.queue.task.ZkInit;

/**
 * @Author lipeng
 * @Date 2022/10/11 10:36
 * @Version 1.0
 */
public class SystemInit implements Runnable{


    @Override
    public void run() {

        // 任务放到任务队列里面
        ObjGlobe.iniQueue.add(new KafkaInit());
        ObjGlobe.iniQueue.add(new MysqlInit());
        ObjGlobe.iniQueue.add(new RedisInit());
        ObjGlobe.iniQueue.add(new ZkInit());

    }
}
