package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/11->21:47
 */

//this关键字的使用
//1.this可以用来修饰：属性、方法、构造器
//2.this修饰属性和方法：
//this理解为：当前对象

//this表示当前对象   要传当前对象给别人直接用this   eg.  xx.xxx.(this)

//在类的方法或构造器中，我们可以使用“this.属性”或“this.方法“的方式，调用当前对象属性或方法。
//通常情况下，我们都选择省略“this.“。
//特殊情况下，如果方法的形参和类的属性同名时，我们必须显式的使用“this.变量“的方式，表明此变量是属性，而非形参。

//this()调用空形参构造器   this(xxx)调用有形参构造器
//this(),this(xxx)只能在构造器中用   只是为了减少冗余的重复代码

//this调用构造器
//1.我们在类的构造器中，可以显式的使用   “this(形参列表)“ / “this()“  的方式，调用本类中指定的  其他  构造器
//2.构造器中不能通过    “this(形参列表)“ / “this()“     的方式调用自己
//3.如果一个类中有n个构造器，则最多有n-1构造器中使用了  “this(形参列表)“ / “this()“   不能成环
//4.规定：“this(形参列表)“ / “this()“  必须声明在当前构造器的首行
//5.构造器内部，最多只能声明一个“this(形参列表)“ / “this()“，用来调用其他的构造器

//对象比较大小  return this.xx - X.xx;//X为传入的对象  this为当前本身的对象
//负数:当前对象小; 正数:当前对象大; 0:当前对象与形参对象相等

public class ThisTest {
    public static void main(String[] args) {
        ThisPerson p1 = new ThisPerson(1,"lowo");

    }
}

class ThisPerson{
    int age;
    String name;
    public ThisPerson(){
        System.out.println("open this()!!!");
    }

    public ThisPerson(int age) {
        this();//this()调用空形参构造器
        this.age = age;
    }

    public ThisPerson(int age, String name) {
        this(age);//this(age)调用有形参构造器   可以赋值age
        this.name = name;
        //this.age = age;//可不用写
    }
    public void eat(int age){


    }
}
