package com.learn.www.exercise.reflection;

/**
 * @author lowo
 * 2021/10/24->14:52
 */
public class Person {
    public int id;
    private String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
        System.out.println("Person()!!");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("人 person!");
    }

    private String showNation(String nation) {
        System.out.println("nation = " + nation);
        return nation;
    }
}
