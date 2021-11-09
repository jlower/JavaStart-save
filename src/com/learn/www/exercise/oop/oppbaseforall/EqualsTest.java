package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/12->23:31
 */

//面试题：  ==  和 equals() 区别
//一、回顾  ==  的使用
// ==  运算符
//1.可以使用在基本数据类型变量和引用数据类型变量中[不能与boolean对象比较]
//2.如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
//  如果比较的是引用数据类型变量：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体[比较地址值是否相同]
//补充：  ==  符号使用时，必须保证符号左右两边的变量类型一致或能自动类型转换。

//二、equals()方法的使用
//1.是一个方法[只能适用于引用数据类型]，而非运算符
//2.只能适用于引用数据类型
//
//3.Object类中equals()的定义
//public boolean equals(Object obj) {
//        return (this == obj);
//        }
//使用   xx.equals(xxx)   //xx与xxx是引用数据类型
//说明：Object类中定义的equals()和 == 的作用是相同的：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
//4.像String、Date、Fi1e、包装类......都重写了Object类中的equals()方法。重写以后，比较的不是
//  两个引用的她址是否相同，而是比较两个对象的"实体内容"是否相同。
//5.通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的"实体内容"是否相同。那么，我们
//  就需要对Object类中的equals()进行重写

public class EqualsTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        double k = 10.0;
        double k2 = 10.1;
        float m = 10.1f;
        System.out.println(i == j);//true
        System.out.println(i == k);//true
        System.out.println(i == k2);//false
        System.out.println(k2 == m);//false!!!!!!!!!!!!!![double与float不要直接用 == 比较]
        char f = 10;
        System.out.println(i == f);//true
        boolean b = true;//不能与boolean对象比较
        //System.out.println(i == b);
        String s1 = new String("awawaw");
        String s2 = new String("awawaw");
        System.out.println(s1 == s2);//false
        System.out.println(s1.equals(s2));//true
        String s3 = "awawaw";
        String s4 = "awawaw";
        System.out.println(s3 == s4);//true//String在常量池中
        Customer c1 = new Customer(13,"123123");
        Customer c2 = new Customer(13,"123123");
        System.out.println(c1.equals(c2));//true
    }
}
class Customer{
    private int age;
    private String name;

    public Customer(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    //手写[不好]
    public boolean equals(Object o) {
        //重写Object类的equals()所以参数列表需要与Object类中的equals()一样为  (Object xxx)
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;//必定要强转
        //不用if(o instanceof Customer){Customer customer = (Customer) o;}//自己写记得 instanceof
        //因为getClass() != o.getClass()已经判断过了
        return age == customer.age && this.name.equals(customer.name);
    }


//    @Override
//    //自动生成
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Customer customer = (Customer) o;
//        return age == customer.age &&
//                Objects.equals(name, customer.name);
//    }
}

