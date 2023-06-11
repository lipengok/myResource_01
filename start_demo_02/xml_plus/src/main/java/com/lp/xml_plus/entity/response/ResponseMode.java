package com.lp.xml_plus.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lipeng
 * @Date 2023/5/25 15:23
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMode {

    private String code;

    private String msg;

    private Object data;

    public ResponseMode success(Object data){
        return new ResponseMode("200", "success", data);
    }

    public ResponseMode error(Object data){
        return new ResponseMode("500", "error", data);
    }
}
