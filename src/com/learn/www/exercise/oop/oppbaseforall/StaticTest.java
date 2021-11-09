package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/14->19:39
 */

//static关键字的使用
//1.static:静态的
//2.static可以用来修饰：属性、方法、代码块、内部类
//3.使用static修饰属性：静态变量（类变量）
//     3.1属性，按是否使用static修饰，又分为：静态属性 VS 非静态属性（实例变量）
//      实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性。当修改其中一个对象中的
//      非静态属性时，不会导致其他对象中同样的属性值的修改。
//      静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，
//      会导致其他对象调用此静态变量时，是修改过了的。
//     3.2static修饰属性的其他说明
//      ①静态变量随着类的加载而加载[可以通过   "类.静态变量"  的方式进行调用]
//      ②静态变量的加载要早于对象的创建
//      ③由于类只会加载一次，则静态变量在内存中也只会存在一份[存在方法区的静态域中]
//      ④     类变量      实例变量
//        类.    yes         no
//        对象.  yes         yes
//     3.3静态属性举例： System.out;  Math.PI;
//4.使用static修饰方法：静态方法
//①随着类的加载而加载，可以通过“类.静态方法“的方式进行调用
//     静态方法     非静态方法
//类.    yes         no
//对象.  yes         yes
//
//静态方法中，只能调用 静态 的方法或属性
//非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性
//
//5.static注意点：
//  在静态的 方法 内，不能使用this关键字、super关键字    [省略的是"类名."]
//5.2关于静态属性和静态方法的使用，大家都从生命周期的角度去理解。
//
//6.开发中，如何确定一个属性是否要声明为static的
//  >属性是可以被多个对象所共享的，不会随着对象的不同而不同的。
//  >类中的常量也常常声明为static
//开发中，如何确定一个方法是否要声明为static的？
//  >操作静态属性(static)的方法，通常设置为static的
//  >工具类中的方法，习惯上声明为static的。比如：Math、Arrays、Collections

//main()方法的使用说明
//1.main()方法作为程序的入口
//2.main()方法也是一个普通的静态方法
//3.main()方法可以作为我们与控制台交互的方式。（之前：使用Scanner）

public class StaticTest {
    public static void main(String[] args) {
        Chinese.nation = "中国";//①静态变量随着类的加载而加载
        Chinese.show();
        Chinese p1 = new Chinese();
        System.out.println("p1.nation = " + p1.nation);
        p1.age = 12;
        p1.name = "lowo";
        Chinese p2 = new Chinese();
        p2.age = 13;
        p2.name = "jlower";

        p1.nation = "CHN";
        System.out.println(p2.nation);
        p2.nation = "CHINA";
        System.out.println(p1.nation);

    }
}
class Chinese{
    String name;
    static String nation;
    int age;
    public static void show(){
        //不能调用非静态的结构
        //可以调用静态的结构
        System.out.println(nation);//Chinese.nation  省略了"Chinese."  ["类名."]
    }
}
