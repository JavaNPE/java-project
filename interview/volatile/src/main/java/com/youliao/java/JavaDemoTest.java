package com.youliao.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author Dali
 * @Date 2021/5/17 19:12
 * @Version 1.0
 * @Description
 */
public class JavaDemoTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        String c = "ad";
        c.isEmpty();
        c.concat("c");
        System.out.println(c);
        System.out.println(c.equals("ad"));
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder("bgm");
        ArrayList<Object> objects = new ArrayList<>();
        LinkedList<Object> objects1 = new LinkedList<>();
        LinkedList<Object> objects2 = new LinkedList<>();
        new HashMap<>();

        stringBuilder.append(c);
        System.out.println(stringBuilder);

    }
}
