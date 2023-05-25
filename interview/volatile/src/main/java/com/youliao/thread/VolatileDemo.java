package com.youliao.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Dali
 * @Date 2021/5/14 15:42
 * @Version 1.0
 * @Description :验证volatile的可见性;验证Volatile不保证原子性
 */

class MyData {
    //int number = 0;
    volatile int number = 0;    //volatile增强了 主内存和各线程之间的可见性

    public void addT060() {
        this.number = 60;
    }

    //请注意，此时number前面是加了volatile关键字修饰的，volatile不保证原子性
//    public synchronized void addPlusPlus() {    //添加synchronized测试  输出：“main	 finally number value: 20000”
    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1、验证volatile的可见性
 * 1.1 假如int number = 0;, number变量之前根本没有添加volatile关键字修饰 ,没有可见性
 * 1.2 添加了Volatile 可以解决可见性问题
 * <p>
 * 2.验证Volatile不保证原子性
 * 2.1原子性只得是什么意思？
 * 不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可呗加塞或者被分割，需要整体的完整
 * 要么同时成功，要么同时失败。
 * 2.3如何解决原子性？
 * 方式一：使用synchronized关键字（但是容易杀鸡用候刀，高射炮打蚊子）
 * 方式二：使用我们的juc下的AtomicInteger
 */
public class VolatileDemo {
    public static void main(String[] args) {
        //seOkByVolatile(); //验证volatile的可见性;
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();   //不保证原子性
                    myData.addAtomic();     //保证原子性
                }
            }, String.valueOf(i)).start();
        }

        //需要等待上面20个线程都全部计算完成后，在用main线程取得最终的结果值看是多少？
        while (Thread.activeCount() > 2) {  // >2  idea本身有一个 main线程
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t int type,finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type,finally number value: " + myData.atomicInteger);
/*        try {   //暂停一会线程
            TimeUnit.SECONDS.sleep(5);  //5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    //volatile可以保证可见性，及时通知其它线程，主物理内 存的值已经被修改。
    private static void seOkByVolatile() {
        MyData myData = new MyData();       //资源类
        new Thread(() -> {      //线程1 AAA
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);          //休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addT060();
            System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.number);
        }, "AAA").start();

        //第2个线程就是我们的main线程
        while (myData.number == 0) {
            // main线程就一一直再这里等待循环，直到number 值不再等于零。
        }
        System.out.println(Thread.currentThread().getName() + "\t 任务完成, main get number value:" + myData.number); //如果打印的是60 则感知 myData已被修改
    }
}


