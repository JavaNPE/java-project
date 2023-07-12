package main.java.com.youliao.study.spring;

/**
 * @Author Dali
 * @Date 2021/9/3 21:09
 * @Version 1.0
 * @Description
 */
public class ClientCode {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        a.setB(b);
        b.setA(a);
    }
}