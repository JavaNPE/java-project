package com.youliao.java4;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * @Author HedianTea
 * @Date 2022/4/21 14:29
 * @Version 1.0
 * @Description： Optional使用案例
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Member> optional = getMemberByIdFromDB();
        optional.ifPresent(mem -> {
            System.out.println("会员姓名是：" + mem.getName());
        });
    }

    public static Optional<Member> getMemberByIdFromDB() {
        boolean hasName = true;
        if (hasName) {
            return Optional.of(new Member("沉默王二"));
        }
        return Optional.empty();
    }

    /**
     * 判断值是否存在：isPresent
     */
    @Test
    public void testOptional() {
        Optional<String> opt = Optional.of("测试Optional");
        System.out.println(opt.isPresent());    // true
        Optional<String> optOrNull = Optional.ofNullable(null);
        System.out.println(optOrNull.isPresent());  // false
    }

    /**
     * 非空表达式：ifPresent()
     */
    @Test
    public void testOptionalIfPresent() {
        Optional<String> optOrNull = Optional.ofNullable(null);
        if (optOrNull.isPresent()) {
            System.out.println(optOrNull.get().length());
        }
        Optional<String> opt = Optional.of("测试IfPresent()");
        opt.ifPresent(str -> System.out.println(str.length()));
    }

    /**
     * 设置获取默认值：orElse()
     */
    @Test
    public void testOptionOrElse() {
        // String nullName = null;
        String nullName = "王大力";
        String name = Optional.ofNullable(nullName).orElse("测试orElse()");
        System.out.println(name);
    }

    /**
     * 设置获取默认值：orElseGet()
     */
    @Test
    public void testOptionOrElseGet() {
        String nullName = null;
        // String nullName = "王大力";
        String name = Optional.ofNullable(nullName).orElseGet(() -> "测试orElseGet");
        System.out.println(name);
    }


    public static String getDefaultValue() {
        System.out.println("getDefaultValue()方法执行了");
        return "沉默王二";
    }

    /**
     * 设置获取默认值：orElse 和 orElseGet比较 （二者谁的效率高）
     */
    @Test
    public void testOrElseAndOrElseGet() {
        // String name = null;
        String name = "守得云开见月明";
        System.out.println("orElse");
        String name2 = Optional.ofNullable(name).orElse(getDefaultValue());
        System.out.println(name2);
        System.out.println("orElseGet");
        String name3 = Optional.ofNullable(name).orElseGet(OptionalDemo::getDefaultValue);
        System.out.println(name3);
    }

    @Test
    public void testOptionalGet() {
        String name = null;
        String optOrNull = Optional.ofNullable(name).orElseGet(() -> "name为空了！！！");
//        String s = Optional.ofNullable(name).orElse("为null了");
        System.out.println(optOrNull);
    }

    /**
     * 过滤值： filter
     */
    @Test
    public void testFilter() {
        String password = "12345";
        Optional<String> pwd = Optional.ofNullable(password);
        boolean present = pwd.filter(str -> str.length() > 6).isPresent();
        System.out.println(present);
    }

    /**
     * 过滤值： filter()
     */
    @Test
    public void testFilter2() {
        Predicate<String> len6 = pwd -> pwd.length() > 6;
        Predicate<String> len10 = pwd -> pwd.length() < 10;

        String password = "1234567";
        Optional<String> pwd = Optional.ofNullable(password);
        boolean present = pwd.filter(len6.and(len10)).isPresent();
        System.out.println(present);
    }

    /**
     * 转换值：map()
     */
    @Test
    public void testMap() {
        String name = "王二花撒";
        Optional<String> nameOptional = Optional.of(name);
        Optional<Integer> integer = nameOptional.map(String::length);
        System.out.println(integer.orElse(0));
    }

    /**
     * 过滤值： filter() 和 转换值：map()
     */
    @Test
    public void testFilterAndMap() {
        String password = "PASSWORD";
        Optional<String> opt = Optional.ofNullable(password);

        Predicate<String> len6 = pwd -> pwd.length() > 6;
        Predicate<String> len10 = pwd -> pwd.length() < 10;
        Predicate<String> eq = pwd -> pwd.equals("password");

        boolean present = opt.map(String::toLowerCase).filter(len6.and(len10).and(eq)).isPresent();
        System.out.println(present);
    }

}


class Member {
    private String name;

    public String getName() {
        return name;
    }

    public Member(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



