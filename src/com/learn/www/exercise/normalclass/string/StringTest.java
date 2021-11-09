package com.learn.www.exercise.normalclass.string;

import org.junit.Test;

/**
 * @author lowo
 * 2021/10/17->4:47
 */

//String的使用

public class StringTest {
    //jdk 1.6 (jdk 6.0 ,java 6.0):字符串常量池存储在方法区(永久区)
    //jdk 1.7:字符串常量池存储在堆空间
    //jdk 1.8:字符串常量池存储在方法区(元空间)

    //1.常量(加final为常量)与常量的拼接结果在常量池,且常量池中不会存在相同内容的常量。["javaEE"与"java" + "EE"相同]
    //2.只要其中有一个是变量，结果就在堆中
    //3.如果拼接的结果调用intern()方法，返回值就在常量池中
    //值传递传地址值但由于String的不可变性String不会被改变，而数组传地址值则会改变原来的数组[相同地址值指向堆中同一地方]
    @Test
    public void test3(){
        String s9 = "hellolowo";
        final String s10 = "hello";//常量  而非变量
        String s11 = s10 + "lowo";
        System.out.println(s11 == s9);//true
        String s1 = "javaEE";
        String s2 = "lowo";
        String s3 = "javaEElowo";
        String s4 = "javaEE" + "lowo";
        String s5 = s1 + "lowo";
        String s6 =  "javaEE" + s2;
        String s7 =  s1 + s2;
        String s8 = s5.intern();//返回值得到的s8使用的常量值中已经存在的"javaEElowo"声明
        System.out.println(s8 == s3);//true
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

    }

    //String的实例化方式:
    //方式一:通过字面量定义的方式
    //方式二:通过new + 构造器的方式
    //面试题: String s = new String("abc");方式创建对象，在内存中创建了几个对象?
    //      两个:一个是堆空间中new结构，另一个是char[]对应的常量池中的数据: "abc"
    @Test
    public void test2(){
        //通过字面量定义的方式:此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中。
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方式:此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值。
        //  但里面的value值仍指向字符串常量池中的"javaEE" 若修改则需要重新指定内存区域赋值，不能使用原有的value进行修改。
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false

//        //本质上this.value = new char[0];string s1 = new String();
//        //this.value = original.value;
//        string s2 = new String(String original);
//        //this.value = Arrays.copyof(value， value.length);String s3 = new String(char[] a);
//        string s4 = new String(char[] a,int startIndex,int count) ;
    }

    //string:字符串，使用一对""引起来表示。
    //1.String声明为finaL的，不可被继承
    //2.String实现了Serializable接口:表示字符串是支持序列化的。
    //        实现了Comparable接口:表示String可以比较大小
    //3.String内部定义了final char[] value用于存储字符串数据
    //4.String:代表不可变的字符序列。简称:不可变性。
    //  体现:1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
    //      2.当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
    //      3.当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域，不能使用原有的value进行赋值。
    //5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
    //6.字符串常量池中是不会存储相同内容的字符串的。(唯一一个相同内容的字符串的地址赋给多个变量)
    @Test
    public void test1() {
        String s1 = "abc";//字面量的定义方式//方法区（含字符串常量池)
        String s2 = "abc";
        System.out.println(s1 == s2);//true
        s1 = "hello";
        System.out.println("s1 = " + s1);//hello
        System.out.println("s2 = " + s2);//abc
    }
}
