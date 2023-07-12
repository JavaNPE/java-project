package main.java.com.youliao.study.spring.setinjection;



/**
 * @Author Dali
 * @Date 2021/9/3 20:58
 * @Version 1.0
 * @Description
 */
public class ClientSet {
    public static void main(String[] args) {

        //创建serviceA
        ServiceA serviceA = new ServiceA();

        //创建serviceB
        ServiceB serviceB = new ServiceB();

        //将serviceA注入到serviceB中
        serviceB.setServiceA(serviceA);

        //将serviceB注入到serviceA中
        serviceA.setServiceB(serviceB);
    }
}
