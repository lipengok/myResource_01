package com.lp.es_demo.enums;

/**
 * 返回信息
 * @Author lipeng
 * @Date 2022/7/19 9:59
 * @Version 1.0
 */
public enum Msg {

    COMMON_SUCCESS("成功");

    private String msg;

    private Msg(String msg){
        this.msg = msg;
    }

    public String value(){
        return msg;
    }
}
