package com.lp.quartz_simple.controller;

import com.lp.quartz_simple.enity.Task;
import com.lp.quartz_simple.enity.template.ResponseTemplate;
import com.lp.quartz_simple.globe.SysGlobe;
import com.lp.quartz_simple.handler.CommHandler;
import com.lp.quartz_simple.handler.Handler;
import com.lp.quartz_simple.task.PrintInfoTask;
import com.lp.quartz_simple.util.FixedThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lipeng
 * @Date 2023/6/15 13:49
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {

    @PostMapping("/add_comm")
    public ResponseTemplate add(@RequestBody Task task){
        ResponseTemplate response = null;
        try {
            boolean success = SysGlobe.taskQueue.add(task);
            if (!success){
                log.error("任务队列已满");
            }
            response = new ResponseTemplate().success(task);
        }catch (Exception e){
            log.error("获取任务失败", e);
            response = new ResponseTemplate().error(e.getMessage());
        }
        return response;
    }

    @GetMapping("/deal_comm")
    public ResponseTemplate deal(){
        ResponseTemplate response = null;
        try {
            Task task = null;
            if (SysGlobe.taskQueue.size() > 0){
                task= SysGlobe.taskQueue.remove();
                // 分发任务
                Handler handler = new CommHandler();
                handler.handler(task);
                response = new ResponseTemplate().success(task);
            }else {
                log.error("任务队列中没有任务");
                response = new ResponseTemplate().error("任务队列中没有任务");
            }
        }catch (Exception e){
            log.error("任务执行失败", e);
            response = new ResponseTemplate().error(e.getMessage());
        }
        return response;
    }
}
