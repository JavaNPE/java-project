package com.youliao.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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


    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}
