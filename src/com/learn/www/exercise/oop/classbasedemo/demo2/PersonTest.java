package com.learn.www.exercise.oop.classbasedemo.demo2;

/**
 * @author lowo
 * 2021/10/10->10:54
 */

//测试类
public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();
        //调用对象的结构：属性、方法
        //调用属性：“对象.属性”
        person.age = 10;
        //调用方法：“对象.方法()”
        person.eat();
        //三、如果创建了一个类的多个对象，则每个对象都独立的拥有一套类的属性。（非static的）
        //意味着：如果我们修改一个对象的属性a，则不影响另外一个对象属性a的值。
        Person person2 = new Person();
        person2.age = 15;
        System.out.println("person2.age = " + person2.age);
        System.out.println("person.age = " + person.age);
        Person person3 = person;
        person3.age = 18;
        System.out.println("person3.age = " + person3.age);
        System.out.println("person.age = " + person.age);
        person3.showAge(33);
        //堆（Heap），此内存区域的唯一目的就是存放对象实例，几乎所有的对象实例都在这里分配内存。
        //这一点在Java虚拟机规范中的描述是：所有的对象实例以及数组都要在堆上分配。

        //通常所说的栈（Stack），是指虚拟机栈。虚拟机栈用于存储局部变量等。
        //局部变量表存放了编译期可知长度的各种基本数据类型（boolean、byte、char、short、int、float、long、
        //double）、对象引用（reference类型它不等同于对象本身，是对象在堆内存的首地址）。方法执行完，自动释放。

        //方法区（MethodArea），用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。


    }
}

//类中属性的使用
//属性（成员变量）VS局部变量
//1.相同点：
//1.1定义变量的格式：数据类型变量名=变量值
//1.2先声明，后使用
//1.3变量都有其对应的作用域
//2.不同点：
//2.1在类中声明的位置的不同
//属性：直接定义在类的一对{}内
//局部变量：声明在方法内、方法形参、代码块内、构造器形参、构造器内部的变量
//2.2关于权限修饰符的不同
//属性：可以在声明属性时，指明其权限，使用权限修饰符。
//常用的权限修饰符：private、public、缺省(什么都不写)[default]、protected
//2.3默认初始化值的情况
//属性：类的属性，根据其类型，都有默认初始化值
//整型（byte、short、int、long）：0
//浮点型（float、double）：0.0
//字符型（char）：0（或"\u0000"）
//布尔型（boolean）：false
//引用数据类型（类、数组、接口）：nu11

//局部变量：没有默认初始化值
//意味着，我们在调用局部变量之前，一定要显式赋值。
//特别地：形参在调用时，我们赋值即可
//2.4在内存中加载的位置
//属性：加载到堆空间中（非static）
//局部变量：加载到栈空间

//3.2返回值类型：有返回值vS没有返回值
//3.2.1如果方法有返回值，则必须在方法声明时，指定返回值的类型。
//同时，方法中，需要使用return关键字来返回指定类型的变量或常量：“return数据”
//如果方法没有返回值，则方法声明时，使用void来表示。
//通常，没有返回值的方法中，就不使用return  但是，如果使用的话，只能"return;"表示结束此方法的意思
//3.注意点：break return 关键字后面不可以声明执行语句

//5.方法的使用中，可以调用当前类的属性或方法
//特殊的：方法A中又调用了方法A：递归方法     方法中，不可以定义方法。

class Person{
    //属性
    int age;
    int money;
    boolean isMale;
    //方法
    public void eat(){
        System.out.println("eating");
    }
    public void run(){
        System.out.println("running");
    }
    public void showAge(int age){
        System.out.println("this.age = " + this.age);
        System.out.println("age = " + age);
    }
}
