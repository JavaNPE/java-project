package com.hediancha.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Author Dali
 * @Date 2021/8/9 16:50
 * @Version 1.0
 * @Description
 */
public class LambodaTest1 {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("给岁月以文明！");
            }
        };
        r1.run();
        System.out.println("*********************");

        Runnable r2 = () -> System.out.println("给岁月以文明！");
//        Runnable r2 = () -> { System.out.println("给岁月以文明！");};
        r2.run();
    }


    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");


        System.out.println("******************");
        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("一个是听得人当真了，一个是说的人当真了？");
        Consumer<String> con2 = (String s) -> System.out.println(s);
        con2.accept("一个是听得人当真了，一个是说的人当真了!!!");

    }

    @Test
    public void test3() {
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听得人当真了，一个是说的人当真了");

        System.out.println("*******************");
        Consumer<String> con2 = (s) -> System.out.println(s);
        con2.accept("一个是听得人当真了，一个是说的人当真了");
    }

    @Test
    public void test4() {
        ArrayList<String> list = new ArrayList<>();    //类型推断
        int[] arr = {1, 2, 3};  //类型推断
        for (int i : arr) {
            System.out.print(i);
        }
    }

    @Test
    public void test5() {
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听得人当真了，一个是说的人当真了");

        System.out.println("*****************************");
        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("一个是听得人当真了，一个是说的人当真了");
    }

    @Test
    public void test6() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        System.out.println(com1.compare(12, 21));    //12没有21大 输出-1
        System.out.println("***************************");

        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12, 21));    //12没有21大 输出-1

    }

    @Test
    public void test7() {
        Comparator<Integer> com1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12, 6));

        System.out.println("*************************");
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com1.compare(12, 6));
    }

    @Test
    public void test8() {
        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("一个是听得人当真了，一个是说的人当真了");
        Runnable r1 = ()-> System.out.println("ssssss");
        r1.run();

    }
}
