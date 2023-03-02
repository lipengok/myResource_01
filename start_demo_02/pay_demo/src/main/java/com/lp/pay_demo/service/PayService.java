package com.lp.pay_demo.service;

import com.alipay.api.AlipayApiException;
import com.lp.pay_demo.config.AliPayBean;

/**
 * @Author lipeng
 * @Date 2023/2/23 10:41
 * @Version 1.0
 */
public interface PayService {

    String aliPay(AliPayBean aliPayBean) throws AlipayApiException;
}


