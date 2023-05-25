package com.youliao.java;

/**
 * @Author Dali
 * @Date 2021/5/14 21:14
 * @Version 1.0
 * @Description :单例模式在多线程环境下可能存在安全问题
 */
public class SingletonDemo {
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo()");
    }

    //DCL（Double Check Lock双端检索机制）
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
            //  instance = new SingletonDemo();
        }
        return instance;
    }

    public static void main(String[] args) {

        //单线程（main线程的操作动作）
//        System.out.println(SingletonDemo.getInstance() ==  SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() ==  SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() ==  SingletonDemo.getInstance());
//        System.out.println();
//        System.out.println();
//        System.out.println();

        //并发多线程后，情况发生了很大的变化
        for (int i = 0; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
