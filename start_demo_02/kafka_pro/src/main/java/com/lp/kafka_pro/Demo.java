package com.lp.kafka_pro;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @Author lipeng
 * @Date 2023/5/14 23:21
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        Properties kafkaProperties = new Properties();
        kafkaProperties.put("bootstrap.servers", "127.9.0.1:9092");

        kafkaProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        kafkaProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer producer = new KafkaProducer(kafkaProperties);
        ProducerRecord record = new ProducerRecord("topic1", "name", "water");
        try {
            Future result = producer.send(record);
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
