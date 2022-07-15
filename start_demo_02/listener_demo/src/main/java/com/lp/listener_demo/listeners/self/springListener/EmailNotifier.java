package com.lp.listener_demo.listeners.self.springListener;

import com.lp.listener_demo.listeners.self.EmailEvent;
import com.lp.listener_demo.utils.LogUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author lipeng
 * @Date 2022/7/15 10:21
 * @Version 1.0
 */
@Component
public class EmailNotifier implements ApplicationListener {
    private Logger log = LogUtil.getLogger();

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof EmailEvent) {
            EmailEvent emailEvent = (EmailEvent) applicationEvent;
            log.debug(emailEvent);
        }else {
            log.debug("事件属于spring框架自认事件");
        }
    }
}
