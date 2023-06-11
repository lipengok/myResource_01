package com.lp.queue_demo.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lipeng
 * @Date 2023/5/29 9:47
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

    private String code;

    private String msg;

    private Object data;

    public ResponseModel success(Object data){
        return new ResponseModel("200", "success", data);
    }

    public ResponseModel error(Object data){
        return new ResponseModel("500", "error", data);
    }


}
