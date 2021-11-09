package com.learn.www.exercise.oop.classbasedemo.demo1;

/**
 * @author lowo
 * 2021/10/5->21:27
 */
public class StudentOne {
    //静态方法 加static
    public static void say() {
        System.out.println("student saying!");
    }
    //非静态方法 不加static
    //new实例化类之后才能用非静态方法
    public void say2() {
        System.out.println("student saying2!");
    }
}
