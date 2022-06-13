package com.hediancha.array;

import com.hediancha.bean.UserDto;
import com.hediancha.bean.UserInfoDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author Hediancha
 * @Date 2022/5/27 22:58
 * @Version 1.0
 * @Description: 一、数组的概述
 * 1.数组的理解：数组(Array)，是多个相同类型数据按一定顺序排列的集合，并使用一个名字命名，
 * 并通过编号的方式对这些数据进行统一管理。
 * <p>
 * 2.数组相关的概念：
 * >数组名
 * >元素
 * >角标、下标、索引
 * >数组的长度：元素的个数
 * <p>
 * 3.数组的特点：
 * 1）数组是有序排列的
 * 2）数组属于引用数据类型的变量。数组的元素，既可以是基本数据类型，也可以是引用数据类型
 * 3）创建数组对象会在内存中开辟一整块连续的空间
 * 4）数组的长度一旦确定，就不能修改。
 * <p>
 * 4. 数组的分类：
 * ① 按照维数：一维数组、二维数组、。。。
 * ② 按照数组元素的类型：基本数据类型元素的数组、引用数据类型元素的数组
 * <p>
 * 5. 一维数组的使用
 * ① 一维数组的声明和初始化
 * ② 如何调用数组的指定位置的元素
 * ③ 如何获取数组的长度
 * ④ 如何遍历数组
 * ⑤ 数组元素的默认初始化值 ：见ArrayTest1.java
 * ⑥ 数组的内存解析 ：见ArrayTest1.java
 */
public class ArrayTest {
    public static void main(String[] args) {

        //1. 一维数组的声明和初始化
        int num;//声明
        num = 10;//初始化
        int id = 1001;//声明 + 初始化

        int[] ids;//声明
        //1.1 静态初始化:数组的初始化和数组元素的赋值操作同时进行
        ids = new int[]{1001, 1002, 1003, 1004};
        //1.2动态初始化:数组的初始化和数组元素的赋值操作分开进行
        String[] names = new String[5];

        //错误的写法：
//		int[] arr1 = new int[];
//		int[5] arr2 = new int[5];
//		int[] arr3 = new int[3]{1,2,3};

        //也是正确的写法：
        int[] arr4 = {1, 2, 3, 4, 5};//类型推断

        //总结：数组一旦初始化完成，其长度就确定了。

        //2.如何调用数组的指定位置的元素:通过角标的方式调用。
        //数组的角标（或索引）从0开始的，到数组的长度-1结束。
        names[0] = "王铭";
        names[1] = "王赫";
        names[2] = "张学良";
        names[3] = "孙居龙";
        names[4] = "王宏志";//charAt(0)
//		names[5] = "周扬";

        //3.如何获取数组的长度。
        //属性:length
        System.out.println(names.length);//5
        System.out.println(ids.length);

        //4.如何遍历数组
		/*System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		System.out.println(names[3]);
		System.out.println(names[4]);*/

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }

    @Test
    public void testListToMap() {
        // List 转成Map
        List<UserInfoDto> userInfoDtos = new ArrayList<>();
        UserInfoDto userInfoDto = UserInfoDto.builder().build();
        userInfoDto.setUserId("Id1008791");
        userInfoDto.setPhone("17108891984");
        userInfoDto.setUserName("罗辑");
        userInfoDtos.add(userInfoDto);

        Map<String, UserInfoDto> maps = new HashMap<>();
        for (UserInfoDto userInfo : userInfoDtos) {
            maps.put(userInfo.getUserId(), userInfo);
        }
        //System.out.println(maps);

        Map<String, UserInfoDto> userInfoDtoMap = userInfoDtos.stream().collect(Collectors.toMap(UserInfoDto::getUserId,
                Function.identity(), (a, b) -> b));
        System.out.println(userInfoDtoMap);
    }

    @Test
    public void testArray() {

        /*String[] str = new String[3];
        str[0] = "001";
        str[2] = "002";
        for (String s : str) {
            System.out.println(s);
        }*/

        // 大List
        List<UserInfoDto> userInfoDtos = new ArrayList<>();
        UserInfoDto build = UserInfoDto.builder().build();
        userInfoDtos.add(build);
        System.out.println(CollectionUtils.isNotEmpty(userInfoDtos));
        System.out.println(userInfoDtos.get(0));
        System.out.println(userInfoDtos.get(0).getPhone());
        System.out.println(build);

        UserInfoDto userInfoDto1 = UserInfoDto.builder().build();
        userInfoDto1.setUserId("Id1008791");
        userInfoDto1.setPhone("17108891984");
        userInfoDto1.setUserName("罗辑");

        // 二层list
        List<UserDto> userDtoList = new ArrayList<>();
        // 往二层list中塞值
        UserDto userDto = new UserDto();
        userDto.setCardId("001");
        userDto.setAccountNo("411");
        userDto.setAmount(null);
        userDtoList.add(userDto);
        userInfoDto1.setUserDtos(userDtoList);
        userInfoDtos.add(userInfoDto1);

        // 大层List
        UserInfoDto userInfoDto2 = null;
        userInfoDtos.add(userInfoDto2);
        System.out.println(userInfoDtos);


        String[] str = new String[3];

        for (int i = 0; i < 1; i++) {
//            List<UserDto> userDtos = userInfoDtos.get(i).getUserDtos();
//            str[0] = userDtos.get(0).getCardId();
//            str[1] = userDtos.get(0).getAccountNo();
//            str[2] = userDtos.get(0).getAmount();
            Optional.ofNullable(userInfoDtos.get(i).getUserDtos()).ifPresent(item -> {
                String cardId = item.get(0).getCardId();
                if (StringUtils.isNotEmpty(cardId)) {
                    str[0] = cardId;
                }
            });
            Optional.ofNullable(userInfoDtos.get(i).getUserDtos()).ifPresent(item -> {
                String accountNo = item.get(0).getAccountNo();
                if (StringUtils.isNotEmpty(accountNo)) {
                    str[1] = accountNo;
                }
            });

            Optional.ofNullable(userInfoDtos.get(i).getUserDtos()).ifPresent(item -> {
                if (StringUtils.isNotEmpty(item.get(0).getAmount())) {
                    str[2] = item.get(0).getAmount();
                }
            });
        }
        for (String s : str) {
            System.out.println(s);
        }
    }
}
