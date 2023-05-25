package com.youliao.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author Dali
 * @Date 2021/5/22 11:54
 * @Version 1.0
 * @Description： ABA问题的解决   AtomicStampedReference(原子标记参考)
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        System.out.println("+++++++++++++++++++以下是ABA问题的产生++++++++++++++++++");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            //先暂停1秒中
            try {
                TimeUnit.SECONDS.sleep(1);  //暂停1秒t2线程，保证上面的t1线程完成了一次ABA操作
                System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
        //暂停2秒中让以上代码执行完成
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("+++++++++++++++++++以下是ABA问题的解决++++++++++++++++++");
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();  //获得初始版本号
            System.out.println(Thread.currentThread().getName() + "\t第1次版本号：" + stamp);
            //暂停1秒t3线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第2次版本号：" + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第3次版本号：" + atomicStampedReference.getStamp());


        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();  //获得初始版本号
            System.out.println(Thread.currentThread().getName() + "\t第1次版本号：" + stamp);
            //暂停3秒t4线程,保证上面的t3线程完成了一次ABA操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);

            System.out.println(Thread.currentThread().getName() + "\t 修改是否成功：" + result + "\t当前最新的实际版本号:" + atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + "\t当前实际最新值:" + atomicStampedReference.getReference());
        }, "t4").start();
    }
}
