package com.lp.mode_demo.res_chain;

/**
 * 责任链模式
 *
 * @Author lipeng
 * @Date 2023/3/2 8:53
 * @Version 1.0
 */
public abstract class Handler {

    private Handler next;

    public void setNext(Handler next){
        this.next = next;
    }

    public Handler getNext(){
        return this.next;
    }

    // 处理请求
    public abstract void handlerRequest(String info);
}
