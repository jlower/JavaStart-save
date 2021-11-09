package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/11->21:08
 */

//类的结构之三：构造器（或构造方法、constructor）的使用//constructor：建设者
//construct：建设、建造。construction：CCB

//一、构造器的作用：
//1.创建对象
//2.初始化对象的信息

//二、说明
//1.如果没有显式的定义类的构造器的话，则系统默认提供一个空参的构造器
//2.定义构造器的格式： 权限修饰符 类名(形参列表){}
//3.一个类中定义的多个构造器，彼此构成重载
//4.一旦我们显式的定义了类的构造器之后，系统就不再提供默认的空参构造器,若要用则要自己写空参构造器
//5.一个类中，至少会有一个构造器

//总结：属性赋值的先后顺序
//1.默认初始化  int age;
//2.显式初始化  int age = 100;
//3.构造器中初始化    赋值

    //1,2,3只执行一次 而4可以反复调用执行

//4.通过”对象.方法”或“对象.属性“的方式，赋值

//以上操作的先后顺序：1 - 2 - 3 -4

//JavaBean是一种Java语言写成的可重用组件。
//所谓javaBean，是指符合如下标准的Java类
//>类是公共的
//>有一个无参的公共的构造器
//>有属性，且有对应的get、set方法

//用户可以使用JavaBean将功能、处理、值、数据库访间和其他任何可以用Java代码创造的对象进行打包，
//并且其他的开发者可以通过内部的JSP页面、Servlet、其他JavaBean、applet程序或者应用来使用这些对象。
//用户可以认为JavaBean提供了一种随时随地的复制和粘贴的功能，而不用关心任何改变。



public class ConstructorTest {
    public static void main(String[] args) {
        //创建对象 new + 构造器
        Person person = new Person("lowo");
    }
}

class Person{
    //属性
    int age;
    String name;
    //构造器
    //自动隐式生成的无参构造器权限修饰符和它的类的权限修饰符相同
    public Person(){
        System.out.println("Person()...");
    }
    public Person(String n){
        this.name = n;
        System.out.println("Person(String n)... "+ this.name );
    }

    //方法
    public void eat(){
        System.out.println("eating");
    }
}