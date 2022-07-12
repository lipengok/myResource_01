package com.lp.kafka_demo.modle;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/4 10:09
 * @Version 1.0
 */
@Data
public class KafkaReq {

    private String topic;
    private Object data;
}
