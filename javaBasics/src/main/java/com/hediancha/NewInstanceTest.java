package com.hediancha;

import org.junit.Test;

import java.util.Random;

/**
 * @Author Dali
 * @Date 2021/8/8 12:02
 * @Version 1.0
 * @Description
 */
public class NewInstanceTest {
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Person obj = clazz.newInstance();
        System.out.println(obj);
    }

    @Test
    public void test2() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath="com.youliao.java.Person";
                break;
        }
        Object obj = getInstance(classPath);
        System.out.println(obj);
    }

    /**
     * 创建一个指定类的对象
     * @param classPath ：指定类的全类名
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();

    }
}
