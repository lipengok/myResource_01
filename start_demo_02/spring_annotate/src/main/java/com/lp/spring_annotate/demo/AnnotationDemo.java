package com.lp.spring_annotate.demo;

import com.lp.spring_annotate.annotation.DemoAnnotation;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lipeng
 * @Date 2023/1/11 10:08
 * @Version 1.0
 */
@Slf4j
public class AnnotationDemo {

    @DemoAnnotation(objectId = "#uId")
    public void demo(String uId){
        log.info(uId);
    }
}
