package com.lp.springaspetcj.template;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/10/31 10:33
 * @Version 1.0
 */
@Data
public class ResponseTemplate {

    private String code;
    private String msg;
    private Object data;

    public ResponseTemplate() {
    }

    public ResponseTemplate(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseTemplate success(Object data){
        return new ResponseTemplate("200", "success", data);
    }
}
