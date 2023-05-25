package com.youliao.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Dali
 * @Date 2021/5/25 16:18
 * @Version 1.0
 * @Description: java多线程中  获得多线程的方式
 */
//实现Runnable接口 通过实现Runnable接口获取多线程
/*class MyThread implements Runnable{   //没有返回值，且不带异常

    @Override
    public void run() {

    }
}*/

//实现Callable接口 通过实现Callable接口获取多线程
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {    //有返回值，且带异常。
        System.out.println("*******come in Callable******");
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());  //创建一个 FutureTask ，它将在运行时执行给定的 Callable 。
        Thread t1 = new Thread(futureTask, "AA");
        t1.start();

        int result01 = 100;
        int result02 = futureTask.get();    //如无必要建议放在最后
        System.out.println("*******result: " + (result01 + result02));
    }
}
