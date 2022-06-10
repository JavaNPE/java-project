package com.youliao.myCode;

import org.junit.Test;

/**
 * @Author Hedian tea
 * @Date 2022/6/9 20:24
 * @Version 1.0
 * @Description
 */
public class MyTest {
    @Test
    public void testStr() {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚 硅你";
        int i = str1.indexOf(str2);
        System.out.println(i);
    }
}
