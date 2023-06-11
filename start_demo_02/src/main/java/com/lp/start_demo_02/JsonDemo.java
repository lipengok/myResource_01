package com.lp.start_demo_02;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.lp.start_demo_02.entity.Archives;
import com.lp.start_demo_02.entity.Archives2;

import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/8/9 16:43
 * @Version 1.0
 */
public class JsonDemo {
    public static void main(String[] args) {
//        String json = JSON.toJSONString(new Date());
//        System.out.println(json);
//        Date date = JSON.parseObject(json, Date.class);
//        System.out.println(date);


        Archives2 archives2 = new Archives2();
        archives2.setOptType((byte) 1);
        archives2.setProtocolNo("6");
        archives2.setTerminalAddr("576576576");
        String payload = JSON.toJSONString(archives2);

        Archives archives = JSONObject.parseObject(payload, Archives.class);
        System.out.println(archives.toString());
    }
}
