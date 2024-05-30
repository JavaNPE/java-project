package com.hediancha.java4;

/**
 * @Author Dali
 * @Date 2021/8/10 19:10
 * @Version 1.0
 * @Description
 */
public class Girl {
    private String name;

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl() {

    }

    public Girl(String name) {
        this.name = name;
    }
}
