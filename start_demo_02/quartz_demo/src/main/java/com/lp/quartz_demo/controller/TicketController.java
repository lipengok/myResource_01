package com.lp.quartz_demo.controller;

import com.lp.quartz_demo.entity.User;
import com.lp.quartz_demo.enums.CodeEnum;
import com.lp.quartz_demo.enums.MsgEnum;
import com.lp.quartz_demo.modle.response.BaseResponse;
import com.lp.quartz_demo.modle.templates.TicketScheduleTemplate;
import com.lp.quartz_demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lipeng
 * @Date 2022/7/7 14:59
 * @Version 1.0
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/init/{num}")
    public BaseResponse init(@PathVariable int num){
        ticketService.initTicketStore(num);
        return new BaseResponse(MsgEnum.INIT_STORE_SUCCESS.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), num);
    }

    @GetMapping("/getTickets")
    public BaseResponse storeTickets(){
        int tickets = ticketService.storeTickets();
        return new BaseResponse(MsgEnum.SELECT_SUCCESS.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), tickets);
    }

    @PostMapping("/sendTickets")
    public BaseResponse sendTickets(@RequestBody TicketScheduleTemplate ticketScheduleTemplate){
        ticketService.sendTickets(ticketScheduleTemplate);
        return new BaseResponse(MsgEnum.COMMAND_SUCCESS.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), null);
    }

    @PostMapping("/buy")
    public BaseResponse butTickets(@RequestBody User user) throws Exception {
        ticketService.buyTicket(user);
        return new BaseResponse(MsgEnum.COMMAND_SUCCESS.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), user);
    }
}
