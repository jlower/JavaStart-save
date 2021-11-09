package com.learn.www.exercise.oop.interfacedemo;

/**
 * @author lowo
 * 2021/10/15->16:16
 */

//接口的使用
//1.接口使用interface来定义
//2.Java中，接口和类是并列的两个结构
//3.如何定义接口：定义接口中的成员
//  3.1  JDK7及以前：只能定义全局常量和抽象方法
//      >全局常量：public static final 的   但是书写时，可以省略不写
//      >抽象方法：public abstract 的   但是书写时，可以省略不写
//  3.2  JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
//      知识点1：接口中定义的静态方法，只能通过接口来调用
//      知识点2：通过实现类的对象，可以调用接口中的默认方法
//              如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
//      知识点3：如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的方法
//              那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法。=>类优先原则
//      知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法
//              那么在实现类没有重写此方法的情况下，报错。-->接口冲突
//              这就需要我们必须在实现类中重写此方法
//      知识点5：如何在子类（或实现类）的方法中调用父类、接口中被重写的方法
//      method3();//调用自己定义的重写的方法
//      super.method3();//调用的是父类中声明的
//      //调用接口中的默认方法
//      CompareA.super.method3();
//      CompareB.super.method3();



//4，接口中不能定义构造器的！意味着接口不可以实例化
//5.Java开发中，接口通过让类去实现（ implements ）的方式来使用
//  如果实现类实现了接口中的所有抽象方法，则此实现类就可以实例化
//  如果实现类没有实现接口中所有的抽象方法，则此实现类仍为一个抽象类
//6.Java类可以实现多个接口--->弥补了Java类单继承性的局限性
//  格式：class AA extends BB implements CC,DD，EE
//7.接口与接口之间可以继承，而且可以多继承
//8.接口的具体使用，体现多态性
//9.接口，实际上可以看做是一种规范

//1.接口使用上也满足多态性
//2.接口，实际上就是定义了一种规范
//3.开发中，体会面向接口编程

//接口的应用：代理模式（Proxy）
//应用场景：
//>安全代理：屏蔽对真实角色的直接访问。
//>远程代理：通过代理类处理远程方法调用（RMI）
//>延识加载：先加载轻量级的代理对象，真正需要再加载真实对象
//  比如你要开发一个大文档查看软件，大文档中有大的图片，有可能一个图片有100MB，在打开文件时，
//  不可能将所有的图片都显示出来，这样就可以使用代理模式，当需要查看图片时，用proxy来进行大图片的打开。
//分类
//  静态代理（静态定义代理类）
//  动态代理（动态生成代理类）JDK自带的动态代理，需要反射等知识



public class InterfaceTest {
    public static void main(String[] args) {
        Plane p = new Plane();
        DoAll.tryAll(p);
        //知识点1：接口中定义的静态方法，只能通过接口来调用
        Flyable.fly2();
        //知识点2：通过实现类的对象，可以调用接口中的默认方法
        p.fly3();//Plane.fly3();不行


    }

}
class DoAll{
    public static void tryAll(Flyable f){
        f.fly();
        //System.out.println("do");
    }
}
interface Flyable{
    //全局常量
    public static final int MAX_SPEED =  760000;
    //抽象方法
    public abstract void fly();

    //静态方法
    public static void fly2(){
        System.out.println("fly2");
    }
    //默认方法
    public default void fly3(){
        System.out.println("fly3");
    }
    default void fly4(){
        System.out.println("fly4");
    }
}

class Plane implements Flyable{
    @Override
    public void fly() {
        System.out.println("Plane fly");
    }
}