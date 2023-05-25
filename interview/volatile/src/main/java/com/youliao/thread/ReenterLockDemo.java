package com.youliao.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Dali
 * @Date 2021/5/23 12:12
 * @Version 1.0
 * @Description：可重入锁就是递归锁 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取到该锁的代码，在同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 * 也就是说：线程可以进入任何一个它已经拥有的锁所同步的代码块
 * ReentrantLock【美 /rɪˈentrənt  lɑːk/】 / Synchronized 就是一个典型的可重入锁
 * <p>
 * t1	 invoked sendSMS()                      t1线程在外层方法获取锁的时候
 * t1	 ##################invoked sendEmail()  t1在进入内层方法会自动获取锁
 * t2	 invoked sendSMS()
 * t2	 ##################invoked sendEmail()
 */

class Phone implements Runnable {

    //验证Synchronized 就是一个典型的可重入锁
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t ##################invoked sendEmail()");
    }

    //验证ReentrantLock是一个典型的可重入锁
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        lock.lock();        //加锁几次 就解锁几次
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        } finally {
            lock.unlock(); //加锁几次 就解锁几次
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ##################invoked set()");
        } finally {
            lock.unlock();
        }
    }
}

public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        try {   //暂停一会线程
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();


        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");
        t3.start();
        t4.start();
    }
}
