package com.learn.www.exercise.normalclass.array;

/**
 * @author lowo
 * 2021/10/9->15:44
 */
public class ArrayTest {

    public static void main(String[] args) {
        //数组中的常见异常:
        //1.数组角标越界的异常:ArrayIndexOutOfBoundsExcetion
        //2.空指针异常:NullPointerException

        //空指针异常:NullPointerException
//        String[] arr3 = new String[]{"AA","BB","CC"};
//        arr3[0]= null;
//        System.out.println(arr3[0].toString());


        //初始化默认值
        //整形 0
        //浮点型 0.0
        //char型 0或'\u0000'  而非'0'
        //boolean型 false
        //引用数据类型为 null  而非"null"
        int[] ids;
        ids = new int[]{1,2,3,4};//静态初始化
        int[] ids2 = {1,2,3,4};//new int[]{1,2,3,4};
        String[] strs = new String[10];//动态初始化
        
        System.out.println(ids.length);//数组长度
        System.out.println(strs.length);

//        for (int i = 0; i < strs.length; i++) {
//            String str = strs[i];
//            System.out.print(str + " ");
//        }
        char[] chars = new char[10];
        for (int i = 0; i < chars.length; i++) {
            char k = chars[i];
            System.out.print(k + " ");
        }

    }
}
