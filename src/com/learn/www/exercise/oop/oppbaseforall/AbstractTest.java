package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/14->23:02
 */

//随着继承层次中一个个新子类的定义，类变得越来越具体，而父类则更一般，更通用。
//类的设计应该保证父类和子类能够共享特征。有时将一个父类设计得非常抽象，以至于它没有具体的实例，这样的类叫做抽象类。
//abstract关键字的使用
//1.abstract:抽象的
//2.abstract可以用来修饰的结构：类、方法
//3.abstract修饰类：抽象类
//>此类不能实例化
//>抽象类中一定有构造器，便于子类实例化时调用（涉及：子类对象实例化的全过程）
//>开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作
//4.abstract修饰方法：抽象方法
//>抽象方法只有方法的声明，没有方法[eg.public abstract void eat();]
//>包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法的
//>     若子类重写了父抽象类[包括祖先抽象类]中的所有的抽象方法后，此子类方可实例化
//      若子类没有重写父类中的所有的抽象方法，子类也是一个抽象类，需要使用abstract修饰

//abstract使用上的注意点
//1.abstract不能用来修饰：属性、构造器等结构
//2.abstract不能用来修饰私有方法、静态方法、final的方法、final的类

//抽象类的匿名子类
//抽象类的应用：模板方法的设计模式
//模板方法，把基本操作组合到一起，子类一般不能重写
//像个钩子，具体执行时，挂哪个子类，就执行哪个子类的实现代码


public class AbstractTest {
    public static void main(String[] args) {

        Book2 book2 = new Book2();
        method(book2);//非匿名的类非匿名的对象
        method(new Book2());//非匿名的类匿名的对象
        //创建了一个匿名子类的对象：b
        Book2 b = new Book2(){//对象b指向的是 为Book2的子类[匿名]  其重写了Book2的方法
            public void eat(){
                System.out.println("匿名子类 eat");
            }
        };
        method(b);
        method(new Book2(){//创建了一个匿名子类的匿名对象
            public void eat(){
                System.out.println("匿名子类 eat");
            }
        });
    }
    public static void method(Book2 book2){
        book2.eat();
    }
}

abstract class Book{
    String name;
    int age;
    public Book(){

    }

    public Book(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //抽象方法
    public abstract void eat();
}

class Book2 extends Book{
    public Book2() {
    }

    public Book2(String name, int age) {
        super(name, age);
    }
    public void eat(){
        System.out.println("Book2 eat");
    }
}