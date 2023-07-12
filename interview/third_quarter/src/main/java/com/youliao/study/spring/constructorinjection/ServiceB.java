package main.java.com.youliao.study.spring.constructorinjection;

import org.springframework.stereotype.Component;

/**
 * @Author Dali
 * @Date 2021/9/3 18:50
 * @Version 1.0
 * @Description
 */
@Component
public class ServiceB {
    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
