package com.lp.quartz_demo.initSystem;

import com.lp.quartz_demo.globe.ObjectGlobe;
import com.lp.quartz_demo.thread.auto.RedisPersistent;
import com.lp.quartz_demo.thread.auto.TicketStoreFlush;
import com.lp.quartz_demo.thread.auto.UserOnline;

/**
 * 自动任务总线
 * @Author lipeng
 * @Date 2022/7/8 14:22
 * @Version 1.0
 */
public class AutoTaskThread extends Thread {

    public AutoTaskThread(String name){
        super(name);
    }

    @Override
    public void run(){
        ObjectGlobe.cachedThreadPool.execute(new RedisPersistent());
        ObjectGlobe.cachedThreadPool.execute(new UserOnline());
        ObjectGlobe.cachedThreadPool.execute(new TicketStoreFlush());
    }
}
