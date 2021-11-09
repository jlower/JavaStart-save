package com.learn.www.exercise.normalclass.array;

import java.util.Arrays;

/**
 * @author lowo
 * 2021/10/10->2:38
 */
public class ArraysTest {
    public static void main(String[] args) {
        String[] strs1= new String[]{"12","23","qa00"};
        String[] strs2= new String[]{"12","qa00","23"};
//        strs1 = null;
//        strs2 = null;
        //判断两个数组是否相等
        boolean isEqual = Arrays.equals(strs1,strs2);
        System.out.println("isEqual = " + isEqual);
        //输出数组信息
        System.out.println(Arrays.toString(strs1));
        //将指定值填充到数组之中
        Arrays.fill(strs1,"12w");
        System.out.println(Arrays.toString(strs1));
        //对数组进行排序
        Arrays.sort(strs2);
        System.out.println(Arrays.toString(strs2));
        //二分查找
        int index1 = Arrays.binarySearch(strs2,"23");
        int index2 = Arrays.binarySearch(strs2,"asdfsa23");
        System.out.println("index1 = " + index1);//返回下标  从0开始
        System.out.println("index2 = " + index2);//为负则未找到


    }
}
