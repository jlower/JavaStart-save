package com.learn.www.exercise.normalclass.array;

/**
 * @author lowo
 * 2021/10/9->16:14
 */
public class ArrayTest2 {
    public static void main(String[] args) {
//        //获取
//        Scanner scanner = new Scanner(System.in);
//        int number;
//        number = scanner.nextInt();
//        int[] scores = new int[number];//可以后获取数组大小
//        for (int i = 0; i < scores.length; i++) {
//            scores[i] = scanner.nextInt();
//        }

//        二维数组元素的默认初始化值

//        针对于初始化方式一：比如：int[][] arr3 =new int[4][3];
//        外层元素的初始化值为：地址值
//        内层元素的初始化值为：与一维数组初始化情况相同
//
//        针对于初始化方式二：比如：int[][] arr4 =new int[4][];
//        外层元素的初始化值为：null
//        内层元素的初始化值为：不能调用，否则报错

        //对于二维数组的理解，我们可以看成是一维数组array1又作为另一个一维数组array2的元素而存在。
        //其实，从数组底层的运行机制来看，其实没有多维数组。
        //二维数组只不过是一维数组 只是其的元素是一维数组
        //int[][] y;
        //int[] y[];
        //int y[][];
        //以上三种都能声明
        int[][] ids = new int[][]{{1, 2}, {3, 4}};//静态初始化
        String[][] arr = new String[3][2];//动态初始化
        String[] s = {"sdafsadf","asfasdf"};
        String[][] arr2 = new String[3][];//也可以但最好别用 并非动态数组 arr2[0]其初始值为null未放入数组
        // arr2[0]其初始值为null不能直接arr2[0][0] = "1";
        //否则报错  NullPointerException
        arr2[0] = new String[4];//arr2[0]需要先赋值数组(eg.arr2[0]=s)再操作arr2[0][0] = "1";
        arr2[0][0]="adf23";
        System.out.println("ids.length = " + ids.length);// 返回ids第一层的长度 2

        int[][] arr3 =new int[4][3];
        System.out.println(arr3);//[[I@2f7a2457    二维地址值
        System.out.println(arr3[0]);//[I@2f7a2457  一维地址值
        System.out.println(arr3[0][0]);//0

        int[][] arr4 =new int[4][];
        System.out.println(arr4[0]);//null

//        for (int i = 0; i < arr2.length; i++) {
//            String[] strings = arr2[i];//其初始值为null不能直接strings[0] = "1";
//            strings = s;//需要先赋值数组再操作
//            System.out.println("strings.length = " + strings.length);
//            for (int j = 0; j < strings.length; j++) {
//                String string = strings[j];
//            }
//        }
    }
}
