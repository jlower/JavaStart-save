package com.learn.www.exercise.reflection;

import org.junit.Test;

/**
 * @author lowo
 * 2021/10/25->1:30
 */
public class FieldTest {
    @Test
    public void test1() {
        //Field[]要导入 // import java.lang.reflect.Field;
        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为 public 访问权限的属性 返回 Field[]
//        Field[] fields = clazz.getFields();
//        for (Field f : fields) {
//            System.out.println(f);
//        }
        //getDeclaredFields():获取当前运行时类中声明的所有属性(不包含父类中声明的属性) 返回 Field[]
//        Field[] declaredFields = clazz.getDeclaredFields();
//        for (Field f : declaredFields) {
//            System.out.println(f);
//        }

        //权限修饰符 数据类型 变量名
//        for (Field f : declaredFields) {
//            //1.权限修饰符
//            int modifier = f.getModifiers();
//            System.out.print(Modifier.toString(modifier));
//            //2.数据类型
//            Class type = f.getType();
//            System.out.print(type.getName());
//            //3.变量名
//            String fName = f.getName();
//            System.out.print(fName) ;
//            System.out.println();
//        }




    }
}
