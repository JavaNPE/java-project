package com.youliao.enums;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author HedianTea
 * @Date 2022/2/15 22:10
 * @Version 1.0
 * @Description
 */
@Getter
@AllArgsConstructor
public enum EnumProductIdSummery {
    CRCS001("CRCS001", "助贷产品", "01"),
    CRCS00000000("CRCS001111", "助贷产品", "01"),


    CRCS002("CRCS002", "直接贷款(保险类别)", "02"),

    CRCS003("CRCS003", "直接贷款B型产品", "03"),
    CRCS004("CRCS004", "直接贷款(保险类别)", "04"),
    CRCS005("05", "直接贷款(保险类别)", "04")

;

    private String code;
    private String description;

    private String innerCode;

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
        return Lists.newArrayList(EnumProductIdSummery.CRCS001, EnumProductIdSummery.CRCS003);
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

    /**
     * 根据编码code查找枚举
     * 提前判断，用于解决
     * Case中出现的Constant expression required
     *
     * @param innerCode 编码
     * @return NumberForCaseEnum实例
     */
    public static EnumProductIdSummery findByInnerCode(String innerCode) {
        for (EnumProductIdSummery instance : EnumProductIdSummery.values()) {
            if (instance.getInnerCode().equals(innerCode)) {
                return instance;
            }
        }
        return null;
    }
}
