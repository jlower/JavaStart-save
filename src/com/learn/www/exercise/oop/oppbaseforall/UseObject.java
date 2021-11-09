package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/12->23:22
 */

//java.lang.Object类
//1.Object类是所有Java类的根父类
//2.如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类
//3.Object类中的功能（属性、方法）就具有通用性。
    //clone()
    //equals(Object obj)
    //finalize()//垃圾回收//永远不要主动调用某个对象的finalize方法，应该交给垃圾回收器自动制调用
    //垃圾回收前调用finalize()
    //getClass()//返回此 Object 的运行时类。
    //hashCode()
    //notify()
    //notifyAll()
    //wait()
    //toString()
//4.Object类只声明了一个空参的构造器
//数组可以看作Object类的子类

public class UseObject {
    public static void main(String[] args) {
        OrderTest o1 = new OrderTest();
        System.out.println(o1.getClass().getSuperclass());
    }
}

class OrderTest{

}
