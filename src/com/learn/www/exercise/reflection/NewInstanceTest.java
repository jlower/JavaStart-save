package com.learn.www.exercise.reflection;

import org.junit.Test;

import java.util.Random;

/**
 * @author lowo
 * 2021/10/25->0:55
 */

//通过反射创建对应的运行时类的对象

public class NewInstanceTest {

    //体会反射的动态性
    @Test
    public void test2() {
        int num = new Random().nextInt(3);//0,1,2
        String path = "";
        switch (num) {
            case 0:
                path = "java.util.Date";
                break;
            case 1:
                path = "java.lang.Object";
                break;
            case 2:
                path = "com.learn.www.exercise.reflection.Person";//copy Reference 在""中粘贴就会出现全类名
                break;
        }
    }

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        //newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参构造器
        //要想此方法正常的创建运行时类的对象，要求:
        //  1.运行时类必须提供空参的构造器 [ InstantiationException ]
        //  2.空参的构造器的访问权限得够。 通常设置为 public  [ IllegalAccessException ]
        //在javabean中要求提供一个public的空参构造器。原因:
        //  1.便于通过反射，创建运行时类的对象
        //  2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
        Person p1 = clazz.newInstance();
        System.out.println(p1);
        System.out.println(clazz);
    }
}
