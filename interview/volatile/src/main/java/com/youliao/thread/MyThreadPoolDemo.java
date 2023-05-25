package com.youliao.thread;

import java.util.concurrent.*;

/**
 * @Author Dali
 * @Date 2021/5/25 18:32
 * @Version 1.0
 * @Description : 第四种获得/使用Java多线程的方式————线程池
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //threadPoolInit(); //jdk版本
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                //new ThreadPoolExecutor.AbortPolicy());  //默认：终止策略
//                new ThreadPoolExecutor.CallerRunsPolicy());   // 调用者执行策略
//                new ThreadPoolExecutor.DiscardOldestPolicy());   // 抛弃队列中等待最久的任务
                new ThreadPoolExecutor.DiscardPolicy());   // 抛弃策略
        try {
            //模拟10个用户来办理业务，每个用户就是-一个来自外部的请求线程
            for (int i = 1; i <= 9; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void threadPoolInit() {
        //System.out.println(Runtime.getRuntime().availableProcessors());   获取CPU核数代码
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);   //一池5个处理线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();   //一池1个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool();   //一池N个处理线程
        try {
            //模拟10个用户来办理业务，每个用户就是-一个来自外部的请求线程
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
