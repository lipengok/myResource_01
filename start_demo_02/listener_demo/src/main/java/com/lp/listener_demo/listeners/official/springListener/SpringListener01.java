package com.lp.listener_demo.listeners.official.springListener;

import com.lp.listener_demo.entity.User;
import com.lp.listener_demo.globe.DataGlobe;
import com.lp.listener_demo.listeners.official.MyEvent;
import com.lp.listener_demo.model.MyEventModel;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * spring完成beans的装在之后再执行的类，方法
 * @Author lipeng
 * @Date 2022/7/15 9:05
 * @Version 1.0
 */
@Component
public class SpringListener01 implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger log = Logger.getLogger(SpringListener01.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        MyEventModel myEventModel = new MyEventModel();
        myEventModel.setEventName("测试初始化项目");
        User user = new User();
        user.setId(9865456789L);
        user.setName("jack");
        myEventModel.setSource(user);
        DataGlobe.myEventModel = myEventModel;
        log.debug("【SpringListener01】=>"+event.getApplicationContext());
        MyEvent.execute(myEventModel);
    }
}
