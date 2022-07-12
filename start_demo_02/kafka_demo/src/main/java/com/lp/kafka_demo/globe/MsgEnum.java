package com.lp.kafka_demo.globe;

/**
 * @Author lipeng
 * @Date 2022/6/24 14:19
 * @Version 1.0
 */
public enum MsgEnum {
    SEND_SUCCESS("发送成功"),
    SELECT_SUCCESS("查询成功");

    private String msg;

    private MsgEnum(String msg) {
        this.msg = msg;
    }

    public String value() {
        return msg;
    }
}
