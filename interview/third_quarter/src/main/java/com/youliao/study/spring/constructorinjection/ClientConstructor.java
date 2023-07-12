package main.java.com.youliao.study.spring.constructorinjection;

/**
 * @Author Dali
 * @Date 2021/9/3 18:51
 * @Version 1.0
 * @Description： 通过构造器的方式注入依赖，构造器的方式注入依赖的bean，下面两个bean循环依赖
 * <p>
 * 测试后发现，构造器循环依赖是无法解决的
 */
public class ClientConstructor {
    public static void main(String[] args) {
//        new ServiceA(new ServiceB(new ServiceA(new ServiceB())));
    }
}
