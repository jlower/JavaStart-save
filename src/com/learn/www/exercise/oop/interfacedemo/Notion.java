package com.learn.www.exercise.oop.interfacedemo;

/**
 * @author lowo
 * 2021/10/15->17:09
 */
interface A{
    int x = 0;
}
class B{
    int x = 1;
}
public class Notion extends B implements A{
    public void Me(){
        //System.out.println(x);//报错 有同名变量要指定清楚
        System.out.println(A.x);//0 接口中是全局常量  小心不可以修改全局常量[final声明的]
        System.out.println(super.x);//1 指定父类
    }
    public static void main(String[] args) {
        new Notion().Me();
    }
}
