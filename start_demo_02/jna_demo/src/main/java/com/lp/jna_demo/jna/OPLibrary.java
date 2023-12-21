package com.lp.jna_demo.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * C语言动态链接库的 Java映射
 *
 * @Author lipeng
 * @Date 2023/6/28 9:59
 * @Version 1.0
 */
public interface OPLibrary extends Library {

    // TEST.dll C语言动态链接库
    OPLibrary INSTANCE = (OPLibrary) Native.loadLibrary("TEST" , OPLibrary.class);

    int Add(int a,int b);
    int Sub(int a,int b);
}
