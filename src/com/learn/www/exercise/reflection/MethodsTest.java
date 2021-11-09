package com.learn.www.exercise.reflection;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author lowo
 * 2021/10/25->1:39
 */
public class MethodsTest {

    @Test
    public void test1() {
        //获取运行时类的方法结构
        Class clazz = Person.class;
        //getMethods():获取当前运行时类及其所有父类中声明为 public 权限的方法 返回 Method[]
        //Method[]需要导入//import java.lang.reflect.Method;
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。(不包含父类中声明的方法)

        //获取方法的   权限修饰符 返回值类型 方法名(参数类型1 形参名1,...) throws XxxException{}
        //1.获取方法声明的注解  Annotation[] annos = m.getAnnotations();
        //2.权限修饰符  m.getModifiers()
        //3.返回值类型  m.getReturnType()
        //4.方法名  m.getName()
        //5.形参列表  Class[] parameterTypes = m.getParameterTypes();
        //6.抛出的异常  Class[] exceptionTypes = m.getExceptionTypes();

        //获取构造器结构
        //getConstructors():获取当前运行时类中声明为 public 的构造器
        //  Constructor[] constructors = clazz.getConstructors();
        //getDeclaredConstructors():获取当前运行时类中声明的 所有 构造器
        //  Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        //获取运行时类的父类
        //Class superclass = clazz.getSuperclass();
        //获取运行时类的带泛型的父类的泛型
        //Type genericSuperclass = clazz.getGenericSuperclass();
        //获取泛型类型
        //ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //Type[] actualTypeArguments = paramType.getActualTypeArguments();

        //获取运行时类实现的接口
        //class[] interfaces = clazz.getInterfaces();
        //获获取运行时类的父类实现的接口
        //class[] interfaces1 = clazz.getSuperclass().getInterfaces();

        //获取运行时类所在的包
        //Package pack = clazz.getPackage();

        //获取运行时类声明的注解
        //Annotation[] annotations = clazz.getAnnotations();

    }
}
