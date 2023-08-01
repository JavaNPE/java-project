package com.youliao.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2023/7/27 19:44
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum EnumBool implements IEnum {
    NO("0", "否"), YES("1", "是");
    private String code;
    private String description;

    @Override
    public Serializable getValue() {
        return null;
    }

    public static EnumBool find(String code) {
        return Arrays.stream(EnumBool.values()).filter(input -> input.getCode().equals(code)).findFirst().orElse(null);
    }
}
