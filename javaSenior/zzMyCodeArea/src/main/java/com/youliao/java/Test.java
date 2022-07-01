package com.youliao.java;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author HedianTea
 * @Date 2022/6/30 11:00
 * @Version 1.0
 * @Description
 */
public class Test {

    @org.junit.Test
    public void bigDecimalTest() {
        BigDecimal a = BigDecimal.valueOf(4.00);
        BigDecimal b = BigDecimal.valueOf(10);
        BigDecimal c = BigDecimal.valueOf(4);

        if (BigDecimal.ZERO.compareTo(a) < 0) {
            System.out.println("------------------");
        }

        BigDecimal subtract = a.subtract(b).subtract(c).setScale(2, RoundingMode.HALF_UP);
        System.out.println(subtract);

        if (subtract.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("******************************");
            System.out.println(BigDecimal.ZERO);
        }
    }
}
