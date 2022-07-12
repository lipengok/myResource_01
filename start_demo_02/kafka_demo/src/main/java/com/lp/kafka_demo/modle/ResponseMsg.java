package com.lp.kafka_demo.modle;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/4 10:03
 * @Version 1.0
 */
@Data
public class ResponseMsg {

    private String msg;
    private String code;
    private Object data;

    public ResponseMsg(String msg, String code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
}
