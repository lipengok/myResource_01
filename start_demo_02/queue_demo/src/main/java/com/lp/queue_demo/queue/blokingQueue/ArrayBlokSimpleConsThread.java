package com.lp.queue_demo.queue.blokingQueue;

import com.lp.queue_demo.Globe.ComGlobe;
import com.lp.queue_demo.entity.Model;
import lombok.extern.slf4j.Slf4j;

/**
 * ArrayBlockingQueue
 * 取数据
 *
 * @Author lipeng
 * @Date 2023/5/18 14:34
 * @Version 1.0
 */
@Slf4j
public class ArrayBlokSimpleConsThread{

    public static Model get() {
        Model model = null;
        try {
            model = (Model) ComGlobe.arrayBlockingQueue.remove();
        }catch (Exception e){
            e.printStackTrace();
            log.error("任务从任务队列取出失败，失败信息=>[{}]", e.getMessage());
        }

        return model;
    }
}
