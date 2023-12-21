package com.lp.lock_demo.opt_pess_lock.opt;

/**
 * 比较并交换机制----乐观锁实现的机制
 *
 * @Author lipeng
 * @Date 2023/7/20 10:51
 * @Version 1.0
 */

public class CompareAndSwap {
    private int value;

    //获取内存值
    public synchronized int getValue() {
        return value;
    }

    /**
     * 比较并交换
     * @param expectedValue 预期值
     * @param newValue      更新值
     * @return
     */
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        //如果内存值和预期值一致，就替换
        if (oldValue == expectedValue) {
            this.value = newValue;
        }

        return oldValue;
    }

    /**
     * 比较期望值 和 原来的值是否一致
     * @param expectValue   预期值
     * @param newValue      更新值
     * @return
     */
    public synchronized boolean compareAndSet(int expectValue, int newValue) {
        return expectValue == compareAndSwap(expectValue, newValue);
    }
}

