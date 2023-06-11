package com.lp.quartz_simple.controller;

import com.lp.quartz_simple.enity.template.ResponseTemplate;
import com.lp.quartz_simple.task.PrintInfoTask;
import com.lp.quartz_simple.util.FixedThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2023/6/8 15:09
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/task")
public class QuartzController {

    @GetMapping("/print")
    public ResponseTemplate printInfo(){
        ResponseTemplate response = null;
        try {
            FixedThreadPool.startWithoutResult(new PrintInfoTask()::run);
            response = new ResponseTemplate().success(null);
        }catch (Exception e){
            log.error("启动定时任务失败", e);
            response = new ResponseTemplate().error(e.getMessage());
        }
        return response;
    }
}
