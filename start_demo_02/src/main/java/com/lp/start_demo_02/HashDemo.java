package com.lp.start_demo_02;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author lipeng
 * @Date 2022/7/6 15:21
 * @Version 1.0
 */
public class HashDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL url1 = new URL("http://www.runoob.com/index.html?language=cn#j2se");
        URL url2 = new URL("http://www.runoob.com/index.html?language=cn#j2se");
        System.out.println("url1:"+url1);
        System.out.println("url2:"+url2);
        System.out.println("url1:"+url1.hashCode());
        System.out.println("url2:"+url2.hashCode());
    }
}
