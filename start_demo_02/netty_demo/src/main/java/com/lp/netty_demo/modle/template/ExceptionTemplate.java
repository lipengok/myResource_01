package com.lp.netty_demo.modle.template;

/**
 * @Author lipeng
 * @Date 2022/7/14 9:17
 * @Version 1.0
 */
public enum  ExceptionTemplate {
    GET_IP_EXCEPTION("IP地址获取失败");

    private String exception;
    private ExceptionTemplate(String exception){
        this.exception = exception;
    }

    public String value(){
        return this.exception;
    }

}
