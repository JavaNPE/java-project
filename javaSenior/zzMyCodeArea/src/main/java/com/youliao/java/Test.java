package com.youliao.java;

import com.google.common.collect.Lists;
import com.youliao.bean.Employee;
import com.youliao.bean.User;
import com.youliao.entity.AttrEntity;
import com.youliao.enums.NumberForCaseEnum;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @Author HedianTea
 * @Date 2022/6/30 11:00
 * @Version 1.0
 * @Description
 */
public class Test {

    public static final String JISHI = "JISHI";
    public static final String BIG_DATA = "BIG_DATA";

    @org.junit.Test
    public void bigDecimalTest() {
        BigDecimal a = BigDecimal.valueOf(4.00);
        BigDecimal b = BigDecimal.valueOf(10);
        BigDecimal c = BigDecimal.valueOf(4);

        if (BigDecimal.ZERO.compareTo(a) < 0) {
            System.out.println("------------------");
        }

        BigDecimal subtract = a.subtract(b).subtract(c).setScale(2, RoundingMode.HALF_UP);
        System.out.println(subtract);

        if (subtract.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("******************************");
            System.out.println(BigDecimal.ZERO);
        }
    }

    @org.junit.Test
    public void testFalse() {
        if (Boolean.FALSE) {
            System.out.println("************");
        }
        if (!Boolean.FALSE) {
            System.out.println("____________________");
        }
        if (!(Boolean.FALSE)) {
            System.out.println("=====================");
        }
    }

    @org.junit.Test
    public void testLong() {
        long l = Long.parseLong("3");
        System.out.println(l);
    }

    @org.junit.Test
    public void testJoin() {
//        String str = "12,3,4";
//        List<String> list = Arrays.asList(String.join(",", str));
//        System.out.println(list);
//        String s = "30";
//        int i = Integer.parseInt(s);
//        //System.out.println(i);

        String s1 = "12,3,4";
        String[] split = s1.split(",");

        List<String> strings = Arrays.asList(s1.split(","));
        System.out.println(strings);
        if (CollectionUtils.isEmpty(strings)) {
            System.out.println("-----------------");
        }

        List<String> productIds = Lists.newArrayList();
        productIds.add("WLD001");
        productIds.add("WLD002");
        System.out.println(productIds);
    }

    @org.junit.Test
    public void testStringBuilder() {
        String list = "2022-01-01 00:00:00";
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("'").append(list).append("'");
        System.out.println(append.toString());
        String list1 = "'" + list + "'";
        System.out.println("list1:" + list1);
    }

    /**
     * 自动装箱
     */
    @org.junit.Test
    public void test01() {
        Integer n = null;
        int i = n.intValue();
        System.out.println(i);
        System.out.println(2 * n);
    }

    @org.junit.Test
    public void textReflection() {
        Class<AttrEntity> attrEntityClass = AttrEntity.class;
        ClassLoader classLoader = attrEntityClass.getClassLoader();
        ClassLoader parent = classLoader.getParent();
        System.out.println(attrEntityClass);
    }

    @org.junit.Test
    public void testNPE() {
        List<AttrEntity> list = null;
        if (CollectionUtils.isNotEmpty(list)) {
            System.out.println("-------------");
        }
        if (list != null && list.size() > 0) {
            System.out.println("-------------");
        }
    }

