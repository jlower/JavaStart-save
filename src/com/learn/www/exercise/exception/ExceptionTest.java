package com.learn.www.exercise.exception;

/**
 * @author lowo
 * 2021/10/15->21:14
 */

//一、异常体系结构
//java.lang.Throwable
//  -java.lang.Error：一般不编写针对性的代码进行处理
//  -java.lang.Exception：可以进行异常的处理
//      -编译时异常(checked)
//          -IOException
//              -FileNotFoundException
//          -ClassNotFoundException
//      -运行时异常(unchecked)
//          -NullPointerException
//          -ArrayIndexOutOfBoundsException
//          -ClassCastException
//          -NumberFormatException
//          -InputMismatchException
//          -ArithmeticException

public class ExceptionTest {
    public static void main(String[] args) {
        //NullPointerException
//        String[] s = null;
//        System.out.println(s[0]);
        //ArrayIndexOutOfBoundsException
//        int[] arr = new int[10];
//        System.out.println(arr[10]);

    }
}
