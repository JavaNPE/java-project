package com.youliao.enums;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

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

    ONE("NBCBZJD001", "直接贷001"),
    TWO("NBCBZJD002", "直接贷002"),
    THREE("NBCBZJD003", "直接贷003");

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
     * 根据编码code查找枚举
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
}

