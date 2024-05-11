package com.youliao.strategyPattern;

import com.youliao.enums.EnumProductIdSummery;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author HedianTea
 * @Date 2021/12/23 15:16
 * @Version 1.0
 * @Description
 */
//@Slf4j
public class JavaTest {
	/**
	 * Integer.parseInt()什么意思？
	 * java中的语句integer.parseint（)是将整型数据Integer转换为基本数据类型int
	 */
	@Test
	public void testIntegerParseInt() {
		String str = "2";
		int i = Integer.parseInt(str);
		System.out.println(i + 1);
		System.out.println(str + 1);

	}

	/**
	 *
	 */

	@Test
	public void  testEnum() {
		List<String> productList = new ArrayList<>();
		productList.add("CRCS001");
		boolean zjdFlag;
		if (productList.contains(EnumProductIdSummery.CRCS001.getCode())
				|| productList.contains(EnumProductIdSummery.CRCS003.getCode()))
			zjdFlag = true;
		else zjdFlag = false;

		if (zjdFlag) {
			System.out.println("Flag:"+zjdFlag);
		}
	}

	@Test
	public void testBigDecimal() {
		BigDecimal i = BigDecimal.ZERO;
		if (i.compareTo(BigDecimal.ZERO)==0) {
			System.out.println("******");
		}
	}

	@Test
	public void testReturnNull() {
		Object j = "hello";
		for (int i = 0; i < 3; i++) {
			if (true) {
				System.out.println("***********");
				j=null;
			}
			System.out.println("&&&&&&&&&&&&&&&");
		}
	}

}