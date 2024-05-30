package com.hediancha;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author Dali
 * @Date 2021/8/5 14:31
 * @Version 1.0
 * @Description: 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasNext() 和  next()
 */
public class IteratorTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);
        Iterator iterator = coll.iterator();
        //方式1：
        /*
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        //注意此处由于ArrayList只放了5个元素，我们以上也是只打印了5个元素，打印正常，但是我们在多打印一次，就会发现报错。
        System.out.println(iterator.next());    //java.util.NoSuchElementException
        */
/*        //方式2：
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }*/
        //方式3：
        //hasNext():判断是否还有下一个元素
        while (iterator.hasNext()) {
            //next():①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //删除集合中的“Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();
            }
        }
        //重新遍历一下集合
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
