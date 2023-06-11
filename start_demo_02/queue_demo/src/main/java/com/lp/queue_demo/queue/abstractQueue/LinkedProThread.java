package com.lp.queue_demo.queue.abstractQueue;

import com.lp.queue_demo.Globe.ComGlobe;
import com.lp.queue_demo.entity.Model;
import com.lp.queue_demo.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * ConcurrentLinkedQueue
 * 放数据
 *
 * @Author lipeng
 * @Date 2023/5/29 13:41
 * @Version 1.0
 */
@Slf4j
public class LinkedProThread extends Thread{

    public LinkedProThread(){}

    public LinkedProThread(String name){
        super(name);
    }

    @Override
    public void run(){
        Date now = new Date();
        Model model = new Model();
        try {
            model.setTaskId(ComGlobe.currentTaskID);
            model.setStartTime(TimeUtil.parse(now));
            model.setEndTime(TimeUtil.parse(TimeUtil.addDay(now, 1)));
            model.setTimes(0);
            add(model);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.debug("线程[{}]成功添加任务[{}],到任务队列concurrentLinkedQueue", this.getName(), model);
    }

    public Model add(Model model){
        boolean res = ComGlobe.concurrentLinkedQueue.offer(model);
        if (res) {

        }else {
            log.error("任务入到任务队列失败，当前任务队列已满");
        }
        return model;
    }
}
