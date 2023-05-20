package com.lp.queue_demo.controller;

import com.lp.queue_demo.Globe.ComGlobe;
import com.lp.queue_demo.entity.Model;
import com.lp.queue_demo.queue.blokingQueue.ArrayBlokSimpleConsThread;
import com.lp.queue_demo.queue.blokingQueue.ArrayBlokSimpleProThread;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2023/5/19 13:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/array_block")
public class ArrayBlockController {

    @GetMapping("/putTask")
    public String putTask(){
        for (int i = 0; i < 11; i++) {
            ComGlobe.currentTaskID = String.valueOf(new Date().getTime());
            // FixedThreadPool.startWithoutResult(new ArrayBlokProThread("product"+i)::run);
            ArrayBlokSimpleProThread.put();
        }
        return "ok";
    }


    @GetMapping("/getTask")
    public ArrayList<Model> getTask(){
        ArrayList<Model> models = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            ComGlobe.currentTaskID = String.valueOf(new Date().getTime());
            // FixedThreadPool.startWithoutResult(new ArrayBlokConsThread("consum"+i)::run);
            models.add(ArrayBlokSimpleConsThread.get());
        }
        return models;
    }
}
