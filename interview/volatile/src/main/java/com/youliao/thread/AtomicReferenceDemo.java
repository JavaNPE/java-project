package com.youliao.thread;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Dali
 * @Date 2021/5/22 11:30
 * @Version 1.0
 * @Description : atomicReference原子引用
 */
@ToString
@AllArgsConstructor
class User {
    String userName;
    int age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("z3", 23);
        User li4 = new User("li4", 24);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t" + atomicReference.get().toString());
    }
}
