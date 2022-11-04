package com.lp.springaspetcj.handler;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2022/10/31 10:37
 * @Version 1.0
 */
@Component
public class TestHandler implements Runnable{
    Logger logger = Logger.getLogger(TestHandler.class);

    @Override
    public void run() {
        logger.debug("开始查询");
    }
}
