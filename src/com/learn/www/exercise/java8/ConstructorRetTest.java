package com.learn.www.exercise.java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author lowo
 * 2021/10/26->19:04
 */
public class ConstructorRetTest {
    //      <Double,Long> 先参数类型 再返回类型
    //一、构造器引用
    //      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
    //      抽象方法的返回值类型即为构造器所属的类的类型
    //二、数组引用

    //数组引用  [ 当成 构造器引用 ]
    @Test
    public void test2() {
        //Function中的R apply(T t)
        Function<Integer,String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        Function<Integer, String[]> func2 = String[]::new;
        String[] arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));
    }

    //构造器引用 [ Xxx::new  来引用 ]
    @Test
    public void test1() {
        //Supplier中的 T get()
        //Employee的空参构造器:   Employee()    [ Employee::new  来引用 ]
//        Supplier<Employee> sup = new Supplier<Employee>() {
//            @Override
//            public Employee get() {
//                return new Employee();
//            }
//        };
//
//        Supplier<Employee> sup1 = () -> new Employee();
//        System.out.println(sup1.get());
//
//        Supplier<Employee> sup2 = Employee::new;
//        System.out.println(sup2.get());

        //Function中的R apply(T t)
        //Employee的构造器:   public Employee(int id)
//        Function<Integer, Employee> func1 = id -> new Employee(id);
//        Employee employee1 = func1.apply(1001);
//
//        Function<Integer, Employee> func2 = Employee::new;
//        Employee employee2 = func2.apply(1011);

        //BiFunction中的R apply(T t,U u)
        //Employee的构造器:   public Employee(int il,String name)
//        BiFunction<Integer, String, Employee> func1 = (id, name) -> new Employee(id, name);
//        System.out.println(func1.apply(1001, "Tom"));
//
//        BiFunction<Integer, String, Employee> func2 = Employee::new;
//        System.out.println(func2.apply(1001, "Tom"));
    }
}
