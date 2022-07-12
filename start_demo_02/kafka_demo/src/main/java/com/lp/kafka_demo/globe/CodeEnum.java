package com.lp.kafka_demo.globe;

/**
 * @Author lipeng
 * @Date 2022/6/24 14:19
 * @Version 1.0
 */
public enum CodeEnum {
    SUCCESS_CODE("200");

    private String code;

    private CodeEnum(String code) {
        this.code = code;
    }

    public String value() {
        return code;
    }
}
