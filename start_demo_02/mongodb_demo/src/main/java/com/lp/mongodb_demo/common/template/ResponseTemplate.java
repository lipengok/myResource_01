package com.lp.mongodb_demo.common.template;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/8/17 16:30
 * @Version 1.0
 */
@Data
public class ResponseTemplate {

    private String code;

    private String msg;

    private Object data;

    public ResponseTemplate(){}

    public ResponseTemplate(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
