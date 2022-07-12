package com.lp.quartz_demo.enums;

/**
 * @Author lipeng
 * @Date 2022/7/7 14:53
 * @Version 1.0
 */
public enum CodeEnum {

    COMMON_SUCCESS_CODE("200");

    private String code;

    private CodeEnum(String code){
        this.code = code;
    }

    public String value(){
        return code;
    }
}
