package com.lp.dubbo_demo_consumer.template;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/19 9:57
 * @Version 1.0
 */
@Data
public class ResponseTemplate {
    private Integer code;
    private String msg;
    private Object data;

    public ResponseTemplate (String msg, Integer code, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
