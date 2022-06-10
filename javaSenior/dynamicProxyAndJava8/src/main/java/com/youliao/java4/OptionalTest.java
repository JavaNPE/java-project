package com.youliao.java4;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类：为了在程序中避免出现空指针异常而创建的。
 * https://www.bilibili.com/video/BV1Kb411W75N?p=686
 * 常用的方法：ofNullable(T t)
 * orElse(T t)
 *
 * @author HedianTea
 * @create 2020 下午 7:24
 */
public class OptionalTest {

    /**
     * Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
     * Optional.empty() : 创建一个空的 Optional 实例
     * Optional.ofNullable(T t)：t可以为null
     */
    @Test
    public void test1() {
        Girl girl = new Girl();
        // girl = null;
        // of(T t):保证t是非空的
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test1_1() {
        Boy boy = new Boy(new Girl("孙一宁"));
        Optional<Girl> girl = Optional.ofNullable(boy.getGirl());
        // 如果女朋友存在就打印女朋友的信息
        girl.ifPresent(System.out::println);
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
//        girl = null;   // 可以尝试放开，会有不同的结果
        //ofNullable(T t)：t可以为null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        System.out.println("------------------------");
        //orElse(T t1):如果单前的Optional内部封装的t是非空的，则返回内部的t.
        //如果内部的t是空的，则返回orElse()方法中的参数t1.
        Girl girl1 = optionalGirl.orElse(new Girl("赵丽颖"));
        System.out.println(girl1);
        System.out.println("-----------------------");
        girl1.setName("张麻子");
        System.out.println(girl1);
        Girl girl2 = Optional.ofNullable(girl).orElse(girl1);
        System.out.println(girl2);
    }

    @Test
    public void test2_2() {
        Boy boy = new Boy(new Girl("孙一宁"));     //[他的女朋友是：孙一宁]
        // Boy boy = new Boy();  //放开此处代码：会得到 【他的女朋友是：嫦娥】
        Optional<Girl> opt = Optional.ofNullable(boy.getGirl());
        System.out.println(opt);
        System.out.println("-------------------");
        // 如果有女朋友就返回他的女朋友[孙一宁]，否则只能欣赏“嫦娥”了
        Girl girl = opt.orElse(new Girl("嫦娥"));
        System.out.println("他的女朋友是：" + girl.getName());
    }


    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);

    }

    // 优化以后的getGirlName():  空指针异常优化
    public String getGirlName1(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }

        return null;

    }

    @Test
    public void test4() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);

    }

    // 使用Optional类的getGirlName():
    public String getGirlName2(Boy boy) {

        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        // 此时的boy1一定非空
        // 如果有女朋友就返回他的女朋友，否则只能欣赏“迪丽热巴”了
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));

        Girl girl = boy1.getGirl();

        // Optional.ofNullable(T t)：t可以为null
        Optional<Girl> girlOptional = Optional.ofNullable(girl);

        // girl1一定非空
        // 如果有女朋友就返回他的女朋友，否则只能欣赏“古力娜扎”了
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));

        return girl1.getName();
    }

    @Test
    public void test5() {
       /* Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("老张师"));
        String girlName = getGirlName2(boy);
        System.out.println(girlName);*/


        Boy boy = null; // 迪丽热巴      尝试依次放开
        boy = new Boy(); // 古力娜扎     尝试依次放开
        boy = new Boy(new Girl("李老师"));
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }
}
