package main.java.com.youliao.study.spring;

/**
 * @Author Dali
 * @Date 2021/9/3 21:09
 * @Version 1.0
 * @Description
 */
public class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A() {
        System.out.println("---A created success");
    }
}

