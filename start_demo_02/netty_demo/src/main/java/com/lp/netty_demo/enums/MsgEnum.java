package com.lp.netty_demo.enums;

/**
 * @Author lipeng
 * @Date 2022/7/7 14:53
 * @Version 1.0
 */
public enum MsgEnum {
    INIT_STORE_SUCCESS("初始化仓库成功"),
    INIT_STORE_DEFAULT("初始化仓库失败"),

    SEND_TICKETS_SUCCESS("补票成功"),
    SEND_TICKETS_DEFAULT("补票失败"),

    COMMAND_SUCCESS("指令成功"),
    COMMAND_DEFAULT("指令失败"),

    EXPORT_SUCCESS("导出成功"),
    EXPORT_DEFAULT("导出失败"),

    IMPORT_SUCCESS("导入成功"),
    IMPORT_DEFAULT("导入失败"),

    UPLOAD_SUCCESS("上传成功"),
    UPLOAD_DEFAULT("上传失败"),

    CREATE_SUCCESS("创建成功"),
    CREATE_DEFAULT("创建失败"),

    SELECT_SUCCESS("查询成功"),
    SELECT_DEFAULT("查询失败");

    private String msg;

    private MsgEnum(String msg){
        this.msg = msg;
    }

    public String value(){
        return msg;
    }
}
