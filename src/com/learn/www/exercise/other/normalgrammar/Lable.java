package com.learn.www.exercise.other.normalgrammar;

/**
 * @author lowo
 * 2021/10/9->14:53
 */
public class Lable {
    public static void main(String[] args) {

        lable:for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==5){
                    break lable;//结束lable标签的循环 不执行之后的语句
                    //continue lable;//返回lable标签的循环 不执行之后的语句
                    //break;//结束最近一层的循环
                    //continue;
                }
                System.out.print(" " + j);
            }
            System.out.println();
        }
    }
}
