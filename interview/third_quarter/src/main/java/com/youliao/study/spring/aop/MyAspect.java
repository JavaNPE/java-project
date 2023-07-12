package main.java.com.youliao.study.spring.aop;

//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;

import org.junit.After;
import org.junit.Before;
import org.springframework.stereotype.Component;

/**
 * @Author Dali
 * @Date 2021/9/3 14:26
 * @Version 1.0
 * @Description
 */
@Aspect //指定一个类为切面类
@Component  //纳入spring容器管理
public class MyAspect {
    @Before("execution(public int com.zzyy.study.service.impl.CalcServiceImpl.*(..))")

    public void beforeNotify() {

        System.out.println("******** @Before我是前置通知MyAspect");

    }


    @After("execution(public int com.zzyy.study.service.impl.CalcServiceImpl.*(..))")

    public void afterNotify() {

        System.out.println("******** @After我是后置通知");

    }


    @AfterReturning("execution(public int com.zzyy.study.service.impl.CalcServiceImpl.*(..))")

    public void afterReturningNotify() {

        System.out.println("********@AfterReturning我是返回后通知");

    }


    @AfterThrowing("execution(public int com.zzyy.study.service.impl.CalcServiceImpl.*(..))")

    public void afterThrowingNotify() {

        System.out.println("********@AfterThrowing我是异常通知");

    }


    @Around("execution(public int com.zzyy.study.service.impl.CalcServiceImpl.*(..))")

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object retValue = null;

        System.out.println("我是环绕通知之前AAA");

        retValue = proceedingJoinPoint.proceed();

        System.out.println("我是环绕通知之后BBB");

        return retValue;

    }
}
