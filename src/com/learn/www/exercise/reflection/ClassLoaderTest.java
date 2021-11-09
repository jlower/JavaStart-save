package com.learn.www.exercise.reflection;

import org.junit.Test;

/**
 * @author lowo
 * 2021/10/24->18:20
 */


public class ClassLoaderTest {
    //Properties:用来读取配置文件。
    @Test
    public void test2() {
//        Properties pros = new Properties();

        //读取配置文件的方式一: 此时的文件默认在当前的module下。
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);
        //读取配置文件的方式二:使用ClassLoader  文件默认识别为:当前module的src下
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
//        pros.load(is);
//        String user = pros.getProperty ( "user" );
//        String password = pros.getProperty( "password" );
//        System.out.println("user = " + user + ",password = " + password);


    }

    //了解类的加载器
    @Test
    public void test1() {
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        System.out.println("classLoader1 = " + classLoader1);
        //调用系统类加载的getParent():  获取扩展类加载器
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println("classLoader2 = " + classLoader2);
        //调用扩展类加载器的getParent():  无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println("classLoader3 = " + classLoader3);
    }
}
