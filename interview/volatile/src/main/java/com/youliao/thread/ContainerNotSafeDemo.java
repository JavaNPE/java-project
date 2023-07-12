package main.java.com.youliao.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author Dali
 * @Date 2021/5/22 12:43
 * @Version 1.0
 * @Description ： 集合类不安全的问题
 * 1、ArrayList
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        //listNotSafe();
        //setNotSafe();
//        Map<String, String> map = new HashMap<>();//原始不安全类
//        Map<String, String> map = new ConcurrentHashMap<>();//解决HashMap不安全类方法1
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());//解决HashMap不安全类方法2
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        //        Set<String> set = new HashSet<>();  //原始测试
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());  //解决java.util.ConcurrentModificationException 方法1
        Set<String> set = new CopyOnWriteArraySet<>();  //解决java.util.ConcurrentModificationException 方法2
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
        new HashSet<>().add("a");       //思考：HashSet.add()的方法，只需要传递一个元素，而HashMap是需要传递 key-value键值对？
    }

    private static void listNotSafe() {
    /*        //写法1：
            List<String> list1 = Arrays.asList("a","b","c");
            list1.forEach(System.out::println);
            System.out.println("******************************");*/
/*        //写法2：
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (String element : list) {
            System.out.println(element);
        }*/

//        List<String> list = new Vector<>();       //方法1
//        List<String> list = Collections.synchronizedList(new ArrayList<>());    //方法2
        List<String> list = new CopyOnWriteArrayList<>();   //方法2
//        Collection;       //Collection 是一个接口，它是 Set、List 等容器的父接口；
//        Collections;      //工具类
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
