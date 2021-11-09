package com.learn.www.exercise.io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lowo
 * 2021/10/22->13:26
 */

//一、流的分类:
//1.操作数据单位:字节流、字符流
//2.数据的流向:输入流、输出流
//3.流的角色:节点流、处理流

//二、流的体系结构
//  抽象基类         节点流(或文件流)                                  缓冲流(处理流的一种)
//  InputStream     FileInputStream {read (byte[] buffer)}          BufferedInputStream {read (byte[] buffer)}
//  OutputStream    FileOutputStream {write(byte[] buffer,0,len)}   BufferedOutputStream {write(byte[] buffer,0,len)}
//  Reader          FileReader {read (char[] cbuf)}                 BufferedReader {read (char[] cbuf) / String data = bw.readLine();}
//  Writer          FileWriter {write(char[] cbuf,0,len)}           BufferedWriter {write(char[] cbuf,0,len)}
//不能使用字符流[ FileReader  FileWriter ]来处理图片等字节数据


public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前工程
    }

    //说明点:
    //1.read()的理解:返回读入的一个字符。如果达到文件末尾，返回 -1
    //2.异常的处理:为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    //3.读入的文件一定要存在，否则就会报FileNotFoundException
    @Test
    public void test1() {


        //ctrl+alt+t : 快捷包裹模板


        FileReader fr = null;//有异常要try-catch-finally
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\hello.txt");//相较于当前module
            // 2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回 -1 [返回int值,要转char才能看到字符]
            int data = fr.read();//有异常要try-catch-finally
            //方式一:
//        while (data != -1) {
//            System.out.print((char)data);
//            data = fr.read();
//        }
            //方式二:语法上针对于方式一的修改
            while ((data = fr.read()) != -1) {//有异常要try-catch-finally
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if (fr != null) {//创建了才关
                    fr.close();//有异常要try-catch-finally
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //对read()操作升级:使用read的重载方法
    @Test
    public void test2() {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\hello.txt");//相较于当前module
            //2.FiLeReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            //[每次覆盖同一个数组的元素，读一个替换一个，如果最后没读满，则上一次读入的元素还在此数组后面]
            char[] cbuf = new char[5];
            int len = fr.read(cbuf);
            while (len != -1) {
                //错误的写法[每次覆盖同一个数组的元素，读一个替换一个，如果最后没读满，则上一次读入的元素还在此数组后面]
//                for (int i = 0; i < cbuf.length; i++) {
//                    char c = cbuf[i];
//                    System.out.print(c);
//                }
                //正确的写法1
//                for (int i = 0; i < len; i++) {
//                    char c = cbuf[i];
//                    System.out.print(c);
//                }
                //正确的写法2
                String str = new String(cbuf, 0, len);
                System.out.println(str);
                len = fr.read(cbuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.资源的关闭
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //从内存中写出数据到硬盘的文件里。
    //说明:
    //1.输出操作，对应的File可以不存在的。并不会报异常
    //2.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
    //  File对应的硬盘中的文件如果存在:
    //      如果流使用的构造器是:FileWriter(file,false)  /  FileWriter(file):对原有文件的覆盖
    //      如果流使用的构造器是:FiLeWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
    //不能使用字符流来处理图片等字节数据
    @Test
    public void test3() {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\hello1.txt");
            //2.提供FiLeWriter的对象，用于数据的写出
            fw = new FileWriter(file);
            //3.写出的操作
            fw. write("I have a dream ! \n");//  \n 换行
            fw.write("you need to have a dream! ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.流资源的关闭
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}
