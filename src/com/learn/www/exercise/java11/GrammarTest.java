package com.learn.www.exercise.java11;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lowo
 * 2021/10/26->22:53
 */
public class GrammarTest {

    //java9新特性九: InputStream的新方法:tranferTo()

    //java9新特性八:  集合工厂方法:创建只读集合
    @Test
    public void test2() {
        List<String> namesList = new ArrayList<>();
        namesList.add("Joe");
        namesList.add("Bob");
        namesList.add("Bill");
        //返回的namesList是一个只读的集合
        namesList = Collections.unmodifiableList(namesList);
//        namesList.add("Tom");//报错
        System.out.println(namesList);
        List<Integer> list1 = List.of(1,2,3,4,5);//不能添加
        //list1.add(6);

    }

    //java9 特性五: 钻石操作符的升级
    @Test
    public void test1() {
        //钻石操作符与匿名内部类在java 8中不能共存。在java9可以。
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {

                return 0;
            }
        };
        //jdk7中的新特性:类型推断
        ArrayList<String> list = new ArrayList<>();
    }

    public static void main(String[] args) {
        //java 8中资源自动关闭操作 : java 8中,可以实现资源的自动关闭
        //要求自动关闭的资源的实例化必须放在try的一对小括号中
        try (InputStreamReader reader = new InputStreamReader(System.in)) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        //java9中资源自动关闭操作: 需要自动关闭的资源的实例化可以放在try的一对小括号外。
        //此时的资源属性是常量，声明为finaL的，不可修改
        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

