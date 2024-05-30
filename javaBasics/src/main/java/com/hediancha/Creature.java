package com.hediancha;

import java.io.Serializable;

/**
 * @Author Dali
 * @Date 2021/8/8 12:25
 * @Version 1.0
 * @Description
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }

}
