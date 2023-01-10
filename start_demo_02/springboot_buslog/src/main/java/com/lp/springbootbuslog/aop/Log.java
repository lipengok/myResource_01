package com.lp.springbootbuslog.aop;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 * @Author lipeng
 * @Date 2022/10/28 13:57
 * @Version 1.0
 */
@Target(ElementType.METHOD) // 注解只能用于方法
@Retention(RetentionPolicy.RUNTIME) // 修饰注解的生命周期
@Documented
public @interface Log {

    String value() default "";
    /**
     * 模块
     */
    String title() default "test module";

    /**
     * 功能
     */
    BusinessTypeEnum businessType() default BusinessTypeEnum.OTHER;
}

