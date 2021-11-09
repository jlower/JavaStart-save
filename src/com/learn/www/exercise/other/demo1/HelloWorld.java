package com.learn.www.exercise.other.demo1;

import java.util.ArrayList;
import java.util.Arrays;

public class HelloWorld {
    //模板六:prsf  private static final
    //psf   public static final
    //psfi   public static final int
    //psfs   public static final String


    //模板一:psvm
    public static void main(String[] args) {
        //模板二:sout
        System.out.println("Hello World");//输出数据并换行
        System.out.print("Hello World");//只输出数据不换行
        //soutp带参
        System.out.println("args = " + Arrays.deepToString(args));
        //soutm带类名
        System.out.println("Helloworld.main");
        //soutv   就近选择变量
        int num =1;
        System.out.println("num = " + num);
        //xxx.sout 打印xxx
        System.out.println(num);

        //模板三:fori
//         for (int i = 0; i < ; i++) {
//
//         }
        //iter
        String[] arr = new String[]{"sdf","ADSfa"};
        for (String s : arr) {
            System.out.println(s);
        }
        //itar
//        for (int i = 0; i < arr.length; i++) {
//            String s = arr[i];
//            System.out.println(s);
//        }
        //xxx.for
        ArrayList li = new ArrayList();
        li.add(23);
        li.add(21233);
        li.add(233);
        for (Object o : li) {
            System.out.println(o);
        }
        //xxx.fori
        for (int i = 0; i < li.size(); i++) {
            
        }
        //xxx.forr
        for (int i = li.size() - 1; i >= 0; i--) {
            
        }

        /*

         */

        /**
         *
         *
         *
         */
        int a3 = 0x10;//十六进制
        int a2 = 010;//八进制
        int a = 1;//十进制
        short b = 1;
        byte c = 1;
        long d = 14524353463456342L;//结尾加L/l
        float s = 124535F;//结尾加F/f
        double s1 = 1;
        char aa = '1';
        char sf = '\u0043';//unicode编码   前加
        String aaa = "1231";
        boolean a23 = true;//false
        //最好完全避免使用浮点数进行比较






    }

    public static void method() {
        ArrayList li = new ArrayList();
        li.add(23);
        li.add(21233);
        li.add(233);
        //模板五:ifn   /  xxx.null
        if (li == null) {

        }
        //inn     /   xxx.nn
        if (li != null) {
            
        }
    }
}

