package com.lp.login_jwt.temple;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/27 16:33
 * @Version 1.0
 */
@Data
public class ResponseTemplate {

    private String msg;
    private String code;
    private Object data;

    public ResponseTemplate(String msg, String code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
}
