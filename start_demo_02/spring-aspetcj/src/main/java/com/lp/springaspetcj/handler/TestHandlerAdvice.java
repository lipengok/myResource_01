package com.lp.springaspetcj.handler;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2022/10/31 10:37
 * @Version 1.0
 */
@Component
@Aspect
public class TestHandlerAdvice {

    Logger logger = Logger.getLogger(TestHandlerAdvice.class);

    @Pointcut("execution(* com.lp.springaspetcj.handler.TestHandler.run())")
    public void point(){}
    @Before("point()")
    public void before(){
        logger.debug("开始执行操作");
    }
    @After("point()")
    public void after(){
        logger.debug("操作执行结束");
    }

    // todo 为什么没有生效
    @Pointcut("execution(* com.lp.springaspetcj.service.TestService.addOne())")
    public void testPoint(){}
    @Before("testPoint()")
    public void testBefore(){
        logger.debug("开始插入一条数据");
    }
    @After("testPoint()")
    public void testAfter(){
        logger.debug("插入一条数据成功");
    }
}
