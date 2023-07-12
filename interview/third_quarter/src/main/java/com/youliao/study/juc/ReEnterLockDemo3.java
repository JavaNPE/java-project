package main.java.com.youliao.study.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Dali
 * @Date 2021/9/2 14:06
 * @Version 1.0
 * @Description
 */
public class ReEnterLockDemo3 {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            //lock.lock();
            try {
                System.out.println("=======外层调用");
                lock.lock();
                try {
                    System.out.println("=======内层调用");
                } finally {
                    lock.unlock();
//                    lock.unlock();
                }
            } finally {
                //实现加锁次数和释放次数不一样
                //由于加锁次数和释放次数不一样，第二个线程始终无法获取到锁，导致一直在等待。
                lock.unlock();
                //lock.unlock();    //正在情况，加锁几次就要解锁几次
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("b thread----外层调用lock");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "b").start();
    }
}
