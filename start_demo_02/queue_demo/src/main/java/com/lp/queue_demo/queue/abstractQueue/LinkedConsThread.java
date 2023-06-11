package com.lp.queue_demo.queue.abstractQueue;

import com.lp.queue_demo.Globe.ComGlobe;
import com.lp.queue_demo.entity.Model;
import com.lp.queue_demo.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * ConcurrentLinkedQueue
 * 取数据
 *
 * @Author lipeng
 * @Date 2023/5/29 13:41
 * @Version 1.0
 */
@Slf4j
public class LinkedConsThread extends Thread{

    public LinkedConsThread(){}

    public LinkedConsThread(String name){
        super(name);
    }


    @Override
    public void run(){
        Model model = get();
        if (null == model){
            log.error("任务队列为空");
            return;
        }
        ComGlobe.catchLinkedQueue.add(model);
        log.debug("线程[{}]成功获取任务[{}]", this.getName(), model);
    }

    public Model get(){
        Model model = ComGlobe.concurrentLinkedQueue.poll();
        return model;
    }
}
