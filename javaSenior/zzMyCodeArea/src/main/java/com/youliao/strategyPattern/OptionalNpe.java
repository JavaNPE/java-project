package com.youliao.strategyPattern;//package com.youliao.strategyPattern;
//
////import com.google.common.collect.Lists;
//import com.youliao.bean.User;
//import org.junit.Test;
//
//import java.util.Optional;
//
///**
// * @Author HedianTea
// * @Date 2021/12/31 15:14
// * @Version 1.0
// * @Description: 非空判断之Java8新特性：Optional
// */
//public class OptionalNpe {
//
//
//	/**
//	 * Optional.ofNullable()方法
//	 * 先解释代码含义：如果list集合不为空，将list集合赋值给newList；
//	 * 如果list集合为空创建一个空对象集合赋值给newList，保证list集合永远不为空，也就避免了空指针异常。
//	 * （为了更好的理解，分开写了，比较庸俗，实际工作中都是一行搞定，哈哈哈）
//	 * 参考博客地址：https://blog.csdn.net/lxj_1993/article/details/109451567
//	 */
////	@Test
////	public void test1() {
////		List<String> list = null;
////		List<String> newList = Optional.ofNullable(list).orElse(Lists.<String>newArrayList());
////		newList.forEach(x -> System.out.println(x));
////	}
//
//	@Test
//	public void ifPresentTest() {
//		Integer i = new Integer(2);
//		Optional.ofNullable(i).ifPresent(t -> t = 3);
//
//		int j = 4;
//		Optional.ofNullable(i).ifPresent(t -> t = 5);
//
//		User user = new User(1);
//		Optional.ofNullable(i).ifPresent(t -> t = new Integer(2));
//
//	}
//}
