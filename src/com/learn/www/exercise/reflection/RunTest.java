package com.learn.www.exercise.reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lowo
 * 2021/10/25->22:15
 */

public class RunTest {

    //调用运行时类中指定的结构:属性、方法、构造器
    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        //获取指定的属性:要求运行时类中属性声明为public
        //通常不采用此方法
        //Field id = clazz.getField("id");

        //如何操作运行时类中的指定的属性--需要掌握
        //通常采用此方法
        //1. getDeclaredField(string fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        //2.保证当前属性是可访问的
        name.setAccessible(true);
        //3.获取、设置指定对象的此属性值
        name.set(p, "Tom");
        String pName = (String) name.get(p);
        System.out.println("pName = " + pName);

        //设置当前属性的值
        //set():  参数1:指明设置哪个对象的属性参数   参数2:将此属性值设置为多少
        //id.set(p, 10);
        //获取当前属性的值
        //get():  参数1:获取哪个对象的当前属性值
        //int pId = (int) id.get(p);
        //System.out.println(pId);

        //如何操作运行时类中的指定的方法--需要掌握
        //1.获取指定的某个方法
        //getDeclaredMethod():  参数1:指明获取的方法的名称   参数2:指明获取的方法的形参列表
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        //2.保证当前方法是可访问的
        showNation.setAccessible(true);
        //3.调用方法的invoke():  参数1:方法的调用者   参数2:给方法形参赋值的实参
        //  invoke()的返回值即为对应类中调用的方法的返回值。
        Object returnValue = showNation.invoke(p, "CHN");//String nation = p.show("CHN");
        System.out.println("returnValue = " + returnValue);
        //如何调用静态方法
        //private static void showDesc()
        //Method showDesc = clazz.getDeclaredMethod("showDesc");
        //showDesc.setAccessible(true) ;
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null
        //以下两种写法都行[ null / 当前类.class ][由Method showDesc调用的invoke,所以填null也知道是哪个类的静态方法]
//        Object returnVal = showDesc.invoke(null);
        //Object returnVal = showDesc.invoke(Person.class);
        //System.out.println(returnVal) ;//null

        //如何调用运行时类中的指定的构造器
        //1.获取指定的构造器
        //getDeclaredConstructor():  参数:指明构造器的参数列表
        //Constructor constructor = clazz.getDeclaredConstructor(String.class);
        //2.保证此构造器是可访问的
        //constructor.setAccessible(true);
        //3.调用此构造器创建运行时类的对象
        //Person per = (Person) constructor.newInstance("Tom");



    }

}
