package com.lp.dubbo_api_consumer_demo.enums;

/**
 * 返回码
 * @Author lipeng
 * @Date 2022/7/19 9:59
 * @Version 1.0
 */
public enum Code {

    COMMON_SUCCESS(200);

    private Integer code;

    private Code(Integer code){
        this.code = code;
    }

    public Integer value(){
        return code;
    }
}
