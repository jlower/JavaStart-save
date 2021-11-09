package com.learn.www.exercise.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author lowo
 * 2021/10/26->12:01
 */
public class LambdaTest {

    //Lambda表达式的使用
    //1.举例:  (o1,o2) -> Integer.compare(o1,o2);
    //2.格式:
    //  ->:Lambda操作符或箭头操作符
    //  ->左边: lambda形参列表(其实就是接口中的抽象方法的形参列表)
    //  ->右边: lambda体(其实就是重写的抽象方法的方法体)
    //3.Lambda表达式的使用:(分为6种情况介绍)
    //      语法格式一:无参，无返回值
    //      语法格式二: Lambda需要一个参数，但是没有返回值。
    //      语法格式三:数据类型可以省略，因为可由编译器推断得出，称为"类型推断"
    //      语法格式四:Lambda若只需要一个参数时，参数的小括号可以省略
    //      语法格式五: Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    //      语法格式六:当Lambda体只有一条语句时，return 与大括号若有，都可以省略
    //总结:
    //  ->左边: Lambda形参列表的参数类型可以省略(类型推断); 如果Lambda形参列表只有一个参数，其一对 () 也可以省略
    //  ->右边: Lambda体应该使用一对 {} 包裹;如果Lambda体只有一条执行语句(可以是return语句)
    //         则省略这一对 {} 和 return 关键字  [如果要省略则 {} 和 return 关键字 要同时省略 不能只省略其中一个]
    //4.Lambda表达式的本质:作为函数式接口的实例
    //  [ 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口 ]
    //5.如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口 [ Lambda表达式就是一个函数式接口的实例。 ]
    //我们可以在一个接口上使用@FunctionalInterface注解，这样做可以检查它是否是一个函数式接口。
    //  同时javadoc也会包含一条声明，说明这个接口是一个函数式接口。
    //      在java.util.function包下定义了Java 8的丰富的函数式接口
    //以前用匿名实现类表示的现在都可以用Lambda表达式来写。

    //java内置的4大核心函数式接口
    //  消费型接口Consumer<T>        void accept(T t)
    //  供给型接口Supplier<T>        T get()
    //  函数型接口Function<T,R>      R apply(T t)
    //  断定型接口Predicate<T>       boolean test(T t)
    //      eg.根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定

    @Test
    public void test8() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为: " + aDouble);
            }
        });
        happyTime(400, money -> System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为: " + money));
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    //语法格式一:无参，无返回值
    @Test
    public void test2() {
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("我爱北京天安门");
//            }
//        };
//        r1.run();
        Runnable r2 = () -> System.out.println("try");
        r2.run();
    }

    //语法格式二: Lambda需要一个参数，但是没有返回值。
    @Test
    public void test3() {
//        Consumer<String> con = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        con.accept("谎言和誓言的区别是什么?");
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("谎言和誓言的区别是什么?");
    }

    //语法格式三:数据类型可以省略，因为可由编译器推断得出，称为"类型推断"
    @Test
    public void test4() {
//        Consumer<String> con = (String s) -> { System.out.println(s); };
//        con.accept("谎言和誓言的区别是什么?");
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("谎言和誓言的区别是什么?");
        ArrayList<String> list = new ArrayList<>();//类型推断
        int[] arr = {1, 2, 3};//类型推断
    }

    //语法格式四:Lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test5() {
//        Consumer<String> con = (s) -> {
//            System.out.println(s);
//        };
//        con.accept("谎言和誓言的区别是什么?");
        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("谎言和誓言的区别是什么?");
    }

    //语法格式五: Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test6() {
//        Comparator<Integer> com1 = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                System.out.println("o1 = " + o1);
//                System.out.println("o2 = " + o2);
//                return o1.compareTo(o2);
//            }
//        };
//        System.out.println(com1.compare(234,242));
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println("o1 = " + o1);
            System.out.println("o2 = " + o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(32,234));
    }

    //语法格式六:当Lambda体只有一条语句时，若有 return 与 大括号，则都可以省略
    @Test
    public void test7() {
//        Comparator<Integer> com = (o1, o2) -> {
//            return o1.compareTo(o2);
//        };
//        System.out.println(com.compare(123,12));
        Comparator<Integer> com1 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com1.compare(1232,12));
    }

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();
        Runnable r2 = () -> System.out.println("try");
        r2.run();
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 32);
        System.out.println("compare1 = " + compare1);
        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(32, 12);
        System.out.println("compare2 = " + compare2);
        //方法引用
        Comparator<Integer> com3 = Integer::compare;//compareTo
        int compare3 = com3.compare(32, 12);
        System.out.println("compare3 = " + compare3);

    }
}


