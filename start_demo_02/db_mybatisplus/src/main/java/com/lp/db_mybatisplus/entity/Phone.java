package com.lp.db_mybatisplus.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.*;
import com.lp.db_mybatisplus.enums.StateEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author lipeng
 * @Date 2022/8/4 10:35
 * @Version 1.0
 */
@Data
@TableName("phone")
public class Phone {

    @TableId("id")
    private Integer id;

    @TableField("type")
    private String type;

    private String color;

    private Double price;

    private Integer phoneParamId;

    @TableLogic
    private int isDelete;

    @TableField("state")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private StateEnum state;

    // 自动填充必须手动启动
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "updateTime", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", phoneParamId=" + phoneParamId +
                ", isDelete=" + isDelete +
                ", state=" + state +
                '}';
    }
}
