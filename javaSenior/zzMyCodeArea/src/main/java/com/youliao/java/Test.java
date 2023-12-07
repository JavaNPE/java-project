package com.youliao.java;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.youliao.bean.Employee;
import com.youliao.bean.Student;
import com.youliao.bean.User;
import com.youliao.entity.AttrEntity;
import com.youliao.enums.EnumBool;
import com.youliao.enums.EnumProductIdSummery;
import com.youliao.enums.NumberForCaseEnum;
import com.youliao.utils.BigDecimalUtil;
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
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        String s = EnumProductIdSummery.NBCBZJD001.getCode();
        if (s.equals(EnumProductIdSummery.NBCBZJD001.getCode())) {
            s = EnumProductIdSummery.NBCBZJD003.getCode();
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
        EnumProductIdSummery summery = EnumProductIdSummery.find("NBCBZJD004");
        switch (summery) {
            case NBCBZJD001:
                str = summery.getCode();
                break;
            case NBCBZJD002:
                str = summery.getCode();
                break;
            default:
                str = EnumProductIdSummery.NBCBZJD003.getCode();
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
        EnumProductIdSummery nbcbzjd003 = EnumProductIdSummery.valueOf("NBCBZJD003");
        if (EnumProductIdSummery.NBCBZJD003.equals(nbcbzjd003)) {
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
        childJsonObj.put("name", "NBCB");
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
        childJsonObj.put("name", "NBCB");
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
        childJsonObj.put("name", "NBCB");
        childJsonObj.put("position", "BJ");


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "stalin");
        jsonObj.put("old", "26");
        jsonObj.put("sex", "man");
        jsonObj.put("work", childJsonObj);

        System.out.println(jsonObj.toJSONString());

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
}