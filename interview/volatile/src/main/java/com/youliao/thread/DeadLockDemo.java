package com.youliao.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @Author Dali
 * @Date 2021/5/27 9:38
 * @Version 1.0
 * @Description: 死锁编码及定位分析
 * <p>
 * 死锁是指两个或两个以上的进程在执行过程中,
 * 因争夺资源而造成的一.种 互相等待的现象,
 * 若无外力干涉那它们都将无法推进下去
 */
class HoldLockThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获得：" + lockB);
            //暂停一会线程
            TimeUnit.SECONDS.sleep(2);
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockB + "\t 尝试获得：" + lockA);
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

//        new Thread(()->{ },"ThreadAAA").start();  Lambda表达式写法
        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();
        /**
         * Linux  ps -ef|grep XXXX  ls -l
         * Windows 下的java运行程序  也有类似的ps的查看进程的命令，但是目前我们需要查看的只是java
         *          jps = java ps   jps -l
         */
    }
}
