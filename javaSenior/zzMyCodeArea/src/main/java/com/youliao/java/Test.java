package com.youliao.java;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.youliao.bean.Employee;
import com.youliao.bean.Student;
import com.youliao.bean.StudentInfo;
import com.youliao.bean.User;
import com.youliao.entity.AttrEntity;
import com.youliao.enums.EnumBool;
import com.youliao.enums.EnumProductIdSummery;
import com.youliao.enums.NumberForCaseEnum;
import com.youliao.utils.BigDecimalUtil;
import com.youliao.utils.DateUtil;
import com.youliao.utils.GsonUtil;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author HedianTea
 * @Date 2022/6/30 11:00
 * @Version 1.0
 * @Description
 */
@Logger
@Slf4j
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
            EnterpriseSolutionsSeq solutionsSeq = seqList.stream().filter(Objects::nonNull).min(Comparator.comparing
            (EnterpriseSolutionsSeq::getSeq)).get();
            return solutionsSeq.getSeq();
        }
    }

    public class demoUtil {

        public static Long methdName(List<EnterpriseSolutionsSeq> seqList){
            if(CollUtil.isEmpty(seqList)){
                return null;
            }

            Optional<EnterpriseToolsSeq> min = toolsSeqList.stream().filter(Objects::nonNull).min(Comparator
            .comparing(EnterpriseToolsSeq::getSeq));
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
        /*NumberForCaseEnum CRCS003 = NumberForCaseEnum.find("CRCS003");
        System.out.println(CRCS003.getCode());
        NumberForCaseEnum CRCS002 = NumberForCaseEnum.getByCode("CRCS002");
        System.out.println(CRCS002.getCode());
        NumberForCaseEnum CRCS002Desc = NumberForCaseEnum.getByCode("CRCS002");
        System.out.println(CRCS002Desc.getDescription());*/
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
        BigDecimal sum = employee.stream().map(Employee::getRepayLateFee).reduce(BigDecimal.ZERO, BigDecimal::add);
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
        String productId = "CRCSZJDBZX001";
        String serialNo = String.format("%s%s%s%s", tendId, flag, dateStr, productId);
        System.out.println(serialNo);
        System.out.println(tendId + flag + dateStr + productId);
    }

    @org.junit.Test
    public void testTest() {
        String str = null;

        System.out.println(EnumProductIdSummery.find("05"));

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

    @org.junit.Test
    public void TestMapNull() {
        Map map = new HashMap();
        Object o = map.get(null);
        System.out.println(o);
/*        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);*/
    }

    @org.junit.Test
    public void TestNull2() {
        Employee employee = new Employee();
        employee.setRepayLateFee(null);
        BigDecimal repayLateFee = BigDecimalUtil.defaultZero(employee.getRepayLateFee()).add(BigDecimal.ZERO);

        System.out.println(repayLateFee);
    }

    @org.junit.Test
    public void testMap() {
        String s = EnumProductIdSummery.CRCS001.getCode();
        if (s.equals(EnumProductIdSummery.CRCS001.getCode())) {
            s = EnumProductIdSummery.CRCS003.getCode();
        }
        System.out.println(s);
    }

    @org.junit.Test
    public void testOptional() {
        Optional<Integer> possible = Optional.of(5);
        System.out.println(possible.isPresent()); // ture
        Integer integer = possible.get();
        System.out.println(integer);
    }

    /**
     * 字符串表示字符的不可变序列，创建后就不能更改。在我们日常的工作中，字符串的使用非常频繁，熟练的对其操作可以极大的提升我们的工作效率。
     * <p>
     * 我提供了连接器——Joiner，可以用分隔符把字符串序列连接起来。下面的代码将会返回“雷军; 乔布斯”，你可以使用 useForNull(String)
     * 方法用某个字符串来替换 null，而不像 skipNulls() 方法那样直接忽略 null。
     */
    @org.junit.Test
    public void testJoinerSkipNulls() {
        //Joiner joiner = Joiner.on("; ").skipNulls();
        Joiner joiner = Joiner.on(";").skipNulls();
        String join = joiner.join("罗辑", null, "大史");
        System.out.println(join);

        // 方式二：
        // 跳过 null 值
        String result = Joiner.on("; ").skipNulls().join("Harry", null, "Ron", "Hermione");
        Assert.assertEquals(result, "Harry; Ron; Hermione");

    }

    @org.junit.Test
    public void testJoinerUseForNull() {
        // 替换 null 值
        String result = Joiner.on("; ").useForNull("null").join("Harry", null, "Ron", "Hermione");
        // 断言
        Assert.assertEquals(result, "Harry; null; Ron; Hermione");
        System.out.println(result);
    }

    /**
     * System.nanoTime提供相对精确的计时，但是不能用他来计算当前日期，在jdk中的说明如下：
     * 返回最准确的可用系统计时器的当前值，以毫微秒为单位。
     * 此方法只能用于测量已过的时间，与系统或钟表时间的其他任何时间概念无关。返回值表示从某一固定但任意的时间算起的毫微秒数（或许从以后算起，
     * 所以该值可能为负）。此方法提供毫微秒的精度，但不是必要的毫微秒的准确度。它对于值的更改频率没有作出保证。
     * 在取值范围大于约 292 年（263 毫微秒）的连续调用的不同点在于：由于数字溢出，将无法准确计算已过的时间。
     */
    @org.junit.Test
    public void testSystemFunction() {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long timeStart = System.currentTimeMillis();
        long timeEnd = System.currentTimeMillis();

        long l1 = 4;
        long l2 = 9;
        System.out.println(endTime - startTime);
        System.out.println(timeEnd - timeStart);
        System.out.println(l2 - l1);

        long date = new Date().getTime();
        int i = 3;
        long fragmentInDays = DateUtils.getFragmentInDays(new Date(), Calendar.YEAR);
        System.out.println("fragmentInDays:" + fragmentInDays);
    }

    @org.junit.Test
    public void testStr() {
        Employee employee = new Employee();
        employee.setName("科目" + 1 + "余额");
        System.out.println(employee);
        String str = "JISHI";
        if (JISHI.equals(str)) {
            System.out.println("__________");
        }
    }

    //jackson 多字段
    @org.junit.Test
    public void testJackson02() throws Exception {
        String jsonStr = "{\"age\":20,\"name\":\"lisi\",\"sex\":\"男\",\"hobby\":\"basketball\"}";
        ObjectMapper om = new ObjectMapper();
        Student stu = om.readValue(jsonStr, Student.class);
        System.out.println(stu);
    }

    @org.junit.Test
    public void testListAdd() {
        List list = Lists.newArrayList();
        list.add("测试1");
        list.add("测试2");
        list.add("测试3");
        //System.out.println(list);

        Object collect = list.stream().filter(input -> !input.equals("测试1")).collect(Collectors.toList());
        System.out.println(collect.toString());

    }

    @org.junit.Test
    public void test111() {
        Integer i1 = null;
        //String str = String.valueOf(i1);
        String str = i1.toString(); //npe
        System.out.println(str);
    }

    @org.junit.Test
    public void testMapNull() {
        List<Employee> list = Lists.newArrayList();
        Map<String, Employee> employeeMap = list.stream().collect(Collectors.toMap(Employee::getId,
                Function.identity(), (a, b) -> b));
        Employee employee = employeeMap.get(1);
        System.out.println(employee);
    }

    @org.junit.Test
    public void test1() {
        String str = null;
        EnumProductIdSummery summery = EnumProductIdSummery.find("CRCS004");
        switch (summery) {
            case CRCS001:
                str = summery.getCode();
                break;
            case CRCS002:
                str = summery.getCode();
                break;
            default:
                str = EnumProductIdSummery.CRCS003.getCode();
                break;
        }
        System.out.println(str);
    }

    @org.junit.Test
    public void test222() {
        boolean b = EnumBool.YES == EnumBool.find("1");
        if (b) {
            System.out.println("------------");
        }
        System.out.println("+++++++++++++++++++++");
    }

    @org.junit.Test
    public void testDemo() {

        List list = Lists.newArrayList();
        if (CollectionUtils.isEmpty(list)) {
            System.out.println(list.size());
            System.out.println("--------------");
        } else {
            System.out.println("--------list为null------");
        }
    }

    @org.junit.Test
    public void testEnum2() {
        EnumProductIdSummery CRCS003 = EnumProductIdSummery.valueOf("CRCS003");
        if (EnumProductIdSummery.CRCS003.equals(CRCS003)) {
            System.out.println("---------------");
        }
    }

    @org.junit.Test
    public void testNewNull() {
        BigDecimal bigDecimal = new BigDecimal(0);
        BigDecimal zero = BigDecimal.TEN;
        BigDecimal a = null;
        BigDecimal subtract = a.subtract(zero);
        System.out.println(subtract);

        System.out.println(bigDecimal);
    }

    @org.junit.Test
    public void testNullStr() {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        for (String s : list) {
            if (s.equals("a")) list.remove(s);
            for (String s1 : list) {
                System.out.println(s);
            }
        }
    }

    @org.junit.Test
    public void test() {
        boolean flag = false;
        for (int i = 0; i <= 3; i++) {
            if (i == 0) {
                System.out.println("0");
            } else if (i == 1) {
                System.out.println("1");
                continue;
            } else if (i == 2) {
                System.out.println("2");
                flag = true;
            } else if (i == 3) {
                System.out.println("3");
                break;
            } else if (i == 4) {
                System.out.println("4");
            }
            System.out.println("xixi");
        }
        if (flag) {
            System.out.println("haha");
            return;
        }
        System.out.println("heihei");
    }

    @org.junit.Test
    public void testArrays() {
        List<String> strings = Arrays.asList("1", "2", "AC");
        // strings.add("BB"); // UnsupportedOperationException
        System.out.println(strings);
    }

    @org.junit.Test
    public void testInteger2() {
        // 包装类默认值问题
        Integer integer = null;
        System.out.println(integer);
    }

    /**
     * 超过 long 整型的数据应该如何表示？
     * 基本数值类型都有一个表达范围，如果超过这个范围就会有数值溢出的风险。
     * <p>
     * 在 Java 中，64 位 long 整型是最大的整数类型。
     * <p>
     * BigInteger 内部使用 int[] 数组来存储任意大小的整形数据。
     * <p>
     * 相对于常规整数类型的运算来说，BigInteger 运算的效率会相对较低。
     */
    @org.junit.Test
    public void testLong2() {
        long l = Long.MAX_VALUE;
        System.out.println("l:" + l); // 9223372036854775807
        System.out.println(l + 1); // -9223372036854775808
        System.out.println(l + 1 == Long.MIN_VALUE); // true
        System.out.println(l == Long.MAX_VALUE); // true
        log.info("l的值为:" + l);
    }

    @org.junit.Test
    public void testDefault() {
        Employee employee = new Employee();
        System.out.println(employee.getNum());
    }

    @org.junit.Test
    public void testStaticMethod() {
        /*Person person = new Person();
        Person.staticMethod();*/
        System.out.println("a" + "b");
    }

    @org.junit.Test
    public void testDat() {
        String s = null;
        BigDecimal bigDecimal = new BigDecimal(s);
        System.out.println(bigDecimal);
    }

    @org.junit.Test
    public void test31231() {
        String s1 = ",,";
        List<String> s3 = Arrays.asList("4");
        System.out.println("s3:" + s3);

        List<String> s2 = Arrays.asList(s1.split(","));
        System.out.println("s2:" + s2.toString());
        if (CollectionUtils.isEmpty(s2)) {
            System.out.println("s2为空");
        }
        s3 = s2;
        System.out.println("s3:" + s3);
        if (CollectionUtils.isEmpty(s3)) {
            System.out.println("s3为null");
        }
        List<Object> objects = Arrays.asList(null, s3);
        System.out.println("objects:"+objects);

    }

    @org.junit.Test
    public void testStringNull() {
        Employee employee = null;
        if (employee == null) {
            System.out.println("employee:" + employee);
        }
        String s = String.valueOf(employee);
        System.out.println(s);
    }
    /**
     * https://blog.csdn.net/stalin_/article/details/102610823
     */
    @org.junit.Test
    public void testJson1() {
        //子json串
        JSONObject childJsonObj = new JSONObject();
        childJsonObj.put("name", "CRCS");
        childJsonObj.put("position", "BJ");


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "stalin");
        jsonObj.put("old", "26");
        jsonObj.put("sex", "man");
        jsonObj.put("work", childJsonObj.toJSONString());


        System.out.println(jsonObj.toJSONString());
    }

    public static final String RESERVE_INFO = "reserveInfo";
    @org.junit.Test
    public void testJson2() {
        //子json串
        JSONObject childJsonObj = new JSONObject();
        childJsonObj.put("name", "CRCS");
        childJsonObj.put("position", "BJ");


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "stalin");
        jsonObj.put("old", "26");
        jsonObj.put("sex", "man");
        jsonObj.put("work", childJsonObj);

        System.out.println(jsonObj.toJSONString());

        Map<String,String> map = Maps.newHashMap();
        //map.put("reserveInfo", childJsonObj);
        HashMap<String, String> objMap = Maps.newHashMap();
        //objMap.put(RESERVE_INFO, )

    }

    @org.junit.Test
    public void testJson3() {
        //子json串
        JSONObject childJsonObj = new JSONObject();
        childJsonObj.put("name", "CRCS");
        childJsonObj.put("position", "BJ");


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "stalin");
        jsonObj.put("old", "26");
        jsonObj.put("sex", "man");
        jsonObj.put("work", childJsonObj);

        JSONObject jsonObj2 = new JSONObject();
        jsonObj2.put("name", "stalin");
        jsonObj2.put("old", "26");
        jsonObj2.put("sex", "man");
        jsonObj2.put("work", childJsonObj.toJSONString());

        System.out.println("jsonObj:" + jsonObj.toJSONString());
        System.out.println("jsonObj2:" + jsonObj2.toJSONString());


        String str = String.valueOf(jsonObj.get(""));
        System.out.println(str);
        Map map = GsonUtil.json2Obj("", Map.class);
        System.out.println("map:"+map);
    }


    @org.junit.Test
    public void testNullList() {
        List<Employee> employees = null;
        List<String> collect = employees.stream().map(Employee::getId).collect(Collectors.toList());
        System.out.println(collect);
    }

    @org.junit.Test
    public void testSingletonList() {
        HashMap< String,String> map2 = Maps.newHashMap();
        Objects s = null;
        String s1 = String.valueOf(s);
        System.out.println(s1);
        HashMap< String,String> map = Maps.newHashMap();
        String s2 = map.get(null);
        Map map1 = GsonUtil.json2Obj(s2, Map.class);
        System.out.println("map1:"+map1);
        map2.putAll(MapUtils.isNotEmpty(map1) ?map1:Maps.newHashMap());
        System.out.println("map2:"+map2);
        String s3 = GsonUtil.valueOf(null);
        System.out.println(s3);
    }

    @org.junit.Test
    public void testGsonUtils() {
        // 1、map 转 json
        Map<String, String> stringMap = new HashedMap();
        stringMap.put("1", "测试1");
        stringMap.put("2", "测试2");
        stringMap.put("3", "测试3");
        Gson gson = new Gson();
        String toJson = gson.toJson(stringMap);
        System.out.println("toJson：" + toJson);
        // 2、json 转 map
        String sjson = "{\"name\":\"测试3\",\"id\":\"2\",\"salary\":\"1999.99\"}";
        String str2 = "";
        Map<String, String> stringObjectMap = GsonUtil.json2Obj(sjson, Map.class);
        Employee employee = GsonUtil.GsonToBean(sjson, Employee.class);
        System.out.println(employee);

        Map<String, String> stringMap1 = null;
        String s = GsonUtil.objectToJsonString(stringMap1);
        System.out.println("s:"+ s);
        Map map = GsonUtil.json2Obj(null, Map.class);
        System.out.println("map:" + map);
    }

    @org.junit.Test
    public void testGsonUtilNull() {
        Map<String,String> stringMap = Maps.newHashMap();
        Map map = GsonUtil.json2Obj("", Map.class);
        //map.size();
        System.out.println(map);
        stringMap.putAll(MapUtils.isNotEmpty(map) ? map : Maps.newHashMap());
        //stringMap.putAll(map);
        System.out.println("stringMpa:" + stringMap);
        Object str1 = stringMap.get("StringMap");
        String str2 = String.valueOf(str1);
        System.out.println("str2:" + str2);
        Map map2 = GsonUtil.json2Obj(str2, Map.class);
        System.out.println("map2:" + map2);
        stringMap.put(null, "value1");
        stringMap.put(null, "value2");
        System.out.println(stringMap);
    }

    @org.junit.Test
    public void testNull() {
        Employee e = null;
        String str = "初始化";
        if (e == null || StringUtils.isBlank(e.getName())) {
            System.out.println("-------------");
        }
        BigDecimal b = new BigDecimal(String.valueOf(0));
        System.out.println("BigDecimal b:" + b);
        Employee employee = new Employee();
        employee.setId("1111");
        employee.setName("测试");
        str = employee.getName();
        System.out.println("str:" + str);
       BigDecimal b1 = new BigDecimal("null");
        System.out.println(b1);
    }

    @org.junit.Test
    public void testSubstring() {
       // String str = "411403199912308730";
        String str = "12345";

        String subStr = str.substring(str.length()-4, str.length());
        System.out.println(subStr);
    }

    @org.junit.Test
    public void testMapNull2() {
        //Map map = null;
        Map<String,String> map = Maps.newHashMap();
        map.get("key");
        if(MapUtils.isEmpty(map)) {
            System.out.println("===============");
            BigDecimal b = new BigDecimal(StringUtils.isNotBlank(map.get("key"))?map.get("key"):String.valueOf(0));
            System.out.println(b);
        }

        // 若map 为 null  此处会抛空指针
        if (map.isEmpty()) {
            System.out.println("-------------");
        }

        BigDecimal b2 = new BigDecimal(String.valueOf(100));
        System.out.println(b2);

        String str1 = null;
        if (StringUtils.isBlank(str1)) {
            String s = StringUtils.isBlank(map.get("888")) ? null : map.get("888");
            if (StringUtils.isBlank(s)) {
                System.out.println("s:"+s);
            }
            System.out.println("字符串为空");
        }
        String.valueOf(null);
    }
    @org.junit.Test
    public void test13312() {
        Employee employee = null;
        if (employee == null || StringUtils.isBlank(employee.getName())) {
            System.out.println(employee);
        }
    }

    @org.junit.Test
    public void testAllMatch() {
        /*String[] days = new String[4];
        days[0] = "28";
        days[1] = "29";
        days[2] = "30";
        days[3] = "31";

        String day = "31";
        System.out.println(Arrays.stream(days).toArray());
        Boolean exists = Arrays.stream(days).anyMatch(ele -> ele.equals(day));
        if (exists) {
            System.out.println(EnumBool.YES);
        } else {
            System.out.println(EnumBool.NO);
        }
        System.out.println("----------------------------");*/
        String str1 = "28,29,30,31";
        String day = "28";
        String[] strDays = StringUtils.split(str1, ",");
        System.out.println(strDays);

        Boolean exists1 = Arrays.stream(strDays).anyMatch(ele -> ele.equals(day));
        if (exists1) {
            System.out.println("---------------");
            System.out.println(EnumBool.YES);
        } else {
            System.out.println(EnumBool.NO);
        }
    }


    @org.junit.Test
    public void testIdCard() {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        // 提取身份证号中的出生日期
        String idNumber = "11010119800101234X";
        String birthDateStr = idNumber.substring(6, 14);
        System.out.println("生日："+birthDateStr);
        // 将出生日期字符串转换为Date类型
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date birthDate = null;
        try {
            birthDate = dateFormat.parse(birthDateStr);
            System.out.println("五十年后年月日："+ DateUtil.offsetYear(birthDate, 50));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // 计算年龄
        calendar.setTime(birthDate);
        int birthYear = calendar.get(Calendar.YEAR);
        int age = currentYear - birthYear;
        // 打印年龄
        System.out.println("Age: " + age);

        System.out.println("50年后日期：" + DateUtil.dateAddYear(new Date(), 50));

        Date now = new Date();
/*        if(DateUtil.dateAddYear(new Date(), 50).compareTo(now) > 0) {
            System.out.println("-------------");
        }*/
        if (now.before(DateUtil.dateAddYear(new Date(), 50))) {
            System.out.println("------------------");
            System.out.println("now:" + now);
            System.out.println("50年后:" + DateUtil.dateAddYear(new Date(), 50));
        }
    }

    @org.junit.Test
    public void testIdCard2() {
        Date effectiveDate = new Date();
        System.out.println("当前生效时间:" + effectiveDate);
        Date oneYearLater = DateUtil.addDate(effectiveDate, 365);
        System.out.println("导入时间+365天之后的日期:" + oneYearLater);

        // 提取身份证号中的出生日期
        String idNumber = "11010119800229234X";
        String birthByIdCard = idNumber.substring(6, 14);
        Date birthByIdCardDate = DateUtil.getDate(birthByIdCard, DateUtil.DATE_FORMAT_2);
        Date birthByIdCardDateEnd = DateUtil.getEndTimeOfDay(birthByIdCardDate);
        // 根据身份证计算50岁生日日期
        Date fiftyYearsOld = DateUtil.offsetYear(birthByIdCardDateEnd, 50);
        /*if (effectiveDateAfter.compareTo(offsetYear) <=0) {
            System.out.println("导入时间+365天之后的日期:" + effectiveDateAfter);
            System.out.println("50岁生日日期：" + offsetYear);
        }*/
        if (oneYearLater.before(fiftyYearsOld)) {
            System.out.println("-------------------");
            System.out.println("导入时间+365天之后的日期:" + oneYearLater);
            System.out.println("50岁生日日期：" + fiftyYearsOld);
        }
        String rate = "18";
        //String dateStr = "";
        String dateStr = "2023-12-21 19:36:21";

        if (DateUtil.isDateTime(dateStr, DateUtil.DATE_FORMAT_1)) {
            System.out.println("是日期格式");
        }
        if (!checkNull(rate, dateStr)) {
            System.out.println("checkNull方法返回值："+checkNull(rate,dateStr));
        }

    }

    private boolean checkNull(String rate, String dateStr) {
        return !StringUtils.isNotBlank(rate) && StringUtils.isNotBlank(dateStr) && DateUtil.isDateTime(dateStr,
                DateUtil.DATE_FORMAT_1);
    }

    @org.junit.Test
    public void testMaps() {
        Map<EnumProductIdSummery, Object> map = Maps.newHashMap();
        map.put(EnumProductIdSummery.CRCS001, "10001");
        map.put(EnumProductIdSummery.CRCS002, "10002");
        map.put(EnumProductIdSummery.CRCS003, "10003");
        map.put(EnumProductIdSummery.CRCS003, "1000333");
        System.out.println(map);
        String str1 = "";
        String str2 = "";
        Boolean b1 = StringUtils.isNotBlank(str1);
        Boolean b2 = StringUtils.isNotBlank(str2);

        Object obj = map.get(null);
        String str3 = (String) obj;
        if (EnumProductIdSummery.CRCS003 == EnumProductIdSummery.find(str3)) {
            System.out.println("------------");
        }
        System.out.println(str3);
    }

    @org.junit.Test
    public void testList2() {
        List list = Lists.newArrayList();
        Boolean b = Boolean.FALSE;
        System.out.println(list);
        System.out.println(list.size());
        list.add(0);
        if (CollectionUtils.isNotEmpty(list)) {
            list.get(0);
        }
        if (CollectionUtils.isEmpty(list)) {
            // return;
        }
        System.out.println("---------------");
        if (list.contains(null)) {
            System.out.println("=======");
        }
        b = list.contains(0);
        System.out.println("b:" + b);

        System.out.println("9090:"+EnumProductIdSummery.find("CRCS001"));
        System.out.println("001:"+list.contains(null));
        System.out.println("002:"+list.contains("  "));
    }


    @org.junit.Test
    public void testBreak() {
        EnumProductIdSummery productIdSummery =  EnumProductIdSummery.find("");
        productIdSummery.toString();
        System.out.println(productIdSummery);
    }

    @org.junit.Test
    public void testContains() {
        Employee e = new Employee();
        Person p = new Person();
        e.setPerson(p);
        p.setName("张三");
        p.setAge(18);
        System.out.println(e);

        List<String> s = Lists.newArrayList();
        //s.add("1"); // 初始化
        s.add("2"); // 审批中
        s.add("3"); // 授信失效
        s.add("3"); // 授信失效
        s.add("4"); // 通过

        List s2 = Lists.newArrayList();
        s2.add("3");
        s2.add("4");
        System.out.println("size:" +s.size());
        System.out.println("get(0):"+s.get(0));
        System.out.println("s集合："+ s);
        List<String> status = s.stream().filter(input -> !input.equals("4"))
                .collect(Collectors.toList());

        System.out.println("status: "+ status);
        if (s2.containsAll(s)) {
            System.out.println("通过");
        } else {
            System.out.println("拒绝");
        }
    }

    @org.junit.Test
    public void testStream(){
        List<Person> list = Lists.newArrayList();
        List<Integer> lis2 = Lists.newArrayList();

        List<Integer> agelist = list.stream().map(Person::getAge).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(agelist)) {
            lis2.addAll(agelist);
        } else{
            lis2.addAll(agelist);
        }
        System.out.println(list);

    }

    @org.junit.Test
    public void testCalendar(){
        Calendar cld = Calendar.getInstance();
        cld.setTime(new Date());
        Integer eff = cld.get(Calendar.DAY_OF_MONTH);
        System.out.println(eff);
    }


    @org.junit.Test
    public void testListDemo() {
        List<Person> p = null;
        for (Person person : p) {
            System.out.println("---------");
        }

        Person p2 = null;
        Person p3 = new Person();
        p3.setName("测试3");
        p.add(p2);
        p.add(p3);

        System.out.println(p);
    }

    @org.junit.Test
    public void testIf() {
        // 存量的客户id
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("存量 id"+list);

        // 客户所有数据
        Person p = new Person();
        p.setAge(1);
        p.setName("张1");

        Person p2 = new Person();
        p2.setAge(2);
        p2.setName("张2");

        Person p3 = new Person();
        p3.setAge(3);
        p3.setName("张3");

        Person p4 = new Person();
        p4.setAge(4);
        p4.setName("张4");

        // 查出来该客户所有信息
        List<Person> personList = Lists.newArrayList();
        personList.add(p);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        System.out.println("客户所有数据personList：" + personList);

        List<Person> personsNew =
                personList.stream().filter(input -> !list.contains(input.getAge())).collect(Collectors.toList());
        System.out.println("仅处理新的数据personsNew：" + personsNew);

    }

    @org.junit.Test
    public void testFk() {

        // 创建一个数组
        ArrayList<String> sites = new ArrayList<>();

        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        System.out.println("网站列表: " + sites);


        // 查找位置索引值为 Runoob 的元素
        int position1 = sites.indexOf("Taobao");
        System.out.println("Runoob 的索引位置: " + position1);

        // 查找位置索引值为 Weibo 的元素
        int position2 = sites.indexOf("Weibo");
        System.out.println("Weibo 的索引位置: " + position2);
    }



    /**记录：一个List按照另一个List进行排序
     * https://blog.csdn.net/weixin_41988248/article/details/107785890
     * 一个List按照另一个List的数据顺序来排序
     * https://blog.csdn.net/haoshuai2015/article/details/93746529?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-93746529-blog-107785890.235^v43^control&spm=1001.2101.3001.4242.1&utm_relevant_index=3
     */
    @org.junit.Test
    public void testShunxu() {
        //这里的顺序，是我自己定义的一个List<String>
        /*String[] regulation = {"诸葛亮","鲁班","貂蝉","吕布"};
        final List<String> regulationOrder = Arrays.asList(regulation);
        String[] ordered = {"貂蝉","诸葛亮","吕布","貂蝉","鲁班","诸葛亮","貂蝉","鲁班","诸葛亮"};
        List<String> orderedList = Arrays.asList(ordered);
        Collections.sort(orderedList, new Comparator<String>()
        {
            public int compare(String o1, String o2)
            {
                int io1 = regulationOrder.indexOf(o1);
                int io2 = regulationOrder.indexOf(o2);
                return io1 - io2;
            }
        });
        System.out.println(orderedList);*/

        List<String> thirdCreditSerialList = Arrays.asList("8001","8002","8003");
        System.out.println("排序规则：" + thirdCreditSerialList);
        List<CreditApplyDo> creditApplyDos = Lists.newArrayList();


        CreditApplyDo creditApplyDo2 = CreditApplyDo.builder().build();
        creditApplyDo2.setCreditApplyId("2002");
        creditApplyDo2.setThirdpartApplyId("8002");
        creditApplyDo2.setProductId("CF000004");
        creditApplyDo2.setUserName("李2");

        CreditApplyDo creditApplyDo = CreditApplyDo.builder().build();
        creditApplyDo.setCreditApplyId("2001");
        creditApplyDo.setThirdpartApplyId("8001");
        creditApplyDo.setProductId("CF000004");
        creditApplyDo.setUserName("李1");

        CreditApplyDo creditApplyDo3 = CreditApplyDo.builder().build();
        creditApplyDo3.setCreditApplyId("2003");
        creditApplyDo3.setThirdpartApplyId("8003");
        creditApplyDo3.setProductId("CF000004");
        creditApplyDo3.setUserName("李3");

        CreditApplyDo creditApplyDo4 = CreditApplyDo.builder().build();
        creditApplyDo4.setCreditApplyId("2004");
        creditApplyDo4.setThirdpartApplyId("8004");
        creditApplyDo4.setProductId("CF000004");
        creditApplyDo4.setUserName("李4");

        creditApplyDos.add(creditApplyDo3);
        creditApplyDos.add(creditApplyDo2);
        creditApplyDos.add(creditApplyDo4);
        creditApplyDos.add(creditApplyDo);


        System.out.println("排列前的数据："); // 3\2\4\1
        System.out.println(creditApplyDos);
        List<String> creditApplyId1 =
                creditApplyDos.stream().map(CreditApplyDo::getCreditApplyId).collect(Collectors.toList());
        System.out.println(creditApplyId1);
        System.out.println();

        setListOrder(thirdCreditSerialList, creditApplyDos);

        System.out.println("排列后的数据：");
        System.out.println(creditApplyDos);

        List<String> creditApplyId2 =
                creditApplyDos.stream().map(CreditApplyDo::getCreditApplyId).collect(Collectors.toList());
        System.out.println(creditApplyId2);



    }

    /**
     * 这里说一下重写的 public int compareTo(){} 这个方法，它返回三种 int 类型的值： 负整数，零 ，正整数。
     * <p>
     * 返回值	含义
     * 负整数	当前对象的值 < 比较对象的值 ， 位置排在前
     * 零	当前对象的值 = 比较对象的值 ， 位置不变
     * 正整数	当前对象的值 > 比较对象的值 ， 位置排在后
     *
     * @param orderRegulation
     * @param targetList
     */
    public static void setListOrder(List<String> orderRegulation, List<CreditApplyDo> targetList) {
        //按照Posts的Id来排序
        Collections.sort(targetList, ((o1, o2) -> {
            int io1 = orderRegulation.indexOf(o1.getThirdpartApplyId());
            int io2 = orderRegulation.indexOf(o2.getThirdpartApplyId());

            if (io1 != -1) {
                io1 = targetList.size() - io1;
            }
            if (io2 != -1) {
                io2 = targetList.size() - io2;
            }
            // compareTo(Student o){} 这个方法，它返回三种 int 类型的值： 负整数，零 ，正整数
            return io2 - io1;
        }));
    }

    @org.junit.Test
    public void testIfElse() {
        String str = "2";
        if ("1".equals(str)) {
            System.out.println("11");
        } else if ("2".equals(str)) {
            System.out.println("22222");
        } else {
            System.out.println("333");
        }
    }

    @org.junit.Test
    public void testIndexOf() {
        String s = "findStrring";  //定义初始化一个字符串findString
        // 从头开始查找是否存在指定的字符         //结果如下
        System.out.println(s.indexOf("d"));     // 结果是3
        // 从第四个字符位置开始往后继续查找S，包含当前位置
        System.out.println(s.indexOf("S", 3));  //结果是4
        //若指定字符串中没有该字符则系统返回-1
        System.out.println(s.indexOf("o"));     //结果是-1
        //从指定的索引处开始向后搜索，返回在此字符串中最后一次出现的指定子字符串的索引
        System.out.println(s.lastIndexOf("r")); //结果是7
    }

    @org.junit.Test
    public void testList22() {
        Person p = new Person();
        p.setName("张1");
        p.setProduct(EnumProductIdSummery.CRCS001.getCode());
        p.setUsingAmount(new BigDecimal(0));

        Person p2 = new Person();
        p2.setName("张2");
        p2.setProduct(EnumProductIdSummery.CRCS002.getCode());
        p2.setTotalAmount(new BigDecimal(10000));
        List<Person> personList = Lists.newArrayList();

        personList.add(p);
        personList.add(p2);

        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Person person : personList) {
            EnumProductIdSummery product = EnumProductIdSummery.find(person.getProduct());
            if (EnumProductIdSummery.CRCS001 == product) {
                totalAmount = totalAmount.add(person.getUsingAmount());
            } else {
                totalAmount = totalAmount.add(person.getTotalAmount());
            }
        }
        BigDecimal noSy = totalAmount;
        System.out.println(noSy);

    }

    @org.junit.Test
    public void testNullll() {
        Map<String,Person> map = Maps.newHashMap();
        map.putAll(null);
        System.out.println(map);

        Person p = new Person();
        p.setName("张1");
        p.setProduct(EnumProductIdSummery.CRCS001.getCode());
        p.setUsingAmount(new BigDecimal(0));

        Person p2 = new Person();
        p2.setName("张2");
        p2.setProduct(EnumProductIdSummery.CRCS002.getCode());
        p2.setTotalAmount(new BigDecimal(10000));
        List<Person> personList = Lists.newArrayList();

        personList.add(p);
        personList.add(p2);
        System.out.println(personList);
        Map<String, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getName, o -> o,
                (a, b) -> b));

        map  = personMap;
        System.out.println(map);

    }

    @org.junit.Test
    public void testJvm() {
        // idea 中 VM 配置 -XX:+PrintGCDetails
        System.out.println("******Hello GC");
    }

    @org.junit.Test
    public void testJvmReference() {
        Map map = Maps.newHashMap();
        map.put("a","1");
        // map地址
        System.out.println("map的值：" + map +","+ System.identityHashCode(map));
        Map map2 = map;
        map.clear();
        // 打印map地址信息
        System.out.println("map2的值：" + map2 +","+ System.identityHashCode(map2));

    }

    @org.junit.Test
    public void testEnum1()  {
        String str = "CRCS001";

        boolean equals = EnumProductIdSummery.CRCS001.equals(str);
        if (equals) {
            System.out.println("-------------");
        }
        EnumProductIdSummery.CRCS001.name();
        System.out.println(EnumProductIdSummery.CRCS001.name());
        System.out.println(EnumProductIdSummery.CRCS001);
    }

    @org.junit.Test
    public void testIfPresent() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> iter = numbers.stream();
        Stream<Integer> filteredStream = iter.filter(num -> num % 2 == 0);
        //filteredStream.

    }

    @org.junit.Test
    public void TestDate() {
        Date date1 = new Date();

        Date date2 = DateUtil.dateAddDay(date1, 2);

        Instant instant1 = date1.toInstant();
        Instant instant2 = date2.toInstant();
        System.out.println("instant1:"+instant1);
        System.out.println("instant2:"+instant2);

        Duration duration = Duration.between(instant1, instant2);
        System.out.println("duration:" + duration.toHours());
        if (duration.toHours() < 24) {
            System.out.println("时间差小于24小时");
        } else {
            System.out.println("时间差大于24小时");
        }

    }

    @org.junit.Test
    public void testSort() {
        //测试数据，请不要纠结数据的严谨性
        List<StudentInfo> studentList = new ArrayList<>();
        StudentInfo studentInfo1 = new StudentInfo();
        studentInfo1.setName("张1");
        studentInfo1.setAge(21);
        studentInfo1.setGender("1");

        StudentInfo studentInfo2 = new StudentInfo();
        studentInfo2.setName("张2");
        studentInfo2.setAge(32);
        studentInfo2.setGender("2");


        StudentInfo studentInfo3 = new StudentInfo();
        studentInfo3.setName("张3");
        studentInfo3.setAge(43);
        studentInfo3.setGender("2");


        StudentInfo studentInfo4 = new StudentInfo();
        studentInfo4.setName("张4");
        studentInfo4.setAge(14);
        studentInfo4.setGender("3");

        StudentInfo studentInfo5 = new StudentInfo();
        studentInfo3.setName("张5");
        studentInfo3.setAge(5);
        studentInfo3.setGender("2");

        studentList.add(studentInfo2);
        studentList.add(studentInfo1);
        studentList.add(studentInfo3);
        studentList.add(studentInfo5);
        studentList.add(studentInfo4);

        System.out.println("原始数据："+ studentList);

        List<StudentInfo> studentInfos =
                studentList.stream().filter(input -> "2".equals(input.getGender())).collect(Collectors.toList());
        System.out.println("过滤后 studentInfoStream:" + studentInfos);
        // 通过年龄进行排序 sorted 默认升序（从小到大）
        List<StudentInfo> infos =
                studentInfos.stream().sorted(Comparator.comparing(StudentInfo::getAge)).collect(Collectors.toList());
        System.out.println("排序后的数据："+ infos);
        //StudentInfo studentInfo = infos.get(0);
        //System.out.println("studentInfo:"+studentInfo);
    }

    @org.junit.Test
    public void testCondition() {
        List<String> list = null;
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("========");
            System.out.println(list.size());
        }
        list.add("1");
        if (CollectionUtils.isEmpty(list) || list.size() ==1) {
            System.out.println("=22111111");
        }
    }
    public static final long Hour_24 = Long.parseLong("24");
    public static final long Hour_241 = 24;

    @org.junit.Test
    public void  testDate() {

        String dateString = "2024-07-24 10:25:00";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String dateString2 = "2024-07-25 10:24:59";

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = sdf.parse(dateString);
            System.out.println("beginDate: " + beginDate);
            endDate = sdf.parse(dateString2);
            System.out.println("endDate: " + endDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 计算两个时间的差值
        long ret = DateUtil.differDateInDays(beginDate, endDate, DateUtil.TimeType.HOUR);
        //int anInt = Integer.parseInt(String.valueOf(ret));
        System.out.println("两个时间的差值(单位小时)：" + ret);

        if (ret < Hour_241) {
            System.out.println("24h以内");
        } else {
            System.out.println("24h以外");
        }
    }

    @org.junit.Test
    public void testFilter() {
        //测试数据，请不要纠结数据的严谨性
        List<StudentInfo> studentList = new ArrayList<>();
        StudentInfo studentInfo1 = new StudentInfo();
        studentInfo1.setName("张1");
        studentInfo1.setAge(22);
        studentInfo1.setGender("1");

        StudentInfo studentInfo2 = new StudentInfo();
        studentInfo2.setName("张2");
        studentInfo2.setAge(22);
        studentInfo2.setGender("1");

        StudentInfo studentInfo3 = new StudentInfo();
        studentInfo3.setName("张3");
        studentInfo3.setAge(43);
        studentInfo3.setGender("1");

        StudentInfo studentInfo4 = new StudentInfo();
        studentInfo4.setName("张4");
        studentInfo4.setAge(22);
        studentInfo4.setGender("3");

        StudentInfo studentInfo5 = new StudentInfo();
        studentInfo3.setName("张5");
        //studentInfo3.setAge(5);
        studentInfo3.setGender("2");

        studentList.add(studentInfo1);
        studentList.add(studentInfo2);
        studentList.add(studentInfo3);
        studentList.add(studentInfo4);
        studentList.add(studentInfo5);

        List<StudentInfo> infos =studentList.stream()
                .filter(input -> input.getAge() != null && input.getAge() == 22)
                //.filter(input -> input.getAge() == 22)
                .filter(p -> p.getGender().equals("1"))
                .collect(Collectors.toList());

        System.out.println(infos);

    }

    @org.junit.Test
    public void testHuo() {
        String str1 = null;
        String str2 = "null";

        boolean b = StringUtils.isNotBlank(str1) || StringUtils.isNotBlank(str2);
        System.out.println(b);
    }


    @org.junit.Test
    public void testFilter2() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> list = numbers.stream()
                .filter(num -> num % 2 == 3)
                .filter(i -> i > 5)
                .collect(Collectors.toList());

        List<Integer> collect =
                list.stream().sorted(Comparator.comparing(Integer::byteValue)).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(collect)) {
            System.out.println(collect.get(0));
            System.out.println("----------------------");
        }
        System.out.println(collect);
    }

    @org.junit.Test
    public void testLock() {
        List<Person> list = Lists.newArrayList();

    }
}