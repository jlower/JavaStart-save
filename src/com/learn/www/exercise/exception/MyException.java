package com.learn.www.exercise.exception;

/**
 * @author lowo
 * 2021/10/16->14:33
 */

//如何自定义异常类？
//1.继承于现有的异常结构：RuntimeException、Exception
//2.提供全局常量：serialVersionUID
//3.提供重载构造器

public class MyException extends RuntimeException{
    static final long serialVersionUID = -7034897190745766939L;
    public MyException(){

    }
    public MyException(String mes){
        super(mes);
    }
}
