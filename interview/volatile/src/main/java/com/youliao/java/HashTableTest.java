package com.youliao.java;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Dali
 * @Date 2021/5/16 16:45
 * @Version 1.0
 * @Description
 */
public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();


        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
    }
}
