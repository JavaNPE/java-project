package main.java.com.youliao.study;//package com.youliao.study;

/**
 * @Author Dali
 * @Date 2021/11/8 20:29
 * @Version 1.0
 * @Description
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
        System.out.println("午餐");
    }
}
