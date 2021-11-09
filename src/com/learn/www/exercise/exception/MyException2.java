package com.learn.www.exercise.exception;

/**
 * @author lowo
 * 2021/10/7->6:58
 */

//自定义异常要继承Exception类
public class MyException2 extends Exception{

    private int detail;

    public MyException2(int a) {
        this.detail = a;
    }

    //toString
    @Override
    public String toString() {
        return "MyException{" + "detail=" + detail + '}';
    }
}
