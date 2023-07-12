package com.youliao.bean;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2023/7/10 16:42
 * @Description:
 */
public class Student {
    private String name;
    private String sex;
    private Integer age;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", sex=" + sex + ", age=" + age + "]";
    }
}
