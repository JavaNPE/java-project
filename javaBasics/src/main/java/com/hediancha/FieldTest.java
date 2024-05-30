package com.hediancha;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Author Dali
 * @Date 2021/8/8 12:52
 * @Version 1.0
 * @Description
 */
public class FieldTest {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("****************");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
        System.out.println("****************");
    }

    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //1、获取权限修饰附
          /*  int modifiers = f.getModifiers();
            System.out.println(Modifier.toString(modifiers) + "\t");
            System.out.println("**********************");*/
/*            Class<?> type = f.getType();
            System.out.println(type.getName()+"\t");
            System.out.println("**********************");*/

            //获取变量名
            String name = f.getName();
            System.out.println(name);
        }
    }
}
