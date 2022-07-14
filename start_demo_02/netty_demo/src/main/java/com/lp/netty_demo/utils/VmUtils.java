package com.lp.netty_demo.utils;

import com.lp.netty_demo.modle.template.ExceptionTemplate;

import java.net.*;
import java.util.*;

/**
 * @Author lipeng
 * @Date 2022/7/14 9:14
 * @Version 1.0
 */
public class VmUtils {

    // Windows/Linux获取本机ip地址
    public static Map<String,String> getIpAddress() {
        Map<String,String> map = new HashMap<>();
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            map.put(ip.getHostName(),ip.getHostAddress());
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(ExceptionTemplate.GET_IP_EXCEPTION.value() + e.toString());
        }
        return map;
    }

    public static void main(String[] args){
        System.out.println(getIpAddress());
    }
}
