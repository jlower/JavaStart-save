package com.learn.www.exercise.exception;

/**
 * @author lowo
 * 2021/10/7->6:20
 */

//异常Exception
//异常处理框架
//要理解Java异常处理是如何工作的，你需要掌握以下三种类型的异常：

//检查性异常：最具代表的检查性异常是用户错误或问题引起的异常这是程序员无法预见的
//例如要打开一个不存在文件时，一个异常就发生了，这些异常在编译时不能被简单地忽略

//运行时异常：运行时异常是可能被程序员避免的异常！与检查性异常相反，运行时异常在编译时能被忽略

//错误ERROR：错误不是异常而是脱离程序员控制的问题
//错误在代码中通常被忽略。例如，当栈溢出时一个错误就发生了，它们在编译也检查不到的


//Error类对象由Java虚拟机生成并抛出，大多数错误与代码编写者所执行的操作无关

//Java虚拟机运行错误（Virtual MachineError），当JVM不再有继续执行操作所需的内存资源时，
//将出现OutofMemoryError。这些异常发生时，Java虚拟机（JVM）一般会选择线程终止；

//还有发生在虚拟机试图执行应用时，如类定义错误（NoClassDefFoundError）、链接错误（LinkageError）。
//这些错误是不可查的，因为它们在应用程序的控制和处理能力之外，而且绝大多数是程序运行时不允许出现的状况

//在Exception分支中有一个重要的子类RuntimeException（运行时异常）
//    ArraylndexOutOfBoundsException（数组下标越界）
//    NullPointerException（空指针异常）
//    ArithmeticException（算术异常）
//    MissingResourceException（丢失资源）
//    ClassNotFoundException（找不到类）等异常，这些异常是不检查异常，程序中可以选择捕获处理，也可以不处理

//这些异常一般是由程序逻辑错误引起的，程序应该从逻辑角度尽可能避免这类异常的发生；

//Error和Exception的区别：Error通常是灾难性的致命的错误，是程序无法控制和处理的，
//当出现这些异常时，Java虚拟机（JVM）一般会选择终止线程；Exception通常情况下是可以被
//程序处理的，并且在程序中应该尽可能的去处理这些异常

public class Demo1 {
    public static void main(String[] args) {

    }
}
