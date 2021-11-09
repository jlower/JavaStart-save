package com.learn.www.exercise.oop.abstractclassdemo;

/**
 * @author lowo
 * 2021/10/6->22:57
 */
public class StaticLearn {

    private static int age;//静态的变量
    private double score;//非静态的变量
    public static void main(String[] args) {
        StaticLearn s1 = new StaticLearn();
        System.out.println(StaticLearn.age);
        //System.out.println(StaticLearn.score);//非静态的变量不可用类名调
        System.out.println(s1.age);
        System.out.println(s1.score);

    }
}
