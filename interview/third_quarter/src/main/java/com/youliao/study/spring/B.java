package main.java.com.youliao.study.spring;

/**
 * @Author Dali
 * @Date 2021/9/3 21:09
 * @Version 1.0
 * @Description
 */
public class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }


    public B() {
        System.out.println("---B created success");

    }
}
