package com.youliao.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2022/10/25 21:02
 * @Description:
 */
@Data
@Builder
public class SmsBeanTest {
    private Data businessDate;
    private String channelNo;
    private String productId;
    private String phone;
}
