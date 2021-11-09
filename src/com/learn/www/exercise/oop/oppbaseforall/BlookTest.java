package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/14->21:27
 */

//类的成员之四：代码块(或初始化块)
//1.代码块的作用：用来初始化类、对象
//2.代码块如果有修饰的话，只能使用static
//3.分类：静态代码块VS非静态代码块
//4.静态代码块
//>内部可以有输出语句
//>随着类的加载而执行，而且只执行一次
//>作用：初始化类的信息 [对静态属性初始化]
//>如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
//>静态代码块内只能调用静态的属性、静态的方法，不能调用非静态的结构
//>静态代码块的执行要优先非静态代码块的执行
//5.非静态代码块
//>内部可以有输出语句
//>随着对象的创建而执行
//>每创建一个对象，就执行一次非静态代码块
//>作用：可以在创建对象时，对对象的属性等进行初始化
//>如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
//>非静态代码块内可以调用静态的属性、静态的方法，或非静态的属性、非静态的方法

//对属性可以赋值的位置(按顺序)
//>默认初始化
//>显式初始化  /  在代码块中赋值
    //加static也一样
//      [这两个若代码块赋值在显式初始化赋值之前写则用显式初始化赋的值](代码块执行时类似变量没声明，所以不执行)
//    {
//        age = 3;
//    }
//    int age = 10;
    //.age返回10

    // 加static也一样
//      [这两个若代码块赋值在显式初始化赋值之后写则用代码块赋的值](代码块执行时变量已声明，所以执行更改)
//    int age = 10;
//    {
//        age = 3;
//    }
    //.age返回3

//>构造器中初始化
//>有了对象以后，可以通过“对象.属性“或“对象.方法“的方式，进行赋值
//

//由父及子，静态先行
//父类先于子类，静态先于非静态[静态方法调用无需执行 构造器和非静态代码块 ]，代码块先于构造器    {执行顺序}

public class BlookTest {
    public static void main(String[] args) {

//        String desc = Human.desc;
        Human h1 = new Human();
//        Human h2 = new Human();
        H.eat2();
        System.out.println(h1.age);
    }
}
class H extends Human{
    {
        System.out.println(5);
    }
    public static void eat2(){
        System.out.println(2);
    }
    public H(){
        System.out.println("no");
    }
}
class Human{
    //属性
    String name;
    {
        age = 3;
    }
    int age = 10;

    public static String desc = "i am a human";
    //构造器
    public Human() {
        System.out.println(4);
    }
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //static代码块
    static {
        System.out.println("static");
    }
    //代码块
    {
        System.out.println("default");
    }

    //方法
    public void eat(){
        System.out.println("eat");
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void info(){
        System.out.println(desc);
    }
}
