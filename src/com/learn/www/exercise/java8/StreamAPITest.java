package com.learn.www.exercise.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lowo
 * 2021/10/26->19:55
 */
public class StreamAPITest {
    //1.Stream关注的是对数据的运算，与CPU打交道集合关注的是数据的存储，与内存打交道
    //2.注意:
    //  stream 自己不会存储元素。
    //  stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
    //  stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
    //3.Stream执行流程:
    //      Stream的实例化
    //      一系列的中间操作(过滤、映射、...)
    //      终止操作
    //4.说明:
    //  4.1   一个中间操作链，对数据源的数据进行处理
    //  4.2   一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用

    //测试Stream的终止操作
    @Test
    public void test3() {

        //1-匹配与查找

        //Predicate p 为lambda表达式
        //Comparator c 为定制排序

        //boolean allMatch(Predicate p)  检查是否匹配所有元素。
        //boolean anyMatch(Predicate p)  检查是否至少匹配一个元新。
        //boolean noneMatch(Predicate p)  检查是否没有匹配的元素。
        //Optional<T> findFirst  返回第一个 T类型的 元素   返回Optional<T>
        //Optional<T> findAny  返回当前流中的任意 T类型的 元素   返回Optional<T>
        //long count  返回流中元素的总个数
        //Optional<T> max(Comparator c)  返回流中最大值  所出的 T类型 元素   返回Optional<T>
        //Optional<T> min(Comparator c)  返回流中最小值  所出的 T类型 元素   返回Optional<T>
        //forEach(Consumer c)  内部迭代

        //使用Collection接口需要用户去做迭代,称为外部迭代
        //使用集合的遍历操作
        //      employees.forEach(System.out::println);

        //2-归约 reduce

        //T reduce(T identity, BinaryOperator)  可以将流中元素反复结合起来,得到一个值  返回T
        //      [ identity为初始值 ]
        //练1: 计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer integer = list.stream().reduce(0, Integer::sum);//[ identity为初始值 ]
        System.out.println("integer = " + integer);
        //reduce(BinaryOperator)—可以将流中元素反复结合起来，得到一个值。返回Optional<T>//没有初始值identity

        //3-收集

        //collect(Collector c)  将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
//        List<Employee> employees = EmployeeData.getEmployees();
//        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
    }

    //测试Stream的中间操作
    @Test
    public void test2() {
//        List<Employee> list = EmployeeData.getEmployees();

          //1-筛选与切片

//        //filter(Predicate p)  接收Lambda ,从流中排除某些元素。
//        Stream<Employee> stream = list.stream();
//        Stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
//        //limit(n)  截断流，使其元素不超过给定数量 n
//        list.stream().limit(3).forEach(System.out::println);
//        //skip(n)  跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个,则返回一个空流,与 limit(n) 互补
//        list.stream().skip(3).forEach(System.out::println);
//        //distinct()  筛选，通过流所生成元素的 hashcode()和equals()去除重复元素
//        list.stream().distinct().forEach(System.out::println);

        //2-映射

        //map(Function f)  接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //flatMap(Function f)  接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        list.stream().flatMap(StreamAPITest::fromStringToStream).forEach(System.out::println);
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
//        ArrayList list1 = new ArrayList();
//        list1.add(1);list1.add(2);list1.add(3);
//        ArrayList list2 = new ArrayList();
//        list2.add(4);list2.add(5);list2.add(6);
//        //list1.add(list2);//System.out.println(list1);   ->   [1, 2, 3, [4, 5, 6]] 四个元素list2当成一个list元素加进来了
//        list1.addAll(list2);//System.out.println(list1);   ->   [1, 2, 3, 4, 5, 6] 六个元素

        //3-排序

        //sorted()自然排序
        List<Integer> list2 = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list2.stream().sorted().forEach(System.out::print);
        //抛异常，原因:Employee没有实现Comparable接口
        //        List<Employees> employees = EmployeeData.getEmployees();
        //        employees.stream().sorted().forEach(System.out::println);
        System.out.println();

        //sorted(Comparator com)  定制排序
        list2.stream().sorted((a, b) -> b.compareTo(a)).forEach(System.out::print);

    }
    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){//aa
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }


    //测试Stream的实例化
    @Test
    public void test1() {
        //创建Stream 方式一: 通过集合
//        List<Employee> employees = EmployeeData.getEmployees();
//        //default Stream<E> stream() :返回一个顺序流
//        Stream<Employee> stream = employees.stream();
//        //default Stream<E> parallelStream() :返回一个并行流
//        Stream<Employee> parallelStream = employees.parallelStream();

        //创建Stream 方式二: 通过数组
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        //调用Arrays类的static <T> stream<T> stream(T[ ] array):返回一个流
        IntStream stream = Arrays.stream(arr);
//        Employee e1 = new Employee(1001, "Tom");
//        Employee e2 = new Employee(1002, "owo");
//        Employee[] arr1 = new Employee[]{e1, e2};
//        Stream<Employee> stream1 = Arrays.stream(arr1);

        //创建Stream 方式三: 通过stream的of()Test
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

        //创建Stream 方式四: 创建无限流
        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //eg.遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);




    }
}