    @org.junit.Test
    public void test2() {
        String s1 = "null";
        String s2 = "null";
        String s3 = "null";
        String s4 = "null";
        if (StringUtils.isBlank(s3)) {
            System.out.println("String s3 = null;");
        }
        // 三者都为null才让其进入
//        if (StringUtils.isBlank(s1) && StringUtils.isBlank(s2) && StringUtils.isBlank(s3)) {
//            System.out.println("1111111111111111111");
//        }

        // 三者有一个为null就进入（全为null是也进入,全不为null不进）
        if (StringUtils.isBlank(s1) || StringUtils.isBlank(s2) || StringUtils.isBlank(s3) || StringUtils.isBlank(s4)) {
            System.out.println("2222222222222222222222");
        }

        // 有一个不为null的则进入(全部为null不会进入)
        if (StringUtils.isNotBlank(s1) || StringUtils.isNotBlank(s2) || StringUtils.isNotBlank(s3)) {
            System.out.println("333333333333333333");
        }
        // 有一个不为null的则进入(全部为null进入)
        if (!(StringUtils.isBlank(s1) && StringUtils.isBlank(s2) && StringUtils.isNotBlank(s3))) {
            System.out.println("4444444444444444");
        }
        // 有一个不为null的时候不进入(全部为null进，)
        if (!(StringUtils.isNotBlank(s1) || StringUtils.isNotBlank(s2) || StringUtils.isNotBlank(s3))) {
            System.out.println("5555555555555");
        }
    }

/*
    public class demoUtil {
        public static Long methdName(List<EnterpriseSolutionsSeq> seqList){
            if(CollUtil.isEmpty(seqList)){
                return null;
            }
            // 下面这行代码会被sonar检测有问题，因为在对Optional对象使用get前没有使用 isPresent()进行校验
            // Optional对象来源因为用了Stream 的 min 方法，其返回值是 Optional类型的
            EnterpriseSolutionsSeq solutionsSeq = seqList.stream().filter(Objects::nonNull).min(Comparator.comparing(EnterpriseSolutionsSeq::getSeq)).get();
            return solutionsSeq.getSeq();
        }
    }

    public class demoUtil {

        public static Long methdName(List<EnterpriseSolutionsSeq> seqList){
            if(CollUtil.isEmpty(seqList)){
                return null;
            }

            Optional<EnterpriseToolsSeq> min = toolsSeqList.stream().filter(Objects::nonNull).min(Comparator.comparing(EnterpriseToolsSeq::getSeq));
            if(min.isPresent()){
                return min.get().getSeq();
            }
            return 1000000L;
        }
    }

*/

    /**
     * BigDecimal相加测试
     */
    @org.junit.Test
    public void testBigDecimal() {
        BigDecimal b1 = BigDecimal.valueOf(11.8);
        BigDecimal b2 = BigDecimal.valueOf(0.2);
        BigDecimal b3 = BigDecimal.valueOf(8.00);
        BigDecimal b4 = null;
        BigDecimal sum = new BigDecimal(0);
        sum = sum.add(b1).add(b2).add(b3).add(Optional.ofNullable(b4).orElse(BigDecimal.ZERO));
        System.out.println(sum);
    }

    @org.junit.Test
    public void testA() {
        String s1 = "null";
        String s2 = "null";
        String s3 = "null";
        if (StringUtils.isBlank(s1) && StringUtils.isBlank(s2) && StringUtils.isBlank(s3)) {
            System.out.println("---------------");
        }
    }

    @org.junit.Test
    public void testB() {
        String s1 = "0";
        if (s1.equals("0")) {
            s1 = "1";
        }
        System.out.println(s1);
    }

    @org.junit.Test
    public void testC() {

        Object o1 = null;

        String s = (String) o1;
        String s1 = o1.toString();
        System.out.println("--------------");

    }

    @org.junit.Test
    public void testD() {
        Map m = new HashMap();
//        m.put("1", new Integer(1));
        m.put("1", null);
        m.put("2", " ");
        m.put("3", BigDecimal.valueOf(23.9));
        System.out.println(m);
        BigDecimal o1 = (BigDecimal) m.get(2);

        System.out.println("BigDecimalO1:" + Optional.ofNullable(o1).orElse(BigDecimal.ZERO));

        String b = (String) m.get("2");         // 强转
        System.out.println("b:" + b);
        String a = m.get("2").toString();      // .toString
        System.out.println("a:" + a);

        String o = (String) m.get("2");
        System.out.println("o:" + o);
//        int i = Integer.parseInt(Optional.ofNullable(o).orElse("0"));
//        System.out.println(i);

    }


    @org.junit.Test
    public void testE() {
        BigDecimal b1 = BigDecimal.valueOf(0);
        BigDecimal b2 = BigDecimal.valueOf(1.90);
        if (b1.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("--------------");
        }
    }

    @org.junit.Test
    public void testF() {
        String JS = "JISHI";
        String bigData = "BIG_DATA";
        if (JISHI.equals(JS)) {
            System.out.println(JISHI.toLowerCase(Locale.ROOT));
        }
        if (BIG_DATA.equals(bigData)) {
            String s = BIG_DATA.toLowerCase();
            System.out.println("S:" + s);
            System.out.println(BIG_DATA.toLowerCase(Locale.ROOT));
        }
    }

    @org.junit.Test
    public void testG() {
        String s = "20";
        int i = check(s);
        System.out.println(i);
    }

