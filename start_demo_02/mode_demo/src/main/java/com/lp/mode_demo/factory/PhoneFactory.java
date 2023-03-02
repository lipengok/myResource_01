package com.lp.mode_demo.factory;

/**
 * 工厂模式--简单工厂
 * @Author lipeng
 * @Date 2023/3/1 11:04
 * @Version 1.0
 */
public class PhoneFactory {

    public static Phone product(int type){
        switch (type){
            case 1:
                return new OppoPhone();
            case 2:
                return new HuaweiPhone();
            default:
                return null;
        }
    }
}
