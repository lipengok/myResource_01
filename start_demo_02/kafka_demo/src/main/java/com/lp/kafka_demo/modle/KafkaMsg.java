package com.lp.kafka_demo.modle;

import lombok.Data;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/7/4 9:57
 * @Version 1.0
 */
@Data
public class KafkaMsg {
    // topic的名称
    private String topic;

    // 发送时间
    private Date date;

    // 状态码
    private String code;

    // 发送到topic的数据描述
    private String msg;

    // 发送到topic的数据
    private Object object;
}
