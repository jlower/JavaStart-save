package com.learn.www.exercise.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author lowo
 * 2021/10/16->13:49
 */

//方法重写的规则之一
//子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型[为了多态时好处理异常]
//父类被重写的方法没有throws抛出异常，则子类重写的方法不能throws抛出的异常


public class OverrideTest {
    public static void main(String[] args) {

    }
}
class SuperClass{
    public void method() throws IOException{

    }
}
class SubClass extends SuperClass{
    public void method() throws FileNotFoundException{


    }
}
