package com.lp.lock_demo.opt_pess_lock.opt;

import java.util.Random;

/**
 * @Author lipeng
 * @Date 2023/7/20 10:52
 * @Version 1.0
 */
public class TestCAS {
    public static void main(String[] args) {
        CompareAndSwap compareAndSwap = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    StringBuilder str = new StringBuilder();
                    Random random = new Random();
                    int expectedValue = compareAndSwap.getValue();
                    int newValue = random.nextInt(100);
                    boolean b = compareAndSwap.compareAndSet(expectedValue, newValue);
                    if (b){
                        str.append("线程：" + Thread.currentThread().getName() + "\n");
                        str.append("预期值：" + expectedValue + "\n");
                        str.append("更新值：" + newValue + "\n");

                        str.append("操作后数据：" + compareAndSwap.getValue() + "\n");
                        str.append("操作是否成功（预期值和更新前数据一致）：" + b + "\n");
                    }else {
                        str.append("操作失败");
                    }
                    System.out.println(str.toString());
                }
            }).start();
        }
    }
}


