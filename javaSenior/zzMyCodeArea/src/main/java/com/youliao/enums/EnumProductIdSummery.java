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
    NBCBZJD001("NBCBZJD001", "直接贷助贷", "01"),
    NBCBZJD00000000("NBCBZJD001111", "直接贷助贷", "01"),


    NBCBZJD002("NBCBZJD002", "直接贷(保险)", "02"),

    NBCBZJD003("NBCBZJD003", "直接贷B", "03"),
    NBCBZJD004("NBCBZJD004", "直接贷(保险)", "04"),
    NBCBZJD005("05", "直接贷(保险)", "04")

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
        return Lists.newArrayList(EnumProductIdSummery.NBCBZJD001, EnumProductIdSummery.NBCBZJD003);
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
