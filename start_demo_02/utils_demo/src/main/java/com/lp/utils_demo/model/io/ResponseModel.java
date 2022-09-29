package com.lp.utils_demo.model.io;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/9/27 10:28
 * @Version 1.0
 */
@Data
public class ResponseModel {

    private String code;

    private String msg;

    private Object data;

    public ResponseModel() {
    }

    public ResponseModel(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseModel success(){
        this.code = "200";
        this.msg = "success";
        this.data = null;
        return this;
    }
}
