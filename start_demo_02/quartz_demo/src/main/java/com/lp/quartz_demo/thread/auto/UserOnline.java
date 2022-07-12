package com.lp.quartz_demo.thread.auto;

/**
 * 用户在线统计线程
 * @Author lipeng
 * @Date 2022/7/8 14:31
 * @Version 1.0
 */
public class UserOnline extends Thread{

    @Override
    public void run(){
        // todo 用户在线统计（定期从redis中拉取在线用户的信息）
    }
}
