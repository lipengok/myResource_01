package com.lp.kafka_demo.controller;

import com.lp.kafka_demo.globe.CodeEnum;
import com.lp.kafka_demo.globe.MsgEnum;
import com.lp.kafka_demo.kafka.producer.DemoProducer;
import com.lp.kafka_demo.modle.KafkaMsg;
import com.lp.kafka_demo.modle.KafkaReq;
import com.lp.kafka_demo.modle.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/6/30 14:26
 * @Version 1.0
 */
@RestController
@RequestMapping("kafka")
public class KafkaController {
    @Autowired
    private DemoProducer demoProducer;

    @GetMapping("/send")
    public String testMsg(){
        demoProducer.send("topic1", "test: 000001");
        return "success";
    }

    @PostMapping("/send")
    public ResponseMsg sendMsg(@RequestBody KafkaReq kafkaReq){
        KafkaMsg kafkaMsg = new KafkaMsg();
        kafkaMsg.setCode(CodeEnum.SUCCESS_CODE.value());
        kafkaMsg.setDate(new Date(System.currentTimeMillis()));
        kafkaMsg.setMsg(MsgEnum.SEND_SUCCESS.value());
        kafkaMsg.setTopic(kafkaReq.getTopic());
        kafkaMsg.setObject(kafkaReq.getData());
        demoProducer.send(kafkaReq.getTopic(), kafkaMsg);
        return new ResponseMsg(MsgEnum.SEND_SUCCESS.value(), CodeEnum.SUCCESS_CODE.value(), kafkaReq.getData());
    }
}
