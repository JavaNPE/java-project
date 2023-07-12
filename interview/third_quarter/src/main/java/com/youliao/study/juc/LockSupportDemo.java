package main.java.com.youliao.study.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Dali
 * @Date 2021/9/2 16:20
 * @Version 1.0
 * @Description: 要求: t1线程等待3秒钟，3秒钟后t2线程唤醒t1线程继续工作
 * <p>
 * 以下异常情况:
 * 2 wait方法和notify方法，两个都去掉同步代码块后看运行效果
 * 2.1 异常惰况
 * Exception in thread "t1" java.Lang.ILlegalLNonitorStateException at java.lang.Object.wait(Native Method)
 * Exception in thread "t2" java.lang.ILlegalWonitorStateException at java.lang.Object.notify(Native Method)
 * <p>
 * 2.2 结论
 * Object类中的wait、notify、notifyALlL用于线程等待和唤醒的方法，都必须在synchronized内部执行（必须用到关键字synchronized)
 * <p>
 * <p>
 * 3 将notify放在wait方法前先执行，t1先notify 了，3秒钟后t2线程再执行wait方法
 * 3.1程序一直无法结柬
 * 3.2结论
 * 先wait后notify、notifyall方法，等待中的线程才会被唤醒，否则无法唤醒
 */
public class LockSupportDemo {
    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();


    public static void main(String[] args) {
//        synchronizedWaitNotify();
//        lockAwaitSignal();

        Thread a = new Thread(() -> {


            System.out.println(Thread.currentThread().getName() + "\t" + "------come in" + System.currentTimeMillis());
            LockSupport.park(); //被阻塞。。。。等待通知或放行，他要通过需要许可证
            LockSupport.park(); //被阻塞。。。。等待通知或放行，他要通过需要许可证
            System.out.println(Thread.currentThread().getName() + "\t" + "------被唤醒" + System.currentTimeMillis());

        }, "a");
        a.start();
        //暂停3秒钟后
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread b = new Thread(() -> {
            LockSupport.unpark(a);
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t" + "------b线程发出唤醒通知");

        }, "b");
        b.start();
    }

    private static void lockAwaitSignal() {
        new Thread(() -> {
            //暂停3秒钟后
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //await()和signal()也要和lock.lock();和lock.unlock();组队出现
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "------被唤醒");
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }

    private static void synchronizedWaitNotify() {
        new Thread(() -> {
            //暂停几秒钟线程
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "-----被唤醒");
        }, "A").start();

        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "-----通知");
            }
        }, "B").start();
    }
}
