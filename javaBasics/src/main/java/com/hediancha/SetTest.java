package com.hediancha;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author Dali
 * @Date 2021/8/5 18:57
 * @Version 1.0
 * @Description
 */
public class SetTest {
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for (Object o : set) {
            System.out.println(o);
        }
    }
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    //面试题：
    @Test
    public void test3(){

        HashSet set = new HashSet();
        Person p1 = new Person("AA", 1001);
        Person p2 = new Person("BB", 1002);
        set.add(p1);
        set.add(p2);
        p1.setName("CC");
//        System.out.println(set);
        set.remove(p1);
        System.out.println(set);    //[Person{name='BB', age=1002}]
        set.add(new Person("CC",1001));
        System.out.println(set);
        set.add(new Person("AA",1001));
    }
}
