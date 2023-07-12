package main.java.com.youliao.study;

/**
 * @Author Dali
 * @Date 2021/11/8 20:30
 * @Version 1.0
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person("AA",12);
        System.out.println(person.toString());


        Person person1 = new Person();
        System.out.println(person1.toString());
    }
}
