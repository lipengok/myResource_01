package com.lp.pay_demo.service.impl;

import com.alipay.api.AlipayApiException;
import com.lp.pay_demo.config.AliPay;
import com.lp.pay_demo.config.AliPayBean;
import com.lp.pay_demo.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 支付服务接口
 *
 * @Author lipeng
 * @Date 2023/2/23 10:41
 * @Version 1.0
 */
@Service
public class PayServiceImpl implements PayService {

    /**日志对象*/
    private static final Logger logger = LoggerFactory.getLogger(PayServiceImpl.class);

    @Autowired
    private AliPay alipay;

    @Override
    public String aliPay(AliPayBean aliPayBean) throws AlipayApiException {
        logger.info("调用支付服务接口...");
        return alipay.pay(aliPayBean);
    }
}


