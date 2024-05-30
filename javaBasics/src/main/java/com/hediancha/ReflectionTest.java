package com.hediancha;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Dali
 * @Date 2021/8/7 20:48
 * @Version 1.0
 * @Description
 */
public class ReflectionTest {
    //反射之前对于person类的操作

    @Test
    public void test1() {
        Person p1 = new Person("Tom", 12);
        //p1.age = 10;
        System.out.println(p1.toString());
        //p1.show();

    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
        Person obj = cons.newInstance("Tom", 12);
        System.out.println(obj.toString());


        Field age = clazz.getDeclaredField("age");
        age.set(obj, 10);
        System.out.println(obj.toString());

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(obj);


        System.out.println("*******************************");
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = cons1.newInstance("Jerry");
        System.out.println(p1);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "HanMeimei");
        System.out.println(p1);

        System.out.println("*******************************");
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object nation = showNation.invoke(p1, "中国");
        System.out.println(nation);
    }

    @Test
    public void test3() throws ClassNotFoundException {
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);
        Class<?> clazz3 = Class.forName("com.youliao.java.Person");
        System.out.println(clazz3);
    }

    @Test
    public void test4() {
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class<String[]> c3 = String[].class;
        Class<int[][]> c4 = int[][].class;
        Class<ElementType> c5 = ElementType.class;
        Class<Override> c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class<? extends int[]> c10 = a.getClass();
        Class<? extends int[]> c11 = b.getClass();
        System.out.println(c10 == c11);
        System.out.println(c1);
    }

    //通配符的使用
    @Test
    public void test5() {
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;
        list = list1;
        list = list2;
//        print(list1);
//        print(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        System.out.println(list);   //[AA, BB, CC]
//        list.add("DD");
        list.add(null);
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
