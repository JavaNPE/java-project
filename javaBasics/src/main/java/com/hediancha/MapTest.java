package com.hediancha;

import org.junit.Test;

import java.util.*;

/**
 * @Author Dali
 * @Date 2021/8/6 17:44
 * @Version 1.0
 * @Description
 */
public class MapTest {
    @Test
    public void test5() {
        HashMap map = new HashMap();
        map.put("AA", 123);
        map.put(45, 1234);
        map.put("BB", 56);
        System.out.println("map:" + map);
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("************************");
        Collection values = map.values();
        for (Object obj : values) {
            System.out.println(obj);
        }
        System.out.println("************************");

        //遍历所有的key-value
        //方式一：entrySet
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "------>" + entry.getValue());
//            System.out.println(iterator1.next());
        }

        System.out.println("************************");

        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "========" + value);
        }

        System.out.println("************************");
        for (Object o : keySet) {
            System.out.println(o);
        }
    }

    @Test
    public void test4() {
        HashMap map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        System.out.println(map.get(45));
        boolean isExist = map.containsKey("BB");
        System.out.println("isExist:" + isExist);
        isExist = map.containsValue(123);
        System.out.println("isExist:" + isExist);
        map.clear();
        System.out.println(map.isEmpty());
    }

    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        //修改
        System.out.println("map：" + map);
        System.out.println("****************************");
        HashMap map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 123);
        System.out.println("map1：" + map1);
        map.putAll(map1);
        System.out.println("map+map1：" + map);
        System.out.println("****************************");
        Object value = map.remove("CC");
        System.out.println("value:" + value);
        System.out.println(map);

        map.clear();
        System.out.println(map.size());
        System.out.println(map);

    }


    @Test
    public void test2() {
        HashMap map = new HashMap();
        map = new LinkedHashMap();
        map.put(123, "AA");
        map.put(345, "BB");
        map.put(12, "CC");
        System.out.println(map);
    }

    @Test
    public void test1() {
        Map map = new HashMap();
//        Map map = new Hashtable();
        map.put(null, null);
        System.out.println(map);
    }
}
