package com.lp.jna_demo.service;

import com.lp.jna_demo.jna.OPLibrary;
import org.springframework.stereotype.Service;

/**
 * 调用c语言动态库的 “运算服务”
 *
 * @Author lipeng
 * @Date 2023/6/28 9:29
 * @Version 1.0
 */
@Service
public class OperateService {


    public int add(int a,int b){
        return OPLibrary.INSTANCE.Add(a, b);
    }
}
