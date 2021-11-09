package com.learn.www.exercise.io;

import org.junit.Test;

import java.io.*;

/**
 * @author lowo
 * 2021/10/23->18:36
 */

//对象流的使用
//1.ObjectInputStream 和 ObjectOutputStream
//2.作用:用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
//3.要想一个java对象是可序列化的，需要满足相应的要求。
//      1.需要实现接口: Serializable
//      2.当前类提供一个全局常量(唯一标识,随意指定): static final long serialVersionUID =
//      3.除了当前Person类需要实现Serializable接口之外，
//        还必须保证其内部所有属性也必须是可序列化的。(默认情况下，基本数据类型可序列化)
//ObjectOutputStream 和 ObjectInputStream 不能序列化 static 和 transient 修饰的成员变量
//4.序列化机制:
//  对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，
//  或通过网络将这种二进制流传输到另一个网络节点。当其它程序获取了这种二进制流，就可以恢复成原来的Java对象

public class ObjectInputOutputStreamTest {

    @Test
    public void test1() {
        //序列化过程:将内存中的java对象保存到磁盘中或通过网络传输出去
        //使用ObjectOutputStream实现
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\data.try"));
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();//刷新操作
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //反序列化:将磁盘文件中的对象还原为内存中的一个java对象
        //使用objectInputStream来实现
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\data.try"));
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println("str = " + str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
