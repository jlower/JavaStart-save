package com.learn.www.exercise.oop.interfacedemo;

/**
 * @author lowo
 * 2021/10/7->5:37
 */

//普通类：只有具体实现
//抽象类：具体实现和规范（抽象方法）约束和实现分离：
//面向接口编程～
//接口：只有规范！自己无法写方法～专业的约束！的思想。
//接口的本质是契约，就像我们人间的法律一样。制定好后大家都遵守
//OO的精髓，是对对象的抽象，最能体现这一点的就是接口。

//接口不能被实例化～，接口中没有构造方法～
//implements可以实现多个接口
//必须要重写接口中的方法

//声明类的关键字是class  声明接口的关键字是interface
public interface UserService {

    //接口中的所有定义的属性其实都是常量      public static final(自动隐藏写)
    int AGE = 99;

    //接口中的所有定义的方法其实都是抽象的      public abstract(自动隐藏写)
    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);

}
