package com.hediancha.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 * <p>
 * 二、数组引用
 * <p>
 * <p>
 * Created by shkstart
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    @Test
    public void test1() {
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());

        System.out.println("*************");

        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());

        System.out.println("*************");
        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());

    }

    //Function中的R apply(T t)
    @Test
    public void test2() {
        Function<Integer, Employee> fun = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer id) {
                return new Employee(id);
            }
        };
        System.out.println(fun.apply(1001));

        System.out.println("**********************************");

        Function<Integer, Employee> fun1 = id -> new Employee(id);
        Employee employee = fun1.apply(1001);
        System.out.println(employee);

        System.out.println("**********************************");
        Function<Integer, Employee> fun2 = Employee::new;
        System.out.println(fun2.apply(1001));
    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3() {
        BiFunction<Integer, String, Employee> func = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer id, String name) {
                return new Employee(id, name);
            }
        };
        System.out.println(func.apply(1001, "Tom"));

        System.out.println("*************************");

        BiFunction<Integer, String, Employee> func1 = (id, name) -> new Employee(id, name);
        System.out.println(func1.apply(1001, "Toms"));

        System.out.println("*************************");

        BiFunction<Integer, String, Employee> fun2 = Employee::new;
        System.out.println(fun2.apply(1002, "Tom"));

    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4() {

        Function<Integer, String[]> fun = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer length) {
                return new String[length];
            }
        };
        System.out.println(Arrays.toString(fun.apply(5)));

        System.out.println("*******************");

        Function<Integer, String[]> fun1 = Length -> new String[Length];
        String[] arr1 = fun1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("*******************");

        Function<Integer, String[]> fun2 = String[]::new;
        String[] apply = fun2.apply(10);
        System.out.println(Arrays.toString(apply));

    }
}
