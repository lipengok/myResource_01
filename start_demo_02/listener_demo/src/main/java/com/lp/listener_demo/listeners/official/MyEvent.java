package com.lp.listener_demo.listeners.official;

import com.lp.listener_demo.model.MyEventModel;
import lombok.Data;
import org.apache.log4j.Logger;

/**
 * @Author lipeng
 * @Date 2022/7/15 8:49
 * @Version 1.0
 */
@Data
public class MyEvent{
    private static final Logger log = Logger.getLogger(MyEvent.class);

    private Object source;
    private String eventName;

    public MyEvent(Object source, String eventName) {
        this.source = source;
        this.eventName = eventName;
    }

    //这里是利用spring初始化来实现方法的加载
    public static void execute(MyEventModel myEventModel){
        log.debug("【MyEvent】=>"+myEventModel);
        MyEvent myEvent = new MyEvent(myEventModel.getSource(), myEventModel.getEventName());
    }

}
