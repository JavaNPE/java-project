package com.hediancha.java;

/**
 * @Author Dali
 * @Date 2021/8/9 12:56
 * @Version 1.0
 * @Description
 */
interface ClothFactory {
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory {
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    //代理类
    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");

    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxyTest{
    public static void main(String[] args) {
        ClothFactory nike = new NikeClothFactory();  //创建被代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);        //创建代理类的对象
        proxyClothFactory.produceCloth();   //通过代理类对象调用被代理对象的方法
    }
}
