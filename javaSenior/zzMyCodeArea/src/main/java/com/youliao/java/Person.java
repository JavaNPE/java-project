package com.youliao.java;

/**
 * **1、调用方式**
 * <p>
 * 在外部调用静态方法时，可以使用 `类名.方法名` 的方式，也可以使用 `对象.方法名` 的方式，而实例方法只有后面这种方式。
 * 也就是说，**调用静态方法可以无需创建对象** 。
 * <p>
 * 不过，需要注意的是一般不建议使用 `对象.方法名` 的方式来调用静态方法。这种方式非常容易造成混淆，静态方法不属于类的某个对象而是属于这个类。
 * <p>
 * 因此，一般建议使用 `类名.方法名` 的方式来调用静态方法。
 *
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2023/9/20 15:31
 * @Description:
 */
public class Person {
    private String name;
    private Integer age;
    public static final String VALUE = "STATIC_VALUE";

    // 实例方法
    public void method() {
        //......
        System.out.println("我是一个实例方法");
    }

    // 静态方法
    public static void staticMethod() {
        //......
        Person person = new Person();
        // person.静态方法中无法访问成员变量
    System.out.println("我是一个静态方法");
    }

    public static void main(String[] args) {
        Person person = new Person();
        // 调用实例方法
        person.method();
        // 调用静态方法
        Person.staticMethod();
        // 静态
        System.out.println(Person.VALUE.equals("STATIC_VALUE"));

    }
}
