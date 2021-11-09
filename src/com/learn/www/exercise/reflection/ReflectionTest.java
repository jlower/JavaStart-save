package com.learn.www.exercise.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lowo
 * 2021/10/24->14:51
 */

///疑问1:通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个?
//      建议:直接new的方式。
//      什么时候会使用:反射的方式。反射的特征:动态性
//疑问2:反射机制与面向对象中的封装性是不是矛盾的?如何看待两个技术?
//     不矛盾。
//关于java.Lang.cLass类的理解
//1.类的加载过程:
//程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)
//接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。
//此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例。
//2.换句话说，CLass的实例就对应着一个运行时类。
//3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
//  [得到的是同一个此运行时类][此运行时类唯一存在]

//哪些类型可以有Class对象?
//(1) class:外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
//(2) interface:接口
//(3) []:数组     //只要数组的元素类型与维度一样，就是同一个Class
//(4) enum:枚举
//(5) annotation:注解@interface
//(6) primitive type:基本数据类型
//(7) void

//万事万物皆对象﹖对象.xxx, FiLe, URL,反射,前端、数据库操作

public class ReflectionTest {


    //获取CLass的实例的方式 [ 前三种方式需要掌握 ]
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一:调用运行时类的属性:  .class
        Class<Person> clazz1 = Person.class;
        System.out.println("clazz1 = " + clazz1);
        //方式二:通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println("clazz2 = " + clazz2);
        //方式三:调用Class的静态方法:forName(String classPath) // classPath为类的全类名 [写全]
        Class clazz3 = Class.forName("com.learn.www.exercise.reflection.Person");//会报异常 要处理
//        clazz3 = Class.forName("java.lang.String");
        System.out.println("clazz3 = " + clazz3);
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        //方式四:使用类的加载器:ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.learn.www.exercise.reflection.Person");
        System.out.println("clazz4 = " + clazz4);
        System.out.println(clazz1 == clazz4);



    }

        //反射之后，对于Person的操作
    @Test
    public void test2() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        Class clazz = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        System.out.println("obj.toString() = " + obj.toString());
        Person p = (Person) obj;
        System.out.println("p.toString() = " + p.toString());
        //2.通过反射，调用对象指定的属性、方法
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println("p.toString() = " + p.toString());
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        //通过反射，可以调用Person类的私有结构的。比如:私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("lowo");
        System.out.println("p1 = " + p1);
        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "HanMeiMei");
        System.out.println(p1);
        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");//相当于String nation= p1.showNation("中国");
        System.out.println("nation = " + nation);
    }

    //反射之前，对于Person的操作
    @Test
    public void test1(){
        //1.创建Person类的对象
        Person p1 = new Person("Tom", 12);
        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString( ));
        p1.show();
        //在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        //  比如:  name  showNation()以及私有的构造器
    }
}
