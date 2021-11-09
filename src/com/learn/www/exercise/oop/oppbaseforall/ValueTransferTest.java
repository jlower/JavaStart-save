package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/10->18:54
 */
public class ValueTransferTest {
    public static void main(String[] args) {
        //类中的属性放在堆里[类在堆中的内存空间]，类中申明的方法中申明的值放在栈里

        //1.内存结构：栈（局部变量）、堆（new出来的结构：对象[非static成员变量]、数组）
        //2.变量：成员变量 vs 局部变量（方法内、方法形参、构造器内、构造器形参、代码块内）


        //关于变量的赋值：
        //如果变量是基本数据类型，赋值时赋值的是变量所保存的数据值
        //如果变量是引用数据类型，赋值时赋值的是变量所保存的数据的地址值。[数组当作引用数据类型]
        //**小心String**
        //如果参数是基本数据类型，此时实参赋给形参的是实参真实存储的数据值[copy了一份，没把自己传过去]
        //如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值[把自己传过去了][数组当作引用数据类型]
        int m = 10;
        //如果变量是基本数据类型，赋值时赋值的是变量所保存的数据值
        int n = m;//基本数据类型
        System.out.println("n = " + n);
        System.out.println("m = " + m);
        n = 20;
        System.out.println("n = " + n);
        System.out.println("m = " + m);
        System.out.println("======================================");
        Order o1 = new Order();
        o1.id = 1001;
        //引用数据类型只有 new  才会在堆空间中创建一个新的对象实体
        //如果变量是引用数据类型，赋值时赋值的是变量所保存的数据的地址值。[数组当作引用数据类型]
        Order o2 = o1;//引用数据类型     赋值以后，o1和o2的地址值相同，都指向了堆空间中同一个对象实体
        System.out.println("o1.id = " + o1.id);
        System.out.println("o2.id = " + o2.id);
        o2.id = 1002;//指向同一个对象实体改一个则都变
        System.out.println("o1.id = " + o1.id);
        System.out.println("o2.id = " + o2.id);

    }
}

class Order{
    int id;

}
