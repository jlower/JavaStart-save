package com.learn.www.exercise.normalclass.string;

import org.junit.Test;

/**
 * @author lowo
 * 2021/10/17->14:15
 */
public class StringBufferTest {
    //String、StringBuffer、StringBuilder三者的异同?
    //String:不可变的字符序列;  底层使用char[]存储
    //StringBuffer:可变的字符序列;  线程安全的，效率低;   底层使用char[]存储
    //StringBuilder:可变的字符序列; jdk5.0新增的，线程不安全的，效率高;   底层使用char[]存储
    //源码分析:
    //String str = new String();//char[] value = new char[0];
    //String str1 = new String("abc");// char[] value = new char[]{'a','b','c'};
    //StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度为16的数组
    //sb1.append('a'); //value[0] = 'a';
    //sb1.append('b'); //vaLue[1] = 'b';
    //StringBuffer sb2 = new stringBuffer ("abc");//char[] value = new char["abc".Length() + 16]
    //问题1.  System.out.println(sb2.length());//3 [正常元素长度]
    //问题2.  扩容问题:如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。
    //           默认情况下，扩容为原来容量的 2倍( << 1 ) + 2，同时将原有数组中的元素复制到新的数组中。
    //指导意义:开发中建议大家使用:StringBuffer(int capacity)或 StringBuilder(int capacity)
    //        此构造器生成一个不会扩容的容量为int capacity的String 不用String了

    //对比String, StringBuffer、StringBuilder三者的效率:
    //从高到低排列: StringBuilder > StringBuffer > String

    //增:append(xxx)
    //删:delete(int start,int end)
    //改:setCharAt(int n,char ch) / replace(int start,int end,String str)
    //查:charAt(int n)
    //插:insert(int offset,xxx)
    //长度: length();
    //*遍历: for() + charAt() / toString()
    @Test
    public  void test(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//char[]加入'n' 'u' 'l' 'l'四个字符
        System.out.println(sb.length());//4
        System.out.println(sb);//"null"
//        StringBuffer sb1 = new StringBuffer(str);//抛异常NuLLPointerException
//        System.out.println(sb1);

        StringBuilder s1 = new StringBuilder("abc");
        s1.setCharAt(1,'x');
        s1.insert(1, "asf");
        s1.append("sdf");
        System.out.println("s1 = " + s1);
    }
}
