package com.lp.mode_demo.res_chain;

/**
 * @Author lipeng
 * @Date 2023/3/2 8:57
 * @Version 1.0
 */
public class FirstHandler extends Handler {
    @Override
    public void handlerRequest(String info) {
        if (info.length() > 10) {
            System.out.println("FirstHandler：" + info);
            getNext().handlerRequest(info);
        } else {
            if (getNext() == null) {
                System.out.println("没有处理者进行处理");
            }
        }
    }
}
