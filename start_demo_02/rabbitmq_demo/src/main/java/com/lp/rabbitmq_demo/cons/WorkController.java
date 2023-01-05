package com.lp.rabbitmq_demo.cons;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @Author lipeng
 * @Date 2022/11/30 9:56
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "WorkQueue")
public class WorkController {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("收到消息  : " + msg);
    }
}
