package com.lp.queue_task_demo.controller;

import com.lp.queue_task_demo.queue.deal.bus.BusDeal;
import com.lp.queue_task_demo.queue.deal.init.InitDeal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/10/12 9:19
 * @Version 1.0
 */
@RestController
@RequestMapping("/queue")
public class QueueController {

    public String initSys(){
        InitDeal initDeal = new InitDeal();
        initDeal.run();
        return "系统初始化成功";
    }

    public String initBus(){
        BusDeal busDeal = new BusDeal();
        busDeal.run();
        return "业务初始化成功";
    }

    @GetMapping("/all")
    public String initAll(){
        InitDeal initDeal = new InitDeal();
        BusDeal busDeal = new BusDeal();
        busDeal.run();
        initDeal.run();
        return "项目初始化成功";
    }
}
