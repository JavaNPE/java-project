package com.youliao.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Dali
 * @Date 2021/5/23 11:28
 * @Version 1.0
 * @Description
 */
public class T1 {
    volatile int n = 0;

    public void add() {
        n++;
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(); //创建非公平锁
        Lock lock2 = new ReentrantLock(true); //创建公平锁
    }
}
