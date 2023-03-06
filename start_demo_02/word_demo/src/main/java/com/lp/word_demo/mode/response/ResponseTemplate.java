package com.lp.word_demo.mode.response;

/**
 * @Author lipeng
 * @Date 2023/3/3 9:45
 * @Version 1.0
 */
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
