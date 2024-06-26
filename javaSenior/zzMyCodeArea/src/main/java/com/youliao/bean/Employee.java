package com.youliao.bean;

import com.youliao.java.Person;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2022/9/28 21:00
 * @Description: 职工
 */
@Data
@Getter
@Setter
public class Employee implements Comparable<Employee> {
    private String name;
    private String id;
    private Double salary;
    private BigDecimal repayLateFee = BigDecimal.ZERO;
    // 成员变量
    private int num;
    private Person person;


    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    public void fun(String name) {
        System.out.println("name:" + name);
    }

    public void fun(String name, String id) {
        System.out.println("name:" + name + "," + "id:" + id);
    }

    public void fun(String name, String id, Double salary) {
        System.out.println("name:" + name + "," + "id:" + id + "," + salary);
    }

    public void fun(String name, Double salary, String productId) {
        System.out.println("name:" + name + "," + "id:" + id + "," + salary);
    }
}
