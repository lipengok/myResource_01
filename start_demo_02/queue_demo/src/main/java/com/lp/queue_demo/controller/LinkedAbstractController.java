package com.lp.queue_demo.controller;

import com.lp.queue_demo.Globe.ComGlobe;
import com.lp.queue_demo.entity.model.ResponseModel;
import com.lp.queue_demo.queue.abstractQueue.LinkedConsThread;
import com.lp.queue_demo.queue.abstractQueue.LinkedProThread;
import com.lp.queue_demo.util.FixedThreadPool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2023/5/29 13:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/linked_abstract")
public class LinkedAbstractController {

    @GetMapping("/add")
    public ResponseModel add(){
        ResponseModel response = null;
        try {
            for (int i = 0; i < 10; i++) {
                ComGlobe.currentTaskID = String.valueOf(new Date().getTime());
                String name = "thread"+i;
                FixedThreadPool.startWithoutResult(new LinkedProThread(name)::run);
            }
            response = new ResponseModel().success(null);
        }catch (Exception e){
            e.printStackTrace();
            response = new ResponseModel().error(e.getMessage());
        }
        return response;
    }

    @GetMapping("/get/{num}")
    public ResponseModel get(@PathVariable int num){
        ResponseModel response = null;
        try {
            for (int i = 0; i < num; i++) {
                String name = "thread"+i;
                FixedThreadPool.startWithoutResult(new LinkedConsThread(name)::run);
            }
            response = new ResponseModel().success(ComGlobe.catchLinkedQueue);
        }catch (Exception e){
            e.printStackTrace();
            response = new ResponseModel().error(e.getMessage());
        }
        return response;
    }

    @GetMapping("/size")
    public ResponseModel getSize(){
        ResponseModel response = null;
        try {
            int size = ComGlobe.concurrentLinkedQueue.size();
            response = new ResponseModel().success(size);
        }catch (Exception e){
            e.printStackTrace();
            response = new ResponseModel().error(e.getMessage());
        }
        return response;
    }
}
