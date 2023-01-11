package com.lp.spring_annotate.annotation;

import java.lang.annotation.*;

/**
 * @Author lipeng
 * @Date 2023/1/11 9:23
 * @Version 1.0
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DemoAnnotation {

    /**
     * 操作的目标资源的唯一ID， 支持EL表达式
     *
     * @return  ID
     */
    String objectId();
}
