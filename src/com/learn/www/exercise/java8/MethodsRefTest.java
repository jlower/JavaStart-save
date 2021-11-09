package com.learn.www.exercise.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author lowo
 * 2021/10/26->18:35
 */

public class MethodsRefTest {
    //方法引用的使用
    //      <Double,Long> 先参数类型 再返回类型
    //1.使用情境:当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用!
    //2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例。
    //3．使用格式:   类(或对象)::方法名
    //4.具体分为如下的三种情况:
    //情况1      对象::非静态方法(实例方法)
    //情况2      类::静态方法

    //情况3      类::非静态方法(实例方法)
    //5．方法引用使用的要求: 要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同!
    //   [ 针对于 情况1 和 情况2 ]

    //情况一:    对象::非静态方法(实例方法)
    @Test
    public void test1() {
        //Consumer中的void accept(T t)
        //PrintStream中的void printLn(T t)
        Consumer<String> con1 = str -> System.out.println(str) ;
        con1.accept("北京");
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("try");
        //Supplier中的T get()
        //Employee中的String getName()
//        Employee emp = new Employee( id: 1001,name: "Tom" , age: 23,salary: 5600);
//        Supplier<String> sup1 = () -> emp.getName();
//        System.out.print1n( sup1.get());
//        Supplier<String> sup2 = emp::getName;
//        System.out.println( sup2.get());
    }

    //情况二:   类::静态方法
    @Test
    public void test2() {
        //Comparator中的int compare(T t1,T t2)
        //Integer中的int compare(T t1,T t2)
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(12, 21));
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12, 3));
        //Function中的R apply(T t)
        //Math中的Long round(Double d)
        Function<Double,Long> func1 = d -> Math.round(d);//<Double,Long> 先参数类型 再返回类型
        System.out.println(func1.apply(12.3));
        Function<Double, Long> func2 = Math::round;
        System.out.println(func1.apply(12.6));
    }

    //情况三:   类::实例方法(有难度)
    @Test
    public void test3() {
        //Comparator中的 int compare(T t1, T t2)
        //String中的     int t1.compareTo(t2)
        Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com1.compare( "abc" ,"abd" ));
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare( "abc" ,"abd" ));
        //BiPredicate中的 boolean test(T t1， T t2);
        //String中的      boolean t1.equals(t2)

        //Function中的    R apply(T t)
        //Employee中的    String getName( );
    }

}


