package com.learn.www.exercise.other.demo1;
//包命名为网站名的倒写
//.*打入包下所有
/**
 * @author lowo
 * 2021/10/5->13:46
 */
public class Demo1 {
    //常量 final
    static final double PI = 3.14;
    //修饰符static & final 无顺序
    //类变量 static
    static double salary = 2500;


    //实例变量:从属于对象
    //如果不初始化 默认值 0 0.0 false 除了基本类型其余默认null
    String name;
    int age;

    //main方法
    public static void main(String[] args) {
        //m = (m^n)^n
//        int i = 1;
//        System.out.println((double) i);
        //else找if 为就近原则
        //局部变量:必须申明和初始化值
        String s1 = "Hello World!";
        System.out.println(s1);
        //变量类型 变量名字
        Demo1 demo1 = new Demo1();
        System.out.println(salary);
        System.out.println(demo1.name);
        System.out.println(demo1.age);
        double powTest = Math.pow(2,3);//2^3
        System.out.println("powTest = " + powTest);
        int c = 4;
        System.out.println((c++) == 4);
        System.out.println((++c) == 5);
        System.out.println("c = " + c);
        add();
        /*
        A = 0011 1100
        B = 0000 1101

        A&B = 0000 1100   //全为1才为1
        A|B = 0011 1101   //有1则为1
        A^B = 0011 0001  //相同为0不同为1
        ~B = 1111 0010  //取反

        a<<3//a*(2^3)
         */
        System.out.println(3<<3);//a<<3//a*(2^3)
        System.out.println(16>>3);//a>>3//a/(2^3) 需正好整除
        //x ? y : z;
        //x==true 则为y            x==false 则为z


    }

    //其他方法
    //  /** + enter 自动写出文档注释
    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public String test(String name) throws Exception{
        return name;
    }
    public static void add(){
        System.out.println(PI);
    }


}
