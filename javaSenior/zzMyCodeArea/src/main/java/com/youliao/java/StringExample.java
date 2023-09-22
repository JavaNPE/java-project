package com.youliao.java;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2023/9/20 15:11
 * @Description:
 */
public class StringExample {
    // 字符型常量
    public static final char LETTER_A = 'A';

    // 字符串常量
    public static final String GREETING_MESSAGE = "Hello, world!";

    public static void main(String[] args) {
        System.out.println("字符型常量占用的字节数为：" + Character.BYTES);
        System.out.println("字符串常量占用的字节数为：" + GREETING_MESSAGE.getBytes().length);
    }
}
