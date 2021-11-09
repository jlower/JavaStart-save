package com.learn.www.exercise.oop.classbasedemo.demo1;

/**
 * @author lowo
 * 2021/10/5->21:42
 */
//一个类只有一个 public class      但可以有多个 class
public class Demo2 {
    public static void main(String[] args) {
        PersonOne person = new PersonOne();
        System.out.println("person.name = " + person.name);
        changeName(person);//或demo2.changeName(person);  使用static方法
        System.out.println("person.name = " + person.name);

        int a = 1;
        System.out.println("a = " + a);
        changeInt(a);
        System.out.println("a = " + a);
    }
    
    public static void changeInt(int a) {
        a = 10;//修改的是此方法中的局部变量a
        return;
    }
    public static void changeName(PersonOne person) {
        person.name = "lowo";//修改的是PersonOne类中的name值    person指向传入的PersonOne类
        return;
    }
}

class PersonOne{
    //属性
    String name;//null

}