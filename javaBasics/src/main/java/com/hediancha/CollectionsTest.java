package com.hediancha;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Dali
 * @Date 2021/8/7 15:17
 * @Version 1.0
 * @Description
 */
public class CollectionsTest {
    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);
        System.out.println(list);
        //Collections.reverse(list);
        //Collections.shuffle(list);
//        Collections.sort(list);
//        Collections.swap(list,1,2);
        int frequency = Collections.frequency(list, 123);
        System.out.println("LIST:" + list);
        System.out.println(frequency);
    }
    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());
        Collections.copy(dest,list);
        System.out.println(dest);

        List list1 = Collections.synchronizedList(list);
    }
}
