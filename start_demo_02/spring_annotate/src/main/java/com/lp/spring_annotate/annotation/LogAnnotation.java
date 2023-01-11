package com.lp.spring_annotate.annotation;

import java.lang.annotation.*;

/**
 * 注解：
 * 添加操作日志
 *
 * @Author lipeng
 * @Date 2023/1/11 11:00
 * @Version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAnnotation {

    String value() default ""; // 默认值位""
}
