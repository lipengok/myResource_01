package com.lp.listener_demo.utils;

import org.apache.log4j.Logger;

/**
 * @Author lipeng
 * @Date 2022/7/15 10:24
 * @Version 1.0
 */
public class LogUtil {
    private LogUtil(){}
    private static final Logger log = Logger.getLogger(LogUtil.class);

    public static Logger getLogger(){
        return log;
    }
}
