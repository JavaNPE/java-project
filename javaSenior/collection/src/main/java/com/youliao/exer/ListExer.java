package com.youliao.exer;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HedianTea
 * @create 2020 下午 3:33
 */
public class ListExer {
    /*
    区分List中remove(int index)和remove(Object obj)
     */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }

    private void updateList(List list) {
//        list.remove(2);
        list.remove(new Integer(2));
    }
    @Test
    public void testGuava() {
        ArrayList<Object> objects = Lists.newArrayList();
        if (objects == null) {
            System.out.println("----------");
        }
        if (objects.size() == 0) {
            System.out.println("===========");
        }
        List<Object> obj = null;
        if (obj == null) {
            System.out.println("????????????");
        }
        System.out.println(objects);
    }
}
