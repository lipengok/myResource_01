package com.lp.log4j_demo.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @Author lipeng
 * @Date 2022/7/6 9:56
 * @Version 1.0
 */
@Service
public class Log4jService {

    Logger logger = Logger.getLogger(Log4jService.class);

    public String debugDemo(Object object){
        logger.debug("获取对象【"+object+"】");
        return "success";
    }

    public String errorDemo(){
        String res = "default";
        try {
            int a = 10/0;
        }catch (Exception e){
            res = "success";
            logger.error(e);
        }
        return res;
    }
}
