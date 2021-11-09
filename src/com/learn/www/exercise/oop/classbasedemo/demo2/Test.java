package com.learn.www.exercise.oop.classbasedemo.demo2;

/**
 * @author lowo
 * 2021/10/7->6:12
 */
public class Test {
    public static void main(String[] args) {
        //没有名字初始化类，不用讲实例保存到变量中
        //匿名内部类
        new Apple().eat();
        new UserServe() {
            @Override
            public void hello() {

            }
        };
    }
}
class Apple {
    public void eat() {
        System.out.println("1");
    }
}
interface UserServe{
    void hello();
}