    private int check(String s) {
        if (StringUtils.isBlank(s)) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    @org.junit.Test
    public void testList() {
        List<String> strings = Lists.newArrayList();
        for (String string : strings) {
            System.out.println("------");
        }
    }

    /**
     * 测试枚举根据产品编号查询
     */
    @org.junit.Test
    public void testEnum() {
        /*NumberForCaseEnum nbcbzjd003 = NumberForCaseEnum.find("NBCBZJD003");
        System.out.println(nbcbzjd003.getCode());
        NumberForCaseEnum nbcbzjd002 = NumberForCaseEnum.getByCode("NBCBZJD002");
        System.out.println(nbcbzjd002.getCode());
        NumberForCaseEnum nbcbzjd002Desc = NumberForCaseEnum.getByCode("NBCBZJD002");
        System.out.println(nbcbzjd002Desc.getDescription());*/
        NumberForCaseEnum name = NumberForCaseEnum.findByName("直接贷B");
        System.out.println(name);
        NumberForCaseEnum desc = NumberForCaseEnum.findByDesc("直接贷B");
        //System.out.println(desc.getCode());
        NumberForCaseEnum 直接贷BC = NumberForCaseEnum.findByDescStream("直接贷（保险）");
        System.out.println(直接贷BC.getCode());
        // 枚举类型 使用 ==  预防空指针问题发生
        if (NumberForCaseEnum.THREE == desc) {
            System.out.println("直接贷B输出语句");
        } else {
            System.out.println("不满足要求输出结果");
        }
    }

    @org.junit.Test
    public void test21() {
        String str = "1234";
        int length = str.length();
        System.out.println("lenght:" + length);
        StringBuilder sb = new StringBuilder(str);

        String substring = sb.substring(str.length() - 1);
        System.out.println("subString:" + substring);
        if ("4".equals(substring)) {
            sb.replace(str.length() - 1, str.length(), "1");
            System.out.println("拼接后的sb:" + sb);
        }
    }

    @org.junit.Test
    public void test211() {
        Double d1 = null;
        BigDecimal bigDecimal = new BigDecimal(d1);
        System.out.println(bigDecimal);
    }

    @org.junit.Test
    public void testFun() {
        Employee employee = null;
        //employee.setId("100001");
        Optional.ofNullable(employee).ifPresent(employee1 -> {
            if (employee1 == null) {
                System.out.println("employee is null");
            } else {
                System.out.println(employee1.getId());
            }
        });

        /*employee.setName("张三");
        employee.setSalary(Double.valueOf("900"));
        employee.fun(employee.getName(), employee.getId(), employee.getSalary());
        employee.fun(employee.getName(), employee.getSalary(), employee.getId());*/
    }

    @org.junit.Test
    public void testStringJoin() {

        //字符串数组
        String[] strArray = new String[]{"ni", "zhen", "hao", "kan"};

        //字符串队列
        List<String> strList = new ArrayList<String>();
        //添加元素
        strList.add("ni");
        strList.add("zhen");
        strList.add("hao");
        strList.add("kan");

        //第2个参数是字符串数组
        String a = String.join("!", strArray);
        //第2个参数是字符串队列
        String b = String.join("!", strList);
        //第1个参数之后是多个字符串
        String c = String.join("!", "ni", "zhen", "hao", "kan");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

    /**
     * HashMap get 一个 null  值 可
     */
    @org.junit.Test
    public void testHashMapNull() {
        HashMap hashMap = new HashMap();
        Object o = hashMap.get(null); // HashMap 可以get null
        System.out.println(o);
    }
    /**
     * Hashtable get 一个 null  值 空指针
     */
    @org.junit.Test
    public void testHashTableNull() {
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        Object o = hashtable.get(null); // Hashtable 不可以get null
        System.out.println(o);
    }

    /**
     * 大数与null值相加 报空指针
     */
    @org.junit.Test
    public void testBigDecimalAddNull() {
        BigDecimal n1 = null;
        System.out.println("111:" + String.valueOf(n1));
        System.out.println("222:" + n1.toString());

        BigDecimal b1 = BigDecimal.ONE;
        BigDecimal b2 = BigDecimal.TEN;
        BigDecimal b3 = BigDecimal.valueOf(4);
        BigDecimal add = b2.subtract(b1).add(b3);

        System.out.println(add);
    }


    /**
     * null.subtract(num)
     */
    @org.junit.Test
    public void testBigDecimalNullSubtractNum() {
        BigDecimal a = null;
        BigDecimal b = new BigDecimal(3);
        if (b.compareTo(Optional.ofNullable(a).orElse(BigDecimal.ZERO)) != 0) {
            System.out.println("嘀嘀嘀");
        }
    }

    @org.junit.Test
    public void testIntOrInteger() {
        int i1 = 0;
        System.out.println("i1:" + i1);
        Integer i2 = null;
        System.out.println("i2:" + i2);
    }

    @org.junit.Test
    public void testBigDecimalAdd() {
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;
        BigDecimal ten = BigDecimal.TEN;
        BigDecimal bigDecimal = BigDecimal.valueOf(22);
        System.out.println(one.add(ten).add(bigDecimal));
        System.out.println(bigDecimal.subtract(ten));
    }

    @org.junit.Test
    public void ObjestNull() {
        Employee e1 = new Employee();
        System.out.println(e1.toString());
        Employee e2 = null;
        System.out.println(String.valueOf(e2));

    }

    @org.junit.Test
    public void TestString() {
        String s1 = "06";
        s1 = "05";
        s1 = "07";
        System.out.println(s1);
        System.out.println(s1);
    }

    @org.junit.Test
    public void testInteger() {
        //int i = Integer.parseInt(null);

        Integer i = Integer.valueOf(null);
        // java.lang.NumberFormatException: null
        //
        //	at java.lang.Integer.parseInt(Integer.java:542)
        //	at java.lang.Integer.valueOf(Integer.java:766)
        System.out.println(i);
    }

    @org.junit.Test
    public void testApiBigDeciaml() {
        // BigDecimal s = BigDecimal.ZERO;
        // System.out.println(BigDecimal.ZERO.equals(s) ? null : 3); //null

/*        BigDecimal s = BigDecimal.ZERO;
        System.out.println(BigDecimal.ZERO == s ? null : 3); // null*/

        BigDecimal s = new BigDecimal(0);
        if (s == BigDecimal.ZERO) {
            System.out.println("--------------");
        }
        System.out.println(BigDecimal.ZERO == s ? null : 3); // 3

    }

    @org.junit.Test
    public void testNullReduce() {
        List<Employee> employee = Lists.newArrayList();
        // employee.get(0).setRepayLateFee(null);
        BigDecimal sum = employee.stream()
                .map(Employee::getRepayLateFee)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);
    }

    /**
     * String.format()字符拼串
     */
    @org.junit.Test
    public void stringFormat() {
        String tendId = "000";
        String flag = String.valueOf("1");
        String dateStr = String.valueOf("20230517");
        String productId = "NBCBZJDBZX001";
        String serialNo = String.format("%s%s%s%s", tendId, flag, dateStr, productId);
        System.out.println(serialNo);
        System.out.println(tendId + flag + dateStr + productId);
    }

    @org.junit.Test
    public void testTest() {
        String str = null;

        System.out.println(String.valueOf(str));
        // System.out.println(str.toString()); java.lang.NullPointerException

    }

    @org.junit.Test
    public void TestNull() {
        String str = null;
        Integer itr = null;
        Double dou = null;

        Integer integer = (Integer) null;
        String string = (String) null;

        System.out.println("integer = " + integer);
        System.out.println("string = " + string);

        Integer isNull = null;
        // instanceof = isInstance 方法
        // 使用了带有 null 值的引用类型变量，instanceof 操作会返回 false
        // 这是 instanceof 操作符一个很重要的特性，使得对类型强制转换检查很有用
        if (isNull instanceof Integer) {
            System.out.println("isNull is instanceof Integer");
        } else {
            System.out.println("isNull is not instanceof Integer");
        }
    }

    // number 没有赋值，所以默认为null
    private static String number;

    /**
     * number 没有赋值，所以默认为null，使用String.value(number) 静态方法没有抛出空指针异常，
     * 但是使用 toString() 却抛出了空指针异常。所以尽量使用对象的静态方法。
     */
    @org.junit.Test
    public void TestNullSafeMethod() {
        System.out.println("number: " + number);
        String s = String.valueOf(number);
        String string = number.toString();
        System.out.println("s = " + s);
        System.out.println("string = " + string);
    }
    
    @org.junit.Test
    public void testObjectNull() {
        User user = null;
        System.out.println(user.toString());
    }
}