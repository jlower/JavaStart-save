package com.learn.www.exercise.other.demo1;

import java.util.Arrays;

/**
 * @author lowo
 * 2021/10/5->20:45
 */
public class ArraysDemo1 {

    public static void main(String[] args) {
        int[] nums = {12,234,212,412,53,3234,35,1,23,2,41,532112,35,35};
        System.out.println(nums);//出内存地址
        System.out.println(Arrays.toString(nums));
//        Arrays.sort(nums);
        mySort(nums);
        System.out.println(Arrays.toString(nums));

//        int num = 10;
//        num++;
//        int[] arr =  new int[num+10];//定义数组空间大小时可以含有变量
//        arr[10] = 3;
//        System.out.println("arr[10] = " + arr[10]);

        //稀疏数组
    }

    public static int[] mySort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {//冒泡 o(n^2)
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

        }
        return nums;
    }
}
