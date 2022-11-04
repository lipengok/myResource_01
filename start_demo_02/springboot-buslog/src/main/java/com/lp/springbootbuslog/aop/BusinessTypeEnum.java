package com.lp.springbootbuslog.aop;

/**
 * @Author lipeng
 * @Date 2022/10/28 13:58
 * @Version 1.0
 */
public enum BusinessTypeEnum {

    /**
     * 其它
     */
    OTHER(0,"其它"),

    /**
     * 新增
     */
    INSERT(1,"新增"),

    /**
     * 修改
     */
    UPDATE(2,"修改"),

    /**
     * 删除
     */
    DELETE(3,"删除");

    private Integer code;

    private String message;

    BusinessTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}


