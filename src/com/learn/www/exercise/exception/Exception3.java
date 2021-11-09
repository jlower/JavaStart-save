package com.learn.www.exercise.exception;

/**
 * @author lowo
 * 2021/10/16->13:37
 */

//异常处理的方式二：throws+异常类型
//1.“throws+异常类型“写在方法的声明处。指明此方法执行时，可能会抛出的异常类型
//一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，
//此对象满足throws后异常类型时，就会被抛出。异常代码后续的代码，就不再执行！
//2.体会：try-catch-finally：真正的将异常给处理掉了
//       throws的方式只是将异常抛给了方法的调用者。并没有真正将异常处理掉。

public class Exception3 {
    public static void method3() throws NullPointerException{
        try {
            method2();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    public static void method2() throws NullPointerException{
        method1();
    }
    public static void method1() throws NumberFormatException,NullPointerException{
        String[] strings = new String[10];
        System.out.println(strings[0].equals("asdf"));
        //所谓的空指针异常，就是一个指针是空指针，你还要去操作它，
        // 既然它指向的是空对象，它就不能使用这个对象的方法。
        // 比如上面的s假如为null,你还要用s的方法，比如s.equals(String x);那么就会产生空指针异常。
    }
    public static void main(String[] args) {
        try {
            method2();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        method3();

    }
}
