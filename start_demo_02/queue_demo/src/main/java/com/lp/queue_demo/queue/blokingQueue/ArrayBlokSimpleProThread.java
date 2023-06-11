package com.lp.queue_demo.queue.blokingQueue;

import com.lp.queue_demo.Globe.ComGlobe;
import com.lp.queue_demo.entity.Model;
import com.lp.queue_demo.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * ArrayBlockingQueue
 * 放数据
 *
 * @Author lipeng
 * @Date 2023/5/18 14:34
 * @Version 1.0
 */
@Slf4j
public class ArrayBlokSimpleProThread {

    public static Model put() {
        Date now = new Date();
        Model model = new Model();
        model.setTaskId(ComGlobe.currentTaskID);
        model.setStartTime(TimeUtil.parse(now));
        model.setEndTime(TimeUtil.parse(TimeUtil.addDay(now, 1)));
        model.setTimes(0);

        try {
            ComGlobe.arrayBlockingQueue.add(model);
            // log.debug("当前任务数[{}]", ComGlobe.arrayBlockingQueue.size());
        }catch (Exception e){
            log.error("任务入到任务队列失败，失败信息=>[{}]", e.getMessage());
        }
        return model;
    }
}
