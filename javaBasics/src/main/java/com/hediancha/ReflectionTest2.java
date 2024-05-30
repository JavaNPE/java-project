package com.hediancha;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Dali
 * @Date 2021/8/9 10:55
 * @Version 1.0
 * @Description: 调用运行时类中指定的结构：属性、方法、构造器
 */
public class ReflectionTest2 {

    /**
     * 调用运行时类中指定的结构：属性、方法、构造器： 不需要掌握
     *
     * @throws Exception
     */
    @Test
    public void testField() throws Exception {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        //System.out.println(p.toString()); Person{name='null', age=0, id=0} 此处重写了toString()方法
        Field id = clazz.getField("id");
        //System.out.println(id);
        id.set(p, 1001);
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    /**
     * 如何操作运行时类中的指定属性------需要掌握
     */
    @Test
    public void testField1() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        //1. getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "Tom");
        System.out.println(name.get(p));
    }

    @Test
    public void testMethod() throws Exception {
        Class<Person> clazz = Person.class;
//        System.out.println(clazz);
        //创建运行时类的对象
        Person p = clazz.newInstance();
//        System.out.println(p);

          /*
          1.获取指定的某个方法
          getDeclaredMethod():参数1 ：指明获取的方法的名称  参数2：指明获取的方法的形参列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);
        //2.保证当前方法是可以访问的
        show.setAccessible(true);

        /*
        3. 调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值。
        */
        Object returnValue = show.invoke(p, "CHN");
        System.out.println(returnValue);

        System.out.println("*************如何调用静态方法*****************");
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object returnVal = showDesc.invoke(Person.class);
        System.out.println(returnVal);

    }

    @Test
    public void testConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        System.out.println(constructor);
        constructor.setAccessible(true);
        Person tom = constructor.newInstance("Tom", 10);
        System.out.println(tom);
    }

}
