package com.youliao.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Dali
 * @Date 2021/5/20 17:56
 * @Version 1.0
 * @Description: 1.比较并交换   CASDemo代码
 * 2.CAS底层原理?如果知道，谈谈你对UnSafe的理解
 * 3.CAS缺点
 * 3
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        // main do thing....
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data: " + atomicInteger.get()); //5->2019  true	 current data: 2019
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data: " + atomicInteger.get()); //false	 current data: 2019
        atomicInteger.getAndIncrement();
    }
}


















