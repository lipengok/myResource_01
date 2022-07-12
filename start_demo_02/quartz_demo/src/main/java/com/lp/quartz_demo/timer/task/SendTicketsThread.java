package com.lp.quartz_demo.timer.task;

import com.lp.quartz_demo.globe.DataGlobe;
import com.sun.istack.internal.logging.Logger;
import lombok.Data;

import java.util.TimerTask;

/**
 * @Author lipeng
 * @Date 2022/7/8 10:12
 * @Version 1.0
 */
@Data
public class SendTicketsThread extends TimerTask {
    private final static Logger logger = Logger.getLogger(SendTicketsThread.class);

    private volatile int ticketNum;
    private volatile String name;

    public SendTicketsThread(){
        super();
    }

    public SendTicketsThread(String name){
        this.name = name;
    }

    public SendTicketsThread(String name, int ticketNum){
        this.ticketNum = ticketNum;
        this.name = name;
    }

    @Override
    public void run(){
        logger.info("thread_name【"+this.getName()+"】");
        logger.info("原仓库中的票数【"+ DataGlobe.ticket+"】");
        DataGlobe.ticket = DataGlobe.ticket + ticketNum;
        logger.info("当前仓库中的票数【"+DataGlobe.ticket+"】");
        // todo 将目前票缓存到redis中
    }
}
