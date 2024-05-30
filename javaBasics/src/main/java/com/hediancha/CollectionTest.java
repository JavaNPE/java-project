package com.hediancha;

import org.junit.Test;

import java.util.*;

/**
 * @Author Dali
 * @Date 2021/8/4 15:49
 * @Version 1.0
 * @Description Collection接口中声明的方法的测试
 * <p>
 * 结论：
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 */
public class CollectionTest {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
/*        Person p = new Person("Jerry",20);
        coll.add(p);*/
        coll.add(new Person("Jerry", 20));

        //1.contains(Object obj): 判断当前集合中是否包含obj
        boolean contains = coll.contains(123);  //true
        System.out.println(contains);   //true
        System.out.println(coll.contains(new String("Tom")));   //true
//        System.out.println(coll.contains(p));
        System.out.println(coll.contains(new Person("Jerry", 20)));
        //2. containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
        Collection coll1 = Arrays.asList(123, 4567);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2() {
        //3.remove(Object obj):从当前集合中移除obj元素。
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);
//        System.out.println(coll);
//        System.out.println(coll.toString());

//        for (Object o : coll) {
//            System.out.println(o);
//        }
/*        coll.remove(123);
        System.out.println(coll);   //[456, Person{name='Jerry', age=20}, Tom, false]
        coll.remove(new Person("Jerry",20));
        System.out.println(coll);*/

        //4. removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
        Collection coll1 = Arrays.asList(123, 456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);
/*        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123, 456, 789);
        coll.retainAll(coll1);
        System.out.println(coll);   //[123, 456]*/

        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素位置都相同。
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);
        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());
        System.out.println(coll);
        System.out.println("**************************");
        //8.集合 --->数组：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("**************************");
        //拓展：数组 --->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());
        System.out.println(arr1);

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());
        System.out.println(arr2);
    }

    @Test
    public void test6() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 1);
        map.put(3, 0);
        map.put(8, 2);
        Integer integer = map.get(2);
        System.out.println(integer);
    }

}
