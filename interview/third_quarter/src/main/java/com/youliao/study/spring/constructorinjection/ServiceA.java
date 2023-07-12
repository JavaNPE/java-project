package main.java.com.youliao.study.spring.constructorinjection;

import org.springframework.stereotype.Component;

/**
 * @Author Dali
 * @Date 2021/9/3 18:50
 * @Version 1.0
 * @Description: 循环依赖
 */
@Component
public class ServiceA {
    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
