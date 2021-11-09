package com.learn.www.exercise.normalclass.other;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author lowo
 * 2021/10/18->18:18
 */
public class OtherClassTest {

    //BigInteger类 [java.math包的BigInteger可以表示不可变的任意精度的整数]
    //BigDecimal类 [一般的Float类和Double类可以用来做科学计算或工程计算，但在商业计算中，要求数字精度比较高，
    //      故用到java.math.BigDecimal类。BigDecimal类支持不可变的、任意精度的有符号十进制定点数。]

    @Test
    public void test2() {
        BigDecimal bd = new BigDecimal("24235.24352345");
        BigInteger bi = new BigInteger("4523453222222222222222222222222534532453453453534523");
        BigDecimal bd2 = new BigDecimal("23");
        System.out.println("bi = " + bi);
        System.out.println(bd.multiply(bd2));
        System.out.println(bd.divide(bd2));
    }
    //Math类
    //System类
    @Test
    public void test1(){
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version: " + osVersion);
        String userName = System.getProperty( "user.name" );
        System.out.println("user的name: " + userName);
        String userHome = System.getProperty( "user.home" );
        System.out.println("user的home:" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
    }
}
