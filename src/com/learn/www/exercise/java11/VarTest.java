package com.learn.www.exercise.java11;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author lowo
 * @Email
 * @Date 2021/10/27
 * @Description java or javascript
 */

public class VarTest {
    public static void main(String[] args) {
        //1.局部变量不赋值，就不能实现类型推断
        //  var num;
        //2.Lambda表示式中，左边的函数式接口不能声明为var
        Supplier<Double> sup = () -> Math.random();
        //  var sup = () -> Math.random();//错了
        //3.方法引用中，左边的函数式接口不能声明为var
        Consumer<String> con = System.out::println;
        //  var con = System.out::printLn;//错了
        //4.数组的静态初始化中，注意如下的情况也不可以
        int[] arr = {1, 2, 3, 4};
        //  var arr = {1, 2, 3, 4};
        //5.属性不可以用var定义


        var i = 10;
        var list = new ArrayList<Integer>();
        list.add(123);
        for (var integer : list) {
            System.out.println("integer = " + integer);
        }
    }
}
