package com.lp.socket_demo.socket;


import org.apache.log4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author lipeng
 * @Date 2022/10/8 10:18
 * @Version 1.0
 */
public class DemoSocket {
    private static Logger logger = Logger.getLogger(DemoSocket.class);

    public static void main(String[] args) throws UnknownHostException {
//        InetAddress inetAddress = getHost("www.baidu.com");
//        System.out.println(inetAddress.getHostName());
//        System.out.println(inetAddress.getAddress());


    }

    // 获得本机的InetAddress对象
    private static InetAddress getLocal() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        return localHost;
    }

    // 根据指定的主机名获得InetAddress对象，本机主机名：DESKTOP-T987IHU
    private static InetAddress getLocal(String hostName) throws UnknownHostException {
        InetAddress localHost = InetAddress.getByName(hostName);
        return localHost;
    }

    // 根据域名返回对应的InetAddress对象
    private static InetAddress getHost(String hostName) throws UnknownHostException {
        InetAddress host = InetAddress.getByName(hostName);
        return host;
    }
}
