package com.learn.www.exercise.oop;

/**
 * @author lowo
 * 2021/10/10->10:43
 */
//一、Java面向对象学习的三条主线：（第4-6章）
//1.Java类及类的成员：属性、方法、构造器：代码块、内部类
//2.面向对象的三大特征：封装性、继承性、多态性、（抽象性）
//3.其它关键字：this、super、static、final、abstract、interface、package、import

//类：对一类事物的描述，是抽象的、概念上的定义
//对象：是实际存在的该类事物的每个个体，因而也称为实例（instance）
//>面向对象程序设计的重点是类的设计
//>设计类，就是设计类的成员

//一、设计类，其实就是设计类的成员
//属性=成员变量=field=域、字段
//方法=成员方法=函数=method

//理解“万事万物皆对象
//1.在Java语言范時中，我们都将功能、结构等封装到类中，通过类的实例化，来调用具体的功能结构
//>Scanner  String等
//>网络资源：URL
//2.涉及到Java语言与前端Html、后端的数据库交互时，前后端的结构在Java层面交互时，都体现为类、对象

//二、内存解析的说明
//1.引用类型的变量，只可能存储两类值：null或地址值（含变量的类型）

//三、匿名对象的使用
//1.理解：我们创建的对象，没有显式的赋给一个变量名。即为匿名对象
//2.特征：匿名对象只能调用一次。之后无法再用
//3.使用：匿名对象
//new Phone().sendEmail()
//new Phone()·playGame()
//new Phone().price=1999
//new Phone().showPrice()//0.0  并非1999
    
public class OOPTest {
    public static void main(String[] args) {

    }
}
