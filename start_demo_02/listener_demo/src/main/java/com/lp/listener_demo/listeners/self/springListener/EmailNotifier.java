package com.lp.listener_demo.listeners.self.springListener;

import com.lp.listener_demo.listeners.self.EmailEvent;
import com.lp.listener_demo.utils.LogUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
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
            log.debug("【spring事件类型】=>EmailEvent");
        } else if (applicationEvent instanceof ContextRefreshedEvent){
            log.debug("【spring事件类型】=>ContextRefreshedEvent");
        } else {
            log.debug("【未知spring事件类型】");
        }
    }
}
