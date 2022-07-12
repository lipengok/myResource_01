package com.lp.kafka_demo.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2022/6/30 11:27
 * @Version 1.0
 */
@Component
@Slf4j
public class DemoConsumer {

    // 消费监听
    @KafkaListener(topics = {"topic1"})
    public void onMessage(ConsumerRecord<?, ?> record){
        // 消费的哪个topic、partition的消息,打印出消息内容
        log.debug("Consumer =>主题[{}] 分区[{}] 消息[{}]",record.topic(),record.partition(),record.value());
    }

}
