package com.lp.pay_demo.controller;

import com.alipay.api.AlipayApiException;
import com.lp.pay_demo.config.AliPayBean;
import com.lp.pay_demo.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author lipeng
 * @Date 2023/2/23 13:43
 * @Version 1.0
 */
@Controller
@RequestMapping("/ali")
public class OrderController {

    /**日志对象*/
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private PayService payService;

    @RequestMapping("/pay")
    @ResponseBody
    public String alipay(String outTradeNo, String subject, String totalAmount, String body) throws AlipayApiException {

        logger.info("商户订单号为{},订单名称为{},付款金额为{},商品描述{}", outTradeNo, subject, totalAmount, body);
        AliPayBean alipayBean = new AliPayBean();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);

        return payService.aliPay(alipayBean);
    }

    @RequestMapping("/success")
    @ResponseBody
    public String success(){
        return "交易成功！";
    }

    @RequestMapping(value = "/index")
    public String payCoin(){
        return "index.html";
    }
}


