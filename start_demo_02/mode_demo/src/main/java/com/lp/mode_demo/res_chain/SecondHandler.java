package com.lp.mode_demo.res_chain;


/**
 * @Author lipeng
 * @Date 2023/3/2 8:58
 * @Version 1.0
 */
public class SecondHandler extends Handler {
    @Override
    public void handlerRequest(String info) {
        if (info.contains("tom")) {
            System.out.println("SecondHandler：" + info);
        } else {
            if (getNext() != null) {
                getNext().handlerRequest(info);
            } else {
                System.out.println("没有处理者进行处理");
            }
        }
    }
}
