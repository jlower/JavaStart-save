package com.learn.www.exercise.oop.abstractclassdemo;

/**
 * @author lowo
 * 2021/10/7->5:24
 */
//加abstract 抽象类  extends单继承   接口可以多继承
public abstract class Action {
    //不能new抽象类   只能由继承了他的子类实现
    //抽象方法在抽象类中
    //抽象类中可以写普通方法


    //约束  有人帮我们实现
    //加abstract抽象方法 只有方法的名字 没有方法的实现
    public abstract void doSomthing();
}
