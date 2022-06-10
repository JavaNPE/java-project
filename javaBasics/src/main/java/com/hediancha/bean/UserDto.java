package com.hediancha.bean;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author Hedian tea
 * @Date 2022/6/10 20:22
 * @Version 1.0
 * @Description
 */
@Data
@NoArgsConstructor
@ToString
public class UserDto {
    private String cardId;
    private String accountNo;
    private String amount;
}
