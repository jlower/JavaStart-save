package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/14->22:12
 */

//final：最终的
//1.final可以用来修饰的结构：类、方法、变量
//2.final用来修饰一个类：此类不能被其他类所继承[比如：String类、System类、StringBuffer类]
//3.final用来修饰方法：表明此方法不可以被重写[比如：Object类中getClass();]
//4.final用来修饰变量：此时的 "变量"  就称为是一个常量
//  4.1final修饰属性：可以考虑赋值的位置有：显式初始化、代码块中初始化、构造器中初始化   [不能不赋值]
//      [final不是static的话不能在static的代码块中初始化]
//
//4.2final修饰局部变量:
//      尤其是使用fina1修饰形参时，表明此形参是一个常量。当我们调用此方法时，给常量形参赋一个实参一旦赋值
//      以后，就只能在方法体内使用此形参，但不能进行重新赋值
//      [return x++;不行因为x变了][但是return x + 1;可以因为x没变]
//      [形参 final Other o 传入的是地址所以不能对o重新赋值(  eg. o = new Other();不行  )]

//static final用来修饰属性：全局常量


//native表示此方法不用Java写用底层的C/C++实现
public class FinalTest {
    public static void main(String[] args) {

    }
}
