package com.learn.www.exercise.oop.overridedemo.demo1;

/**
 * @author lowo
 * 2021/10/6->20:52
 */
public class A extends B{
//    public static void test(){
//        System.out.println("A => test()");
//    }
    //Override重写
    @Override//注解:有功能的注释 不写也行
    public void test() {
        //super.test();//默认调用父类方法
        System.out.println("A => test()");
    }
}
