package com.lp.netty_demo.modle.response;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/7 14:01
 * @Version 1.0
 */
@Data
public class BaseResponse {

    private String msg;
    private String code;
    private Object data;

    public BaseResponse(String msg, String code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
}
