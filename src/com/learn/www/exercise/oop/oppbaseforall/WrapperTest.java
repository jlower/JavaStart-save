package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/14->7:06
 */

//包装类的使用：
//1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
    
//int -> Integer         char -> Character

//2.掌握的：基本数据类型、包装类、String三者之间的相互转换
    //转换时，可能会报NumberFormatException

public class WrapperTest {
    public static void main(String[] args) {
        Integer i2= new Integer(1);
        Integer j2= new Integer(1);
        System.out.println(i2 == j2);//false
        Integer m = 1;
        Integer n = 1;
        //Cache缓存
        //-128 ~ 127  都提前在缓存中造好了
        //Integer m = 1; 与 Integer n = 1; 都是从Cache缓存中调用的同一个 1 来声明的 所以指向地址一样
        // m == n 判断m与n的地址一样 返回true
        //Integer内部定义了Integer Cache结构，Integer Cache中定义了Integer[]
        //保存了从-128~127范围的整数。如果我们使用自动装箱的方式，给Integer赋值的范围在-128~127范围内时，
        //可以直接使用数组中的元素，不用再去new了。提高装箱效率
        System.out.println(m == n);//true
        Integer x = 128;//new 了一个Integer对象
        Integer y = 128;
        System.out.println(x == y);//false

        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);//1.0  三元运算符会自动类型提升


        //String类型--->基本数据类型、包装类 : 调用包装类的parseXxx(String s)方法  [记住这个]
        String i = "1234";
        int numi = Integer.parseInt(i);

        System.out.println(numi + 1);

        //基本数据类型、包装类--->String类型 : 调用String重载的valueOf(Xxx xxx)
        int t1 = 10;
        //方式1：连接运算
        String s1 = t1 + "";
        //方式2：调用String重载的valueOf(Xxx xxx)
        float f11=12.3f;
        String str2=String.valueOf(f11);//"12.3"
        Double d11= new Double(12.4);
        String str3=String.valueOf(d11);
        System.out.println(str2);//"12.3"
        System.out.println(str3);//"12.4"

        //JDK5新特性：自动装箱与自动拆箱  [记住这个]
        //自动装箱：基本数据类型--->包装类
        int num1_2 = 10;
        Integer in1_2 = num1_2;//Integer in1_2 = 10//自动装箱
        System.out.println("in1_2.toString() = " + in1_2.toString());
        System.out.println(in1_2 + 1);//JDK5新特性可以自动转int
        boolean b1_1 = true;
        Boolean b1k = b1_1;//自动装箱
        System.out.println("b1k = " + b1k);
        //自动拆箱：包装类-->基本数据类型
        int num1_3 = in1_2;//自动拆箱
        System.out.println(in1_2 + 1);//自动拆箱
        System.out.println(num1_3 + 1);
//==============================================================================================
        //基本数据类型-->包装类：调用包装类的构造器

        int num1 = 10;
        Integer in1 = new Integer(num1);


        System.out.println("in1.toString() = " + in1.toString());
        Integer in2 = new Integer("123");
        System.out.println("in2.toString() = " + in2.toString());
        //Integer in3 = new Integer("123as");//报错

        Float f1 = new Float(12.3f);
        Float f2 = new Float("12.3");
        System.out.println("f1.toString() = " + f1.toString());
        System.out.println("f2.toString() = " + f2.toString());

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");//忽略大小写
        Boolean b3 = new Boolean("true31432");//false不报错
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);//false不报错
        Boolean isMan;//初始默认值为null

        //包装类--->基本数据类型 : 调用包装类Xxx的xxxValue()方法   [包装类不可运算]
        //已不用JDK5新特性可以自动转
        Integer in3 = new Integer(12);
        int num2 = in3.intValue();
        System.out.println(num2 + 2);
        Float f3 = new Float(12.3);
        float numf3 = f3.floatValue();
        System.out.println(numf3 + 0.2);//12.500000190734863   double与float运算不精确
        System.out.println(numf3 + 0.2f);//12.5精确
        System.out.println(numf3 + 1);//13.3精确
    }
}
