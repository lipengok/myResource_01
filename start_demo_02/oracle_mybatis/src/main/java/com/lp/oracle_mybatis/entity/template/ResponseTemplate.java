package com.lp.oracle_mybatis.entity.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lipeng
 * @Date 2023/6/5 14:41
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseTemplate {

    private String code;
    private String msg;
    private Object data;

    public ResponseTemplate success(Object data){
        return new ResponseTemplate("200", "success", data);
    }
    public ResponseTemplate success(String msg, Object data){
        return new ResponseTemplate("200", msg, data);
    }

    public ResponseTemplate error(Object data){
        return new ResponseTemplate("500", "error", data);
    }
    public ResponseTemplate error(String msg, Object data){
        return new ResponseTemplate("500", msg, data);
    }
}
