package com.lp.db_mybatis.modle;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/6/24 14:14
 * @Version 1.0
 */
@Data
public class ResponseModel {

    String msg;
    String code;
    Object data;

    public ResponseModel(String msg, String code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
}
