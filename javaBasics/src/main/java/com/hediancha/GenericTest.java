package com.hediancha;

import org.junit.Test;

import java.util.*;

/**
 * @Author Dali
 * @Date 2021/8/7 16:02
 * @Version 1.0
 * @Description
 */
public class GenericTest {
    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);

        //list.add("Tom");
/*        for (Object score : list) {
            int intScore = (int) score;
            System.out.println(intScore);
        }*/
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tom", 87);
        map.put("Jerry", 87);
        map.put("Jack", 67);
//        map.put(123,"ABC");
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println("key:" + key + "===" + "value:" + value);
            //System.out.println(next);
        }

    }

/*    @Test
    public void printCollection(Collection c) {
        Iterator i = c.iterator();
        for (int k = 0; k < c.size(); k++) {
            System.out.println(i.next());
        }
    }*/

    @Test
    public void printCollection(Collection<Object> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }
}
