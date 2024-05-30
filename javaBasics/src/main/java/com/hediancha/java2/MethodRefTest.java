package com.hediancha.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * <p>
 * Created by shkstart.
 */
public class MethodRefTest {

    // 情况一：对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1() {

        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");
        System.out.println("**************************");
        PrintStream ps = System.out;

        Consumer<String> con2 = ps::println;
        con2.accept("北京紫荆城");
        System.out.println("******************************");

        Consumer<String> con3 = System.out::println;
        con3.accept("王大力");
    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2() {

        Employee emp = new Employee(1001, "Tom", 23, 5600);

        //Lamboda表达式写法
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());
        System.out.println("****************************");

        //普通写法
        Supplier<String> sup2 = new Supplier<String>() {
            @Override
            public String get() {
                return emp.getName();
            }
        };
        System.out.println(sup2.get());
        System.out.println("****************************");

        //使用方法引用的方式写
        Supplier<String> sup3 = emp::getName;
        System.out.println(sup3.get());
    }

    // 情况二：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3() {
        Comparator<Integer> com2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(com2.compare(12, 32));
        System.out.println("************************");

        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 32));
        System.out.println("************************");

        Comparator<Integer> com3 = Integer::compareTo;
        System.out.println(com3.compare(12, 32));
    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4() {
        Function<Double, Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };

        System.out.println("******************");

        Function<Double, Long> func2 = d -> Math.round(d);
        Long apply = func2.apply(1.1);
        System.out.println(apply);
        System.out.println("******************");
        Function<Double, Long> fun3 = Math::round;
        System.out.println(fun3.apply(12.11));
    }

    // 情况三：类 :: 实例方法
    // Comparator中的int comapre(T t1,T t2)
    // String中的int t1.compareTo(t2)
    @Test
    public void test5() {
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abd"));
        System.out.println("**************");
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("bc", "bd"));
    }

    //BiPredicate中的boolean test(T t1, T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test6() {

        BiPredicate<String, String> pre1 = (s1, s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc", "abc"));

        System.out.println("************************");

        BiPredicate<String, String> pre2 = String::equals;
        System.out.println(pre2.test("abc", "abc"));
    }

    // Function中的R apply(T t)
    // Employee中的String getName();
    @Test
    public void test7() {
        Employee employee = new Employee(1001, "Jerry", 23, 6000);

        Function<Employee, String> fun3 = new Function<Employee, String>() {
            @Override
            public String apply(Employee e) {
                return e.getName();
            }
        };

        System.out.println(fun3.apply(employee));
        System.out.println("******************");

        Function<Employee, String> fun1 = e -> e.getName();
        System.out.println(fun1.apply(employee));
        System.out.println("******************");

        Function<Employee, String> fun2 = Employee::getName;
        System.out.println(fun2.apply(employee));
        System.out.println("=======================================================");

        Function<Employee,Double> fun4 = new Function<Employee, Double>() {
            @Override
            public Double apply(Employee ee) {
                return ee.getSalary();
            }
        };
        Function<Employee,Double> fun5 = ee->ee.getSalary();
        System.out.println(fun5.apply(employee));
        System.out.println("***************************");

        Function<Employee,Double> fun6 = Employee::getSalary;
        System.out.println(fun6.apply(employee));

    }

}
