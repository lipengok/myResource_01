package com.lp.swagger_demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/6/29 14:52
 * @Version 1.0
 */
@Data
@ApiModel
public class User {
    @ApiModelProperty(value = "用户id")
    private Integer id;
    @ApiModelProperty(value = "用户名称")
    private String name;
    @ApiModelProperty(value = "用户密码")
    private String psw;
    @ApiModelProperty(value = "用户简介")
    private String information;
    @ApiModelProperty(value = "用户头像地址")
    private String photo;
    @ApiModelProperty(value = "用户毕业院校")
    private String school;
}
