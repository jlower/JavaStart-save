package com.learn.www.exercise.other.demo1;

/**
 * @author lowo
 * 2021/10/5->19:42
 */
public class Method1 {
    public static void main(String[] args) {
//        test(1,43,235,2,5235,23,5);
//        int res = f(10);
//        System.out.println("res = " + res);
        int[] numbers;//或 int numbers[];     用来声明数组但还没有定义   首选int[] numbers;
        numbers = new int[100];//  这样才定义完成
        int[] nums = new int[1000];//int默认赋值为0 一般直接这样写
        int[] test = {1,2,2,4,5,35,35};//静态初始化
        //int arr[] = new int[100];//可以这样写但最好不要
//        String[] strs = new String[10];//String默认赋值为null
//        System.out.println("strs[2] = " + strs[2]);
//        for(int item:test){ //for - each循环   iter/xxx.for
//            System.out.println("item = " + item);
//        }
        //多维数组
        int[][] array = new int[100][100];
        int[][] array2 = {{1,2},{3,4},{3,4}};
        System.out.println("array2 = " + array2);
//        for (int[] ints : array) { //for - each循环   iter/xxx.for
//
//        }
//        for (int i = 0; i < array2.length; i++) {
//            int[] ints = array2[i]; // 是 *** int[] ***  类型
//
//        }
//        for (int i = 0; i < array2.length; i++) {
//            for (int j = 0; j < array2[i].length; j++) {
//
//
//            }
//
//        }



        //数组长度   xxx.length
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = i;
//            int i1 = nums[i];
//            System.out.println("i1 = " + i1);
//        }
    }


    public static int f(int n) {
        if(n==1){
            return 1;
        }
        return n*f(n-1);
    }
    //可变参数 一个方法只能有一个且其必须在最后一个
    //不定数量传入   类型名(eg.int double。。。)后加... 再加名字
    public static void test(double... numbers) {//numbers为数组
        if (numbers.length == 0) {
            System.out.println("No number");
            return ;
        }
        for (int i = 0; i < numbers.length; i++) {
            double number = numbers[i];
            System.out.println("number = " + number);
        }
        return ;
    }
}
