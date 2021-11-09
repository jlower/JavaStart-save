package com.learn.www.exercise.collection;

import java.util.Objects;

/**
 * @author lowo
 * 2021/10/19->14:16
 */
public class Person implements Comparable{
    private int age;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person obj = (Person)o;
            return this.name.compareTo(obj.name);//o小于this则返回正数，返回正数则o放在this前
        }
        throw new RuntimeException("Type Error!");
    }
}
