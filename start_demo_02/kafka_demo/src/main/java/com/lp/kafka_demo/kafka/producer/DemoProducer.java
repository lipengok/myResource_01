package com.lp.kafka_demo.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2022/6/30 11:21
 * @Version 1.0
 */
@Component
public class DemoProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topic, Object object){
        kafkaTemplate.send(topic, object);
    }
}
