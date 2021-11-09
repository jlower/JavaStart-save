package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/13->0:23
 */

//Object类中toString()的使用
//1.当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
//2.Object类中toString()的定义:
//public String toString() {
//    return getClass().getName() + "@" + Integer.toHexString(hashCode());
//}
//3.像String、Date、File、包装类等都重写了Object类中的toString()方法
//使得在调用对象的tostring()时，返回“实体内容”信息
//4.自定义类也可以重写tostring（）方法，当调用此方法时，返回对象的"实体内容"

//Java中的Unit单元测试
//1.创建Java类，进行单元测试  ->  此时的Java类要求：①此类是public的②此类提供公共的无参的构造器
//2.此类中声明单元测试方法  ->  此时的单元测试方法：方法的权限是public，没有返回值，没有形参
//3.此单元测试方法上需要声明注解：@Test，并在单元测试类中导入：import org.junit.Test
//  [idea打@Test后自动导包]
public class ToStringTest {
    public static void main(String[] args) {
        String s = "abc";
        s = null;
        System.out.println("s = " + s);//System.out.println()有空指针保护机制
        //System.out.println(xx)如果xx是  null则输出"null"
        System.out.println("===============================");
        //System.out.println("s.toString() = " + s.toString());//NullPointerException异常

        Customer2 c1 = new Customer2(123,"lowo");
        System.out.println(c1.toString());//com.learn.www.exercise.oop.oppbaseforall.Customer2@7c30a502
        System.out.println(c1);//com.learn.www.exercise.oop.oppbaseforall.Customer2@7c30a502
    }
}


class Customer2{
    private int age;
    private String name;

    //自动生成
    @Override
    public String toString() {
        return "Customer2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Customer2(int age, String name) {
        this.age = age;
        this.name = name;
    }

}