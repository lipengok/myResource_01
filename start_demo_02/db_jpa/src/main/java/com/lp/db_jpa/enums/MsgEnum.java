package com.lp.db_jpa.enums;

/**
 * @Author lipeng
 * @Date 2022/7/25 9:12
 * @Version 1.0
 */
public enum MsgEnum {
    COMMON_DEFAULT_MSG("失败"),
    COMMON_SUCCESS_MSG("成功");

    private String msg;

    private MsgEnum(String msg){
       this.msg = msg;
    }

    public String value(){
        return msg;
    }

}
