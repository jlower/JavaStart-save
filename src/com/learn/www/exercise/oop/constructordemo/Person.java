package com.learn.www.exercise.oop.constructordemo;

/**
 * @author lowo
 * 2021/10/5->22:53
 */
public class Person {
    //构造器 必须有且必会被调用 没有也会自动给你加上
    //1.构造方法必须和类的名字相同
    //2.必须没有返回类型也不能写void
    //3.public

    public String name;
    public int age;


    //this.xx 表示当前类

    //实例化初始值 无参构造器
    public Person(){
        this.name = "lowo";
    }
    //有参构造器:一旦定义了有参构造,就必须显式定义无参构造,否则必须传参
    public Person(String name){
        this.name = name;
    }

    //alt+insert -> Constructor自动生成构造器  OK:默认有参     Select None:为无参
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
