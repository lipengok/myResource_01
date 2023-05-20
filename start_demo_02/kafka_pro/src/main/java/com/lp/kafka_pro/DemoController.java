package com.lp.kafka_pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2023/5/14 23:04
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/send")
    public String send(){
        kafkaTemplate.send("topic1", "00002");
        return "ok";
    }
}
