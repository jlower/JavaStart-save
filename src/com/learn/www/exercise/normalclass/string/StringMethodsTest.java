package com.learn.www.exercise.normalclass.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author lowo
 * 2021/10/17->12:01
 */
public class StringMethodsTest {

    //
    @Test
    public void test7() {

    }

    //String 与byte[]之间的转换
    //编码: String --> byte[]:调用 String 的getBytes()
    //解码: byte[] --> String:调用String的构造器
    //编码:字符串-->字节 (看得懂--->看不懂的二进制数据)
    //解码:编码的逆过程，字节-->字符串 (看不懂的二进制数据--->看得懂)
    //说明:解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
    @Test
    public void test6() {
        String s1 = "12334sdfa中文";
        byte[] by1 = s1.getBytes();//使用默认的字符集，进行转换
        System.out.println(Arrays.toString(by1));
        byte[] by2 = null;
        try {
            by2 = s1.getBytes("gbk");//使用gbk字符集进行编码。(要try-catch)
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(by2));
        String s2 = new String(by1);//使用默认的字符集，进行转换
        String s3 = null;
        String s4 = new String(by2);
        try {
            s3 = new String(by2,"gbk");//使用gbk字符集进行编码。(要try-catch)
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);//使用的字符集不一致，会出现乱码。

    }

    //String 与char[]之间的转换
    //String --> char[]:调用String的toCharArray()
    //char[] --> String:调用String的构造器new String(char[]);
    @Test
    public void test5(){
        String s1 = "12334sdfa";
        char[] c1 = s1.toCharArray();
        for (char c : c1) {
            System.out.print(c + " ");
        }
        System.out.println();
        char[] c2 = new char[]{'1','2','e','?'};
        String s2 = new String(c2);
        System.out.println(s2);
    }

    //复习:
    //String 与基本数据类型、包装类之间的转换。
    //String -->基本数据类型、包装类:调用包装类的静态方法: parseXxx(str)
    // 基本数据类型、包装类--> String:调用string重载的valueOf(xxx)

    //String replace(char oldChar, char newChar):返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有oldChar得到的。
    //String replace(CharSequence target,CharSequence replacement):使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
    //String replaceAll(String regex,String replacement):使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串。
    //String replaceFirst(String regex，String replacement):使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串。
    //boolean matches(String regex):告知此字符串是否匹配给定的正则表达式。
    //String[] split(String regex):根据给定正则表达式的匹配拆分此字符串。
    //String[] split(String regex, int limit):根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
    @Test
    public void test4(){
        String s1 = "qweqw";
        String s2 = s1.replace("qw","aa");
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    //boolean contains(CharSequence s):当且仅当此字符串包含指定的char值序列时，返回true
    //int indexOf(String str):返回指定子字符串在此字符串中第一次出现处的索引[第一个字符匹配的索引]
    //int indexOf(String str, int fromIndex):返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
    //int lastIndexOf(String str):返回指定子字符串在此字符串中最右边出现处的索引
    //int lastIndexOf(String str, int fromIndex):返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
    //    [indexOf和lastIndexOf方法如果未找到都是返回-1]
    ///什么情况下，indexOf(str)和lastIndexOf(str)返回值相同?
    //      情况一:存在唯一的一个str。情况二:不存在str

    //boolean endsWith(String suffix):测试此字符串是否以指定的后缀结束
    //boolean startsWith(String prefix):测试此字符串是否以指定的前缀开始
    //boolean startsWith(String prefix, int toffset):测试此字符串从指定索引开始的子字符串是否以指定前缀开始
    @Test
    public void test3(){
        String s1 = "hello world";
        boolean b1 = s1.endsWith("ld");
        System.out.println(b1);//true
        boolean b2 = s1.startsWith("He");//区分大小写
        System.out.println(b2);
        boolean b3 = s1.startsWith("ll",2);//下标
        System.out.println(b3);
        String s2 = "el";
        System.out.println(s1.contains(s2));
        System.out.println(s1.indexOf(s2));
        System.out.println(s1.indexOf("213"));
    }

    //int length():返回字符串的长度:return value.length
    //char charAt(int index):返回某索引处的字符return value[index]
    //boolean isEmpty():判断是否是空字符串:return value.length == 0
    //String toLowerCase():使用默认语言环境，将 String 中的所有字符转换为小写
    //String toUpperCase():使用默认语言环境，将 String 中的所有字符转换为大写
    //String trim():返回字符串的副本，忽略前导空白和尾部空白
    //boolean equals(Object obj):比较字符串的内容是否相同
    //boolean equalsIgnoreCase(String anotherString):与equals方法类似，忽略大小写
    //String concat(String str):将指定字符串连接到此字符串的结尾。等价于用“+”
    //int compareTo(String anotherString):比较两个字符串的大小(涉及到字符串排序)[负数为当前对象小 正数为当前对象大 0为两个对象相等]
    //String substring(int beginIndex):返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
    //String substring(int beginIndex,int endIndex):返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
    @Test
    public void test2(){
        String s1 = "Hello World!";
        String s2 = "hEllo world!";
        System.out.println(s1.equalsIgnoreCase(s2));
        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println("s4 = " + s4);
        String s5 = "abc";
        String s6 = "abdef";
        System.out.println(s5.compareTo(s6));//负数为当前对象s5小 正数为当前对象s5大 0为两个对象相等
        String s7 = "abcdefghij";
        String s8 = s7.substring(2);
        String s9 = s7.substring(2,5);
        System.out.println(s7);
        System.out.println(s8);
        System.out.println(s9);
    }
    @Test
    public void test1(){
        String s1 = "Hello World!";
        System.out.println(s1.length());
        System.out.println(s1.charAt(3));
        System.out.println(s1.isEmpty());
        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1不可变的，仍然为原来的字符串
        System.out.println(s2);//改成小写以后的字符串
        String s3 = "  He l l o World!  ";
        String s4 = s3.trim();//忽略前导空白和尾部空白 [输入用户名时使用]
        System.out.println("----" + s3 + "----");
        System.out.println("----" + s4 + "----");
    }
}
