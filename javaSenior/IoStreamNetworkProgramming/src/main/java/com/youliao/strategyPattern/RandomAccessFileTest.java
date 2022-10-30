package com.youliao.strategyPattern;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * <p>
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 * 如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 * <p>
 * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 *
 * @author HedianTea
 * @create 2020 上午 11:18
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            //1.
            raf1 = new RandomAccessFile(new File("爱情与友情.jpg"), "r");
            raf2 = new RandomAccessFile(new File("爱情与友情1.jpg"), "rw");
            //2.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void test2() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        raf1.seek(3);//将指针调到角标为3的位置
        raf1.write("xyz".getBytes());//

        raf1.close();

    }

    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        raf1.seek(3);//将指针调到角标为3的位置
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, len));
        }
        //调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将StringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes());
        System.out.println(buffer.toString().toString());
        raf1.close();

        //思考：将StringBuilder替换为ByteArrayOutputStream
    }

    /**
     * 读取文件，根据“|”符号进行分割字符
     * 以“|”进行分割文件中的字符串
     * 将JSON转换成List
     */
    @Test
    public void test4() {
        try (RandomAccessFile raf = new RandomAccessFile("file.txt", "r")) {
            // 行内容
            String line;
            ArrayList<@Nullable Object> newArrayList = Lists.newArrayList();
            while ((line = raf.readLine()) != null) {
                // 以“|”进行分割文件中的字符串
                String[] splitArr = line.split("\\|");
                String s0 = splitArr[0];
                String s1 = splitArr[1];
                String s2 = splitArr[2];
                // 第一步：先获取jsonObject对象:JSONObject.parseObject()；
                String s3 = splitArr[3];
                //System.out.println("s0:" + s0 + ", s1:" + s1 + ", s2:" + s2 + ", s3:" + s3);
                // 将JSON转换成List
                System.out.println("s3:" + s3);
                HashMap hashMap = JSONObject.parseObject(s3, HashMap.class);
                String channelNo = (String) hashMap.get("channelNo");
                //System.out.println("channelNo:" + channelNo);

                //System.out.println("map:" + hashMap.toString());

                // 第二步：把对象转换成jsonArray数组

                //List<SmsBeanTest> smsBeanTests = JSONObject.parseArray(s3, SmsBeanTest.class);
                //System.out.println("smsBeanTests:" + smsBeanTests);
                Object OS3 = JSONObject.toJSON(s3);
                //System.out.println("OS3:" + OS3);
/*                List<SmsBeanTest> smsBeanTests = JSONObject.parseArray((String) OS3, SmsBeanTest.class);
                System.out.println(smsBeanTests);*/
                //List<SmsBeanTest> objects = JSONObject.parseArray(s3, SmsBeanTest.class);
                //System.out.println("objects:" +objects);
                List<String> strings = Arrays.asList(splitArr);
                newArrayList.add(strings);
            }
//            if (CollectionUtils.isNotEmpty(newArrayList)) {
//                System.out.println(newArrayList.toString());
//            } else {
//                System.out.println("------------------------");
//            }

            RandomAccessFile raf2 = new RandomAccessFile("file.txt", "r");
/*            String s = raf2.readLine();
            System.out.println(raf2.readLine());*/
            String line1;
            if (StringUtils.isNotBlank(raf2.readLine())) {
                System.out.println("首行内容：" + raf2.readLine());
            }
/*            while ((line1 = raf2.readLine()) != null) {
                System.out.println(raf2.readLine());
            }*/
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
