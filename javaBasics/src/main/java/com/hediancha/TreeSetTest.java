package com.hediancha;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author Dali
 * @Date 2021/8/6 10:37
 * @Version 1.0
 * @Description
 */
public class TreeSetTest {
    @Test
    public void test1() {
        TreeSet set = new TreeSet();
        //失败：不能添加不同类的对象
/*        set.add(123);
        set.add(456);
        set.add("AA");
        set.add(new User("Tom",12));*/

        //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
