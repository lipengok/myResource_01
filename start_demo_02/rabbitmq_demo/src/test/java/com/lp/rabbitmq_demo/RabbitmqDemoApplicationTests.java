package com.lp.rabbitmq_demo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqDemoApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }


    @Test
    void mqServer(){
        rabbitTemplate.convertAndSend("WorkExchange", "WorkRouting", "rabbitmq_demo");
    }
}
