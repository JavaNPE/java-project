package com.hediancha;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Dali
 * @Date 2021/8/4 16:51
 * @Version 1.0
 * @Description: 区分List中remove(int index)和remove(Object obj)
 */
public class ListExer {
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private void updateList(List list) {
        //list.remove(2);    //[1,2]      移动索引为2的内容元素
        list.remove(new Integer(2));       //[1, 3]   remove(new Integer(2)): 将集合中的2移去
        //list.remove(new Integer(4));          //[1, 2, 3] remove(new Integer(4)): 将集合中的4移去，但是集合中并没有4所以，打印出来的还是[1,
        // 2, 3]
    }
}
