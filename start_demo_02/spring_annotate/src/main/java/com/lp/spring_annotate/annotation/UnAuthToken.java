package com.lp.spring_annotate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * token跳过验证
 * value=true不需要验证
 * @Author lipeng
 * @Date 2023/1/11 14:43
 * @Version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UnAuthToken {
}
