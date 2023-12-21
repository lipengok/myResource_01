package com.lp.quartz_simple.handler;

import com.alibaba.fastjson2.JSON;
import com.lp.quartz_simple.enity.Task;
import com.lp.quartz_simple.globe.SysGlobe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lipeng
 * @Date 2023/6/15 13:59
 * @Version 1.0
 */
@Slf4j
public class CommHandler implements Handler {

    /**
     * 根据任务类型分发分发任务
     */
    public void handler(Task task){
        int type = task.getType();
        switch (type){
            case 0:
                log.info("【任务】自动优化系统");
                break;
            case 1:
                log.info("【任务】查询所有用户");
                break;
            case 2:
                log.info("【任务】打印本机信息");
                log.info(JSON.toJSONString(SysGlobe.sysInfo));
                break;
            default:
                log.info("【任务】未识别的任务");
                break;
        }
    }
}
