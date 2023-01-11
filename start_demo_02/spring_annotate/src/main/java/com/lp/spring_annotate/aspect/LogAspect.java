package com.lp.spring_annotate.aspect;

import com.lp.spring_annotate.annotation.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2023/1/11 11:05
 * @Version 1.0
 */
@Slf4j
@Component
@Aspect
public class LogAspect {

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.lp.spring_annotate.annotation.LogAnnotation)")
    private void pointCut(){}

    /**
     * 通知
     * @param logValue 日志内容
     */
    @Before("pointCut() && @annotation(logValue)")
    private void advice(LogAnnotation logValue){
        log.info(logValue.value());
    }
}
