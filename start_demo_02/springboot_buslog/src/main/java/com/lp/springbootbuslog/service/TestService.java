package com.lp.springbootbuslog.service;

import com.lp.springbootbuslog.entity.SysLog;

/**
 * @Author lipeng
 * @Date 2022/10/28 14:17
 * @Version 1.0
 */
public interface TestService {

    int saveLog(SysLog event);
}
