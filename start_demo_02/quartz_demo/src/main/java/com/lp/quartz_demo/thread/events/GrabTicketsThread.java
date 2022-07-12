package com.lp.quartz_demo.thread.events;

import com.lp.quartz_demo.globe.DataGlobe;
import org.apache.log4j.Logger;

/**
 * @Author lipeng
 * @Date 2022/7/7 10:22
 * @Version 1.0
 */
public class GrabTicketsThread extends Thread {
    private static Logger logger = Logger.getLogger(GrabTicketsThread.class);

    private static int ticketsNum = DataGlobe.ticket;

    public GrabTicketsThread(String name){
        super(name);
    }

    @Override
    public void run(){
        logger.info("***************开始抢票事件***************");

        synchronized (this){
            if (ticketsNum>1){
                ticketsNum--;
                logger.debug("用户【"+this.getName()+"】抢到【1】票，余票【"+ticketsNum+"】");
                // 更新虚拟机内存中的票数
                DataGlobe.ticket = ticketsNum;
                // todo 将剩余票缓存到redis中
                // todo 定时将票数从redis持久化到数据库中的仓库表
            }else {
                logger.debug("仓库中票已经没了");
            }
        }
    }
}
