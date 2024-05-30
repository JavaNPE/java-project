package com.hediancha.java4;

import org.junit.Test;

import java.util.Optional;

/**
 * @Author Dali
 * @Date 2021/8/10 19:15
 * @Version 1.0
 * @Description
 */
public class OptionalTest {
    @Test
    public void test1() {
        Girl girl = new Girl();
//        girl=null;        //放开报空指针异常
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        System.out.println("*************");

        Girl girl1 = optionalGirl.orElse(new Girl("铁山靠"));
        System.out.println(girl1);
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

    public String getGirlName1(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                girl.getName();
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

    public String getGirlName2(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        // 如果有女朋友就返回他的女朋友，否则只能欣赏“迪丽热巴”了
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl = boy1.getGirl();
        //Optional.ofNullable(T t)：t可以为null
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        // 如果有女朋友就返回他的女朋友，否则只能欣赏“古力娜扎”了
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));
        return girl1.getName();
    }

    @Test
    public void test5() {
        Boy boy = null; //迪丽热巴      尝试依次放开
        boy = new Boy(); //古力娜扎     尝试依次放开
        boy = new Boy(new Girl("苍老师"));
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }

    @Test
    public void test1_1() {
        Boy boy = new Boy(new Girl("孙一宁"));
        Optional<Girl> girl = Optional.ofNullable(boy.getGirl());
        // 如果女朋友存在就打印女朋友的信息
        girl.ifPresent(System.out::println);
    }

    @Test
    public void test2_2() {
        Boy boy = new Boy(new Girl("孙一宁"));     //[他的女朋友是：孙一宁]
//        Boy boy = new Boy();  //放开此处代码：会得到 【他的女朋友是：嫦娥】
        Optional<Girl> opt = Optional.ofNullable(boy.getGirl());

        // 如果有女朋友就返回他的女朋友[孙一宁]，否则只能欣赏“嫦娥”了
        Girl girl = opt.orElse(new Girl("嫦娥"));
        System.out.println("他的女朋友是：" + girl.getName());
    }
}
