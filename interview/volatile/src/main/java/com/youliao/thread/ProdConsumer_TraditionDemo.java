package com.youliao.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Dali
 * @Date 2021/5/24 19:24
 * @Version 1.0
 * @Description :题目:一
 * 一个初始值为零的变量，两个线程对其交替操作，上 个加1一 个减1，5轮
 * <p>
 * 1  线程    操作（方法）      资源类
 * 2  判断    干活      通知
 * 3  防止虚假唤醒机制
 */

class ShareData {    //资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //1 判断
            while (number != 0) {
                //等待 不能生产
                condition.await();
            }
            //2 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  //释放锁资源
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            //1 判断
            while (number == 0) {
                //等待 不能生产
                condition.await();
            }
            //2 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  //释放锁资源
        }
    }
}

public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();  //做加法  生产
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();  //做减法  消费
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }
}
