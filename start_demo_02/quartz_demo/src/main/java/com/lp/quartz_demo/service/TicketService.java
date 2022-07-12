package com.lp.quartz_demo.service;

import com.lp.quartz_demo.entity.User;
import com.lp.quartz_demo.globe.DataGlobe;
import com.lp.quartz_demo.globe.ExceptionGlobe;
import com.lp.quartz_demo.modle.templates.TicketScheduleTemplate;
import com.lp.quartz_demo.thread.events.GrabTicketsThread;
import com.lp.quartz_demo.timer.SendTicketsTimer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @Author lipeng
 * @Date 2022/7/7 14:02
 * @Version 1.0
 */
@Service
public class TicketService {
    private final static Logger log = Logger.getLogger(TicketService.class);
    // 初始化仓库中的票数
    public void initTicketStore(int num){
        log.debug("初始化仓库中的票数【"+num+"】");
        DataGlobe.ticket = num;

        // todo 将目前票缓存到redis中

    }

    // 定时往仓库中添加/补发票
    public void sendTickets(TicketScheduleTemplate ticketScheduleTemplate){
        // schedule
        // sendTicketsSchedule.execute(num);
        // timer
        SendTicketsTimer sendTicketsTimer = new SendTicketsTimer();
        sendTicketsTimer.doTask(
                ticketScheduleTemplate.getDelay(),
                ticketScheduleTemplate.getScope(),
                ticketScheduleTemplate.getTicketNum(),
                ticketScheduleTemplate.getName());
    }

    // 消费票（支持高并发）
    public void buyTicket(User user) throws Exception {
        check(user);
        String name = user.getName();
        int tickets = DataGlobe.ticket;
        if (tickets <= 0){
            throw new Exception(ExceptionGlobe.NO_TICKETS_EXCEPTION);
        }
        new GrabTicketsThread(name).run();
    }

    // 获取当前仓库中的票数
    public int storeTickets(){
        int tickets = DataGlobe.ticket;
        return tickets;
    }

    // todo 修改票价格
    public void upTicketPrice(User user) throws Exception {
        check(user);
    }

    private boolean check(User user) throws Exception {
        if (null == user ){
            throw new Exception(ExceptionGlobe.USER_NULL_EXCEPTION);
        }
        // todo 验证用户是否有权限
        // todo 验证用户是否有档案
        // todo 验证用户是否有登录信息
        return true;
    }
}
