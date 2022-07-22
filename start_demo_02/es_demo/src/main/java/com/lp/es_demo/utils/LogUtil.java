package com.lp.es_demo.utils;

import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * @Author lipeng
 * @Date 2022/7/19 14:21
 * @Version 1.0
 */
public class LogUtil implements Serializable {

    private final static Logger logger = Logger.getLogger(LogUtil.class);

    public Logger getLog(){
        return logger;
    }
}
