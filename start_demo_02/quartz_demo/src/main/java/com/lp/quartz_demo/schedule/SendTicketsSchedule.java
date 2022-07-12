package com.lp.quartz_demo.schedule;

import com.lp.quartz_demo.globe.DataGlobe;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Schedule实现定时任务
 * 每隔一个时间段补发门票
 * @Author lipeng
 * @Date 2022/7/7 13:46
 * @Version 1.0
 */
@Component
public class SendTicketsSchedule {
    private final static Logger logger = Logger.getLogger(SendTicketsSchedule.class);

    // 5秒后开始执行，每隔10秒执行一次
    @Scheduled(initialDelay = 5 * 1000, fixedRate = 10 * 1000)
    public void execute(int num) {
        logger.info("原仓库中的票数【"+DataGlobe.ticket+"】");
        DataGlobe.ticket = DataGlobe.ticket + num;
        logger.info("当前仓库中的票数【"+DataGlobe.ticket+"】");
        // todo 将目前票缓存到redis中
    }
}
