package com.learn.www.exercise.oop.classbasedemo.demo1;

/**
 * @author lowo
 * 2021/10/5->21:18
 */

//class 类
public class Demo1 {
    //main 方法
    public static void main(String[] args) {

        StudentOne.say();
        //new实例化类之后才能用非静态方法
        //第一种:具体写出
        StudentOne student = new StudentOne();
        student.say2();
        //第二种:不具体写出
        new StudentOne().say2();

        int res1 = new Demo1().add(1,2);
        //调用静态方法
        System.out.println("res1 = " + res1);
    }
    //静态方法 加static 和类一起加载
    //非静态方法 不加static 类实例化后才存在
    //两个非静态方法之间可以互调   两个静态方法之间也可以互调    但静态方法中不可调用非静态方法
    public int add(int a,int b){
        return a+b;
    }
    
    /*
    修饰符  返回值类型  方法名(参数){
        //方法体
        return 返回值;//必有 return
    }
     */
    //return结束方法,返回值
    public static void hello() {
        return;
    }
}
