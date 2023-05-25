package main.java.com.youliao.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * @Author Dali
 * @Date 2021/5/14 22:04
 * @Version 1.0
 * @Description
 */
public class LambdaTest {


    //从内名内部类到Lambda的转换实例1
    @Test
    public void test01() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!!!!");
            }
        };
        r1.run();
        System.out.println("***********************");
        Runnable r2 = () -> System.out.println("微信公众号：油料资源社！！！");
        r2.run();
    }

    //从匿名类到 Lambda 的转换举例2
    @Test
    public void test2() {
        //使用匿名内部类作为参数传递
    /*    TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });

        String compare1 = ts.higher("S11rer");
        System.out.println(compare1);
        */
        //使用匿名内部类作为参数传递
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println("***************");

        //Lambda表达式
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(12, 21);
        System.out.println(compare2);

        System.out.println("***************");

        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(12, 21);
        System.out.println(compare3);
    }
}
