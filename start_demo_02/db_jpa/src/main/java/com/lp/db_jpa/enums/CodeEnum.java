package com.lp.db_jpa.enums;

/**
 * @Author lipeng
 * @Date 2022/7/25 9:20
 * @Version 1.0
 */
public enum CodeEnum {
    COMMON_DEFAULT_CODE(500),
    COMMON_SUCCESS_CODE(200);

    private Integer code;
    private CodeEnum(Integer code){
        this.code = code;
    }

    public Integer value(){
        return this.code;
    }
}
