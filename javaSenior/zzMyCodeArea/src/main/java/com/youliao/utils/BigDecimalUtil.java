package com.youliao.utils;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2023/5/25 9:05
 * @Description:
 */
public class BigDecimalUtil {
    /**
     * 默认返回 BigDecimal.ZERO
     *
     * @param amount
     * @return
     */
    public static BigDecimal defaultZero(BigDecimal amount) {
        return Optional.ofNullable(amount).orElse(BigDecimal.ZERO);
    }
}
