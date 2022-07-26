package com.lp.db_jpa.template;

/**
 * @Author lipeng
 * @Date 2022/7/25 11:15
 * @Version 1.0
 */
public class ResponseTemplate {

    private String msg;
    private Integer code;

    public Object data;

    public ResponseTemplate(String msg, Integer code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
}
