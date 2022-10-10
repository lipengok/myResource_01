package com.lp.socket_demo.template;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/10/9 15:53
 * @Version 1.0
 */
@Data
public class Response {

    private String code;
    private String msg;
    private Object data;

    public Response(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response() {
    }

    public Response success(){
        Response response = new Response();
        response.setCode("200");
        response.setMsg("success");
        response.setData(null);
        return response;
    }
}
