package com.youliao.enums;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author HedianTea
 * @Date 2021/12/22 10:19
 * @Version 1.0
 * @Description
 */
@Getter
@AllArgsConstructor
public enum NumberForCaseEnum {

    ONE("NBCBZJD001", "直接贷"),
    TWO("NBCBZJD002", "直接贷（保险）"),
    THREE("NBCBZJD003", "直接贷B"),
    ;

    private String code;
    private String description;

    /**
     * 获取产品码值列表
     *
     * @return
     */
    public static List<String> getProductCodes() {
        return getProductIds().stream().map(NumberForCaseEnum::getCode).collect(Collectors.toList());
    }

    /**
     * 获取产品列表
     *
     * @return
     */
    private static List<NumberForCaseEnum> getProductIds() {
        return Lists.newArrayList(NumberForCaseEnum.ONE, NumberForCaseEnum.TWO);
    }

    /**
     * 方式一：根据编码code查找枚举
     * 提前判断，用于解决
     * Case中出现的Constant expression required
     *
     * @param code 编码
     * @return NumberForCaseEnum实例
     */
    public static NumberForCaseEnum getByCode(String code) {
        for (NumberForCaseEnum instance : NumberForCaseEnum.values()) {
            if (instance.getCode().equals(code)) {
                return instance;
            }
        }
        return null;
    }

    /**
     * 方式二：根据编码code查找枚举
     *
     * @param code
     * @return
     */
    public static NumberForCaseEnum find(String code) {
        return Arrays.stream(NumberForCaseEnum.values())
                .filter(input -> input.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    /**
     * 类型二：通过枚举名称查询对应的枚举值
     * numberForCaseEnum.name() 的值 是 ONE、TWO、THREE枚举值（若这些定义的枚举值与入参String name和其code值 一致的话好说）
     *
     * @param name
     * @return
     */
    public static NumberForCaseEnum findByName(String name) {
        for (NumberForCaseEnum numberForCaseEnum : NumberForCaseEnum.values()) {
            if (StringUtils.equals(numberForCaseEnum.name(), name)) {
                return numberForCaseEnum;
            }
        }
        return null;
    }

    /**
     * 类型二：通过枚举对应的枚举描述查找其code值
     *
     * @param description
     * @return
     */
    public static NumberForCaseEnum findByDesc(String description) {
//        NumberForCaseEnum[] values = NumberForCaseEnum.values();
        for (NumberForCaseEnum instance : NumberForCaseEnum.values()) {
/*            if(instance.getDescription().equals(description)) {
                return instance;
            }*/
            if(StringUtils.equals(description, instance.getDescription())) {
                return instance;
            }
        }
        return null;
    }

    public static NumberForCaseEnum findByDescStream(String desc) {
        return Arrays.stream(NumberForCaseEnum.values())
                .filter(e -> e.getDescription().equals(desc))
                .findFirst()
                .orElse(null);
    }
}

