package main.java.com.youliao.study.spring.setinjection;

import org.springframework.stereotype.Component;

/**
 * @Author Dali
 * @Date 2021/9/3 20:57
 * @Version 1.0
 * @Description
 */
@Component
public class ServiceA {

    private ServiceB serviceB;

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
        System.out.println("A 里面设置了B");
    }
}
