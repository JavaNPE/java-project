package main.java.com.youliao.study.spring.setinjection;

import org.springframework.stereotype.Component;

/**
 * @Author Dali
 * @Date 2021/9/3 20:57
 * @Version 1.0
 * @Description
 */
@Component
public class ServiceB {

    private ServiceA serviceA;

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
        System.out.println("B 里面设置了A");
    }
}
