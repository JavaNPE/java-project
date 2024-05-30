package com.hediancha;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @Author Dali
 * @Date 2021/8/8 11:31
 * @Version 1.0
 * @Description
 */
public class ClassLoaderTest {

    @Test
    public void test2() throws Exception {
        Properties pros = new Properties();
/*        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);*/
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user=" + user + ", password=" + password);




    }
}
