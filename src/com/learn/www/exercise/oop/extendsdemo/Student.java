package com.learn.www.exercise.oop.extendsdemo;

/**
 * @author lowo
 * 2021/10/5->23:36
 */
//private私有
public class Student {
    //属性:字段
    //private私有后外部无法操作
    private String name;//null
    private int age;//0
    private int id;
    private char sex;

    //提供public的get & set方法
    //alt + insert -> Getter and Setter 自动生成get & set方法
    public String getName(){
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=0 && age<=150){
            this.age = age;
        }
        else{
            this.age = 3;
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setName(String name){
        this.name = name;
    }
}
