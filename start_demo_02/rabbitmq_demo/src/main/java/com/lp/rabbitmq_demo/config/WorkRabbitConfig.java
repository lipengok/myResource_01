package com.lp.rabbitmq_demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * work队列配置
 * @Author lipeng
 * @Date 2022/11/28 15:23
 * @Version 1.0
 */
@Configuration
public class WorkRabbitConfig {

    @Bean
    public Queue WorkQueue() {
        return new Queue("WorkQueue",true);
    }

    @Bean
    DirectExchange WorkExchange() {
        return new DirectExchange("WorkExchange");
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(WorkQueue()).to(WorkExchange()).with("WorkRouting");
    }
}
