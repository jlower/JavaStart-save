package com.learn.www.exercise.exception;

/**
 * @author lowo
 * 2021/10/7->6:33
 */
public class Test {

    //假设这方法中，处理不了这个异常。方法上抛出异常throws   方法中抛出异常throw
    public void test(int a,int b) throws ArithmeticException{
        if (b==0) { //throw
                throw new ArithmeticException();//主动的抛出异常,一般在方法中使用
        }
        //System.out.println(a/b);
    }
    public void test2(int a) throws MyException2 {//throws MyException与throw new MyException(a)都要写出
        if(a > 10){
            throw new MyException2(a);
        }
        System.out.println("a = " + a);
    }
    public static void main(String[] args) {
        int a=1;
        int b =0;

        try{
            new Test().test2(1);
            new Test().test2(100);
        }catch (MyException2 e){
            System.out.println(e);
            System.out.println("MyException = " + e);
        }

//        try {//有异常但程序不自动停止
//            new Test().test(a,b);
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        } finally {
//        }

        //ctrl+alt+t  ->  try/catch/finally快捷键自动生成
//        try {
//            if (b==0) { //throw     throws
//                throw new ArithmeticException();//主动的抛出异常,一般在方法中使用
//            }
//            System.out.println(a/b);
//        } catch (Exception e) {
//            e.printStackTrace();//打印错误的栈信息
//        } finally {
//        }

//        try {  //监控区
//            System.out.println(a/b);
//
//        }catch (ArithmeticException e) {//可以多个catch捕获异常可以捕获多个异常
//            // 大的异常类放下面 catch捕获到一个后就直接finally了
//            System.out.println(e);
//            System.out.println("catch ArithmeticException");//ArithmeticException
//        }catch (Exception e){
//            //Throwable不可以再Exception之上
//            System.out.println(e);
//            System.out.println("catch Exception");//ArithmeticException
//        }
//        catch (Throwable e){//catch捕获异常   Throwable高的异常类   Exception最高的异常类
//            System.out.println(e);
//            System.out.println("catch Throwable");//ArithmeticException
//        }finally {//善后工作最后必执行  可以不用finally
//            System.out.println("finally");
//        }

//        try {  //监控区
//            new Test().a();
//        }catch (ArithmeticException e){//catch捕获异常
//            System.out.println("catch");
//        }finally {//善后工作最后必执行(没捕获到也执行,先执行finally再报错)  可以不用finally
//            System.out.println("finally");
//        }
    }
//    public void a() {
//        b();
//    }
//    public void b() {
//        a();
//    }

}

