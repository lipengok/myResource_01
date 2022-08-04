package com.lp.db_mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 手机状态枚举
 * @JsonFormat 注解为了解决枚举类返回前端只展示构造器名称的问题。
 * @Author lipeng
 * @Date 2022/8/4 13:56
 * @Version 1.0
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StateEnum implements IEnum<Integer> {

    SELLING(0, "正在热卖"),
    UNSELL(1, "还未发布"),
    SELLED(2, "已经售空");

    private Integer code;
    private String name;

    private StateEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return code;
    }

    public String getName() {
        return name;
    }
}
