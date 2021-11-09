package com.learn.www.exercise.oop.extendsdemo;

/**
 * @author lowo
 * 2021/10/5->23:51
 */
public class Person {

    //保护优先级
    //public
    //protected
    //default  //默认什么都不写
    //private
    protected String name = "lowo";
    private int money;//私有的东西被继承不能直接调 要用set get函数调
    public void print(){
        System.out.println("Person.print!!");
    }
    public Person() {
        System.out.println("Person的无参构造");
    }
//    private int money = 10_0000_0000;
//    public void say(){
//        System.out.println("say!");
//        return;
//    }
//    public int getMoney() {
//        return money;
//    }
//
//    public void setMoney(int money) {
//        this.money = money;
//    }
}
