package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/15->19:26
 */

//类的内部成员之五：内部类
//1.Java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类
//2.内部类的分类：成员内部类（静态、非静态）VS局部内部类（方法内、代码块内、构造器内）
//3.成员内部类
//  一方面，作为外部类的成员
//      >调用外部类的结构( 外部类名.this.xx )[写xx省略(外部类名.this. 的前缀)]
//      >可以被static修饰
//      >可以被4种不同的权限修饰
//  另一方面，作为一个类：
//      >类内可以定义属性、方法、构造器等
//      >可以被fina1修饰，表示此类不能被继承。言外之意，不使用final，就可以被继承
//      >可以被abstract修饰

//  //创建Dog实例（静态的成员内部类）
//  Person.Dog dog =new Person.Dog();
//  dog.show();
//  //创建Bird实例（非静态的成员内部类）
//  //Person.Bird bird=new Person.Bird();//错误的
//  Person p=new Person();
//  Person.Bird bird = p.new Bird();

//public void display(String name){
//      System.out.println(name);//方的形参
//      System.out.println(this.name);//内部类的属性
//      System.out.println(Person.this.name);//外部类的属性
//}

//在局部内部类的方法中 如果调用局部内部类所声明的方法 中的局部变量 要求此局部变量声明为final的。
//jdk7及之前版本：要求此局部变量显式的声明为final的
//jdk8及之后的版本：可以省略final的声明 [自动补全]

//成员内部类和局部内部类，在编译以后，都会生成字节码文件。  格式：
//  成员内部类：外部类$内部类名.class
//  局部内部类：外部类$数字内部类名.c1ass

public class InnerClassTest {
    public static void main(String[] args) {

    }
}
