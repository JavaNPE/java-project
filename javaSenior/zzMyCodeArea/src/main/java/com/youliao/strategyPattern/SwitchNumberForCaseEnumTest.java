package com.youliao.strategyPattern;/*
package com.youliao.java;

import com.youliao.enums.NumberForCaseEnum;
import org.junit.Test;

*/
/**
 * @Author HedianTea
 * @Date 2021/12/22 10:20
 * @Version 1.0
 * @Description: constant expression required
 *//*

public class SwitchNumberForCaseEnumTest {
	@Test
	public void test01() {
		// 可以通过循环遍历拿值
		for (NumberForCaseEnum x : NumberForCaseEnum.values()) {
			System.out.println("枚举值：" + x.getCode());
		}
		// 也可以单独拿值
		//System.out.println("调皮捣蛋的："+ONE.getIndex());
		String productId = "NBCBZJD003";
		switch (NumberForCaseEnum.getByCode(productId)) {
			case ONE:
				System.out.println("1111");
				break;
			case TWO:
				System.out.println("精明可爱的：2222");
				break;
			case THREE:
				System.out.println("3333");
				break;
			default:
		}
	}
}
*/
