package com.learn.www.exercise.normalclass.array;

/**
 * @author lowo
 * 2021/10/10->1:00
 */
public class ArrayTest3 {
    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,3,2,234,34,3245,3,5,3,5234};
        int[] array2 = new int[array1.length];
        //赋值array2变量等于array1
//        array2 = array1;//不能称作数组的复制   array1和array2地址值相同，都指向了堆空间的同一个数组实体
//        // 改array1或array2中的一个则两个都会变  (浅拷贝)

        for(int i = 0;i < array1.length;i++){
            array2[i] = array1[i];//深拷贝
        }
        //数组反转
        //法一:
        for (int i = 0; i < array1.length/2; i++) { //i只到一半 不然反转两次等于没反转
            int temp = array1[i];
            array1[i] = array1[array1.length-i-1];
            array1[array1.length-i-1] = temp;
        }
        //法二:
        for (int i = 0, j = array1.length - 1; i < j;i++,j--){
            int temp = array1[i];
            array1[i] = array1[j];
            array1[j] = temp;
        }

        for (int i : array1) {
            System.out.print(" " + i);
        }
    }
}
