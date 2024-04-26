package com.youliao.java;

import lombok.Builder;
import lombok.Data;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/4/16 12:28
 * @Description:
 */
@Data
@Builder
public class CreditApplyDo {
    private String creditApplyId;
    private String thirdpartApplyId;
    private String productId;
    private String userName;
}
