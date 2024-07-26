package com.youliao.bean;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/7/18 9:11
 * @Description:
 */

import lombok.Data;

@Data
public class StudentInfo {

    //名称
    private String name;

    //性别 1 男, 2 女
    private String gender;

    //年龄
    private Integer age;

    //身高
    private Double height;

    //出生日期
    //private LocalDate birthday;

}

