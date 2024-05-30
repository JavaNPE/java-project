package com.hediancha;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Dali
 * @Date 2021/8/9 0:03
 * @Version 1.0
 * @Description
 */
public class MethodTest {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("***************");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method method : declaredMethods) {

           /* Annotation[] annos = method.getAnnotations();
            for (Annotation anno : annos) {
                System.out.println(anno);
            }*/
            //System.out.println(Modifier.toString(method.getModifiers()) + "\t");
            //System.out.println(method.getReturnType().getName() + "\t");
            System.out.print(method.getName());
            System.out.print("(");

            //5、形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.println(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.println(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
        }


    }
}
