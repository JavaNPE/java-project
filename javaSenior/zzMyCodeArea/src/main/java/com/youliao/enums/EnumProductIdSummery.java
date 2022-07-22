package com.youliao.enums;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author HedianTea
 * @Date 2022/2/15 22:10
 * @Version 1.0
 * @Description
 */
public enum EnumProductIdSummery {
    NBCBZJD001("NBCBZJD001", "直接贷助贷"),

    NBCBZJD002("NBCBZJD002", "直接贷(保险)"),

    NBCBZJD003("NBCBZJD003", "直接贷B");


    private String code;
    private String description;

    /**
     * 获取产品码值列表
     *
     * @return
     */
    public static List<String> getProductCodes() {
        return getProductIds().stream().map(EnumProductIdSummery::getCode).collect(Collectors.toList());
    }

    /**
     * 获取产品列表
     *
     * @return
     */
    private static List<EnumProductIdSummery> getProductIds() {
        return Lists.newArrayList(EnumProductIdSummery.NBCBZJD001, EnumProductIdSummery.NBCBZJD003);
    }

    EnumProductIdSummery(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 根据编码code查找枚举
     * 提前判断，用于解决
     * Case中出现的Constant expression required
     *
     * @param code 编码
     * @return NumberForCaseEnum实例
     */
    public static EnumProductIdSummery find(String code) {
        for (EnumProductIdSummery instance : EnumProductIdSummery.values()) {
            if (instance.getCode().equals(code)) {
                return instance;
            }
        }
        return null;
    }
}
