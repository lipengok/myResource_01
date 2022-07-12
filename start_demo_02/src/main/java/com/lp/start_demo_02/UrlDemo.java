package com.lp.start_demo_02;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author lipeng
 * @Date 2022/7/6 15:11
 * @Version 1.0
 */
public class UrlDemo {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.runoob.com/index.html?language=cn#j2se");
        System.out.println("URL 为：" + url.toString());
        System.out.println("协议为：" + url.getProtocol());
        System.out.println("验证信息：" + url.getAuthority());
        System.out.println("文件名及请求参数：" + url.getFile());
        System.out.println("主机名：" + url.getHost());
        System.out.println("路径：" + url.getPath());
        System.out.println("端口：" + url.getPort());
        System.out.println("默认端口：" + url.getDefaultPort());
        System.out.println("请求参数：" + url.getQuery());
        System.out.println("定位位置：" + url.getRef());
        System.out.println(url.hashCode());
    }
}
