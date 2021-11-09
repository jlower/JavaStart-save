package com.learn.www.exercise.io;

import org.junit.Test;

import java.io.*;

/**
 * @author lowo
 * 2021/10/23->2:09
 */

//处理流之一:缓冲流的使用
//1.缓冲流:
//BufferedInputStream {read (byte[] buffer)}
//BufferedOutputStream {write(byte[] buffer,0,len)}
//BufferedReader {read (char[] cbuf) / String data = bw.readLine();}
//BufferedWriter {write(char[] cbuf,0,len)}
//2.作用: 提高流的读取、写入的速度
//       提高读写速度的原因:内部提供了一个缓冲区
//3.处理流，就是"套接"在已有的流的基础上。

public class BufferedTest {
    //使用BufferedReader和BufferedWriter实现文本文件的复制
    //读写操作
    //方式一:使用char[]数组 则 数组 中包含换行符
    //方式二:使用String 则 字符串 中不包含换行符
    //  String data = bw.readLine();中不包含换行符
    //      1.bw.write(data + "\n");
    //      2.bw.newLine();//提供换行的操作
    //提高读写速度的原因:内部提供了一个缓冲区。默认情况下是8kb[ DEFAULT_BUFFER_SIZE(8192) ]


    @Test
    public void test1() {

    }

    //使用BufferedInputStream和BufferedOutputStream实现非文本文件的复制
    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1 造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节:读取、写入
            //  要使用缓冲流读取、写入 才能提高速度
            byte[] buffer = new byte[1024];
            int len = bis.read(buffer);
            while (len != -1) {
                bos.write(buffer, 0, len);
                len = bis.read(buffer);
                //bos.flush();//刷新缓冲区(将缓存区中现有的所有数据输出)[当缓存区满DEFAULT_BUFFER_SIZE(8192)时会自动调用此方法]
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求:先关闭外层的流，再关闭内层的流
            //说明:关闭外层流的同时，内层流也会自动的进行关闭。关于内层流[fis,fos]的关闭，我们可以省略
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
