package com.lp.excel_demo.templates.enums;

/**
 * @Author lipeng
 * @Date 2022/7/25 9:20
 * @Version 1.0
 */
public enum CodeEnum {
    COMMON_DEFAULT_CODE("500"),
    COMMON_SUCCESS_CODE("200");

    private String code;
    private CodeEnum(String code){
        this.code = code;
    }

    public String value(){
        return this.code;
    }
}
