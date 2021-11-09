package com.learn.www.exercise.java8;

/**
 * @author lowo
 * 2021/10/26->21:44
 */

public class OptionalTest {
    //Optional<T> 类(java.util.Optional)是一个容器类，它可以保存类型T的值，代表这个值存在。或者仅仅保存null，
    //表示这个值不存在。原来用null表示一个值不存在，现在Optional可以更好的表达这个概念。并且可以避免空指针异常。

    //Optional类:为了在程序中避免出现空指针异常而创建的。常用的方法:
    //ofNullable(T t)
    //orElse(T t)

    //Optional.of(T t): 创建一个Optional实例，t必须非空;
    //Optional.empty(): 创建一个空的Optional实例
    //Optional.ofNullable(T t): t可以为null

    //orELse(T t1):如果当前的Optional内部封装的t是非空的，则返回内部的t
    //             如果内部的t是空的，则返回orElse()方法中的参数t1

}
