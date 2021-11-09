package com.learn.www.exercise.oop.classbasedemo.demo2;

/**
 * @author lowo
 * 2021/10/7->5:57
 */



//内部类就是在一个类的内部在定义一个类，比如，
// A类中定义一个B类，那么B类相对A类来说就称为内部类，而A类相对B类来说就是外部类了

//1.成员内部类
//2.静态内部类
//3.局部内部类
//4.匿名内部类
public class Outer {
    private int id = 10;
    public void out() {
        System.out.println("这是外部类的方法");
    }
    public class Inner {//加public才能调用   成员内部类
        public void in() {
            System.out.println("这是内部类的方法");
        }
        //能获得外部类的私有属性    或  方法
        public void getID(){
            System.out.println(id);
        }
    }

//    public static class Inner {//   静态内部类
//        public void in() {
//            System.out.println("这是内部类的方法");
//        }
//        //静态内部类不能获得外部类的非静态的属性    或  非静态的方法
////        public void getID(){
////            System.out.println(id);
////        }
//
//
//    }
}
