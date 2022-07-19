package com.lp.filter_demo.client;

import com.lp.filter_demo.globe.DataGlobe;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 模拟客户端
 * @Author lipeng
 * @Date 2022/7/15 14:32
 * @Version 1.0
 */
public class SocketClient {
    public static void main(String[] args) throws Exception {
        // 创建socket
        Socket s = new Socket(DataGlobe.clientHost, DataGlobe.port);
        // 获得输入流
        InputStream in = s.getInputStream();

        //读取字节流
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = null;
        String res = "";
        while ((line = reader.readLine()) != null) {
            res += line;
        }
        System.out.println(res);

        in.close();
        s.close();
    }
}
