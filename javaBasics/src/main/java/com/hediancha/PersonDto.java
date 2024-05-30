package com.hediancha;

/**
 * @Author Dali
 * @Date 2021/8/8 12:25
 * @Version 1.0
 * @Description
 */
@MyAnnotation(value = "hi")
public class PersonDto extends Creature<String> implements Comparable<String>, MyInterface {
    private String name;
    int age;
    public int id;

    public PersonDto() {
    }

    @MyAnnotation(value = "abc")
    private PersonDto(String name) {
        this.name = name;
    }

    public PersonDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests) {
        return interests;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    private static void showDesc() {
        System.out.println("我是一个可爱的人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
