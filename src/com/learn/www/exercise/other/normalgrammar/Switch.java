package com.learn.www.exercise.other.normalgrammar;

/**
 * @author lowo
 * 2021/10/9->13:23
 */
public class Switch {
    public static void main(String[] args) {
        String str = "old";
        switch (str){
            case "new"://只能为常量
                System.out.println("wwwwwwwww");
                break;
            case "old":
                System.out.println("nnnnnnnnnnnn");
                break;
            default:
                System.out.println("?");
        }
    }
}
