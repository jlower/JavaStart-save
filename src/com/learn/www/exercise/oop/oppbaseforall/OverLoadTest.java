package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/10->12:26
 */

//方法的重载（overload）1oading..
//1.定义：在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可。
//只有返回值类型不同不行,只有方法的权限修饰符不同不行
//跟方法的权限修饰符、返回值类型、形参变量名、方法体都没有关系
//重载的特点
//与返回值类型无关，只看参数列表，且参数列表必须不同（参数个数或参数类型）。调用时，根据方法参数列表的不同来区别


public class OverLoadTest {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3};
        System.out.println(arr);//public void println(Object x)//地址值
        char[] arr1 = new char[]{'a','b','c'};
        System.out.println(arr1);//public void println(char x[])//abc [上下两个调用的方法不同][重载了]

        OverLoadTest test = new OverLoadTest();
        test.getSum(1,2);//int自动类型提升为double
    }
    public void getSum(String s,int i){
        System.out.println(1);
        System.out.println(s + i);
    }
    public void getSum(int i,String s){
        System.out.println(2);
        System.out.println(s + i);
    }
//    public void getSum(int s,int i){
//        System.out.println(3);
//        System.out.println(s + i);
//    }
    public void getSum(double s,double i){
        System.out.println(4);
        System.out.println(s + i);
    }
//    public int getSum(int s,int i){
//        System.out.println("s + i = " + s + i);
//        return (s + i);
//    }
}
