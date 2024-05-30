package com.hediancha.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Dali
 * @Date 2021/8/9 15:14
 * @Version 1.0
 * @Description： 动态代理的举例
 */

interface Human {
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

//代理工厂
class ProxyFactory {
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj; //需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
/*        //method:极为代理类对象调用的方法，
        Object returnValue = method.invoke(obj, args);
        //上述方法的返回值，就当作当前类中的invoke（）的返回值
        return returnValue;*/

        HumanUtil util = new HumanUtil();
        util.method1();
        ;

        Object returnValue = method.invoke(obj, args);
        util.method2();

        return returnValue;

    }
}

class HumanUtil {
    public void method1() {
        System.out.println("===================================");
    }

    public void method2() {
        System.out.println("===================================");
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan(); //建造一个被代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();  //通过代理类对象调取我么们的信仰
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

        System.out.println("************************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}