package com.hediancha.bean;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Author HedianTea
 * @Date 2022/5/28 9:50
 * @Version 1.0
 * @Description
 */
@Data
@Builder
public class UserInfoDto {
    private String userId;
    private String userName;
    private String phone;

    List<UserDto> userDtos;
}
