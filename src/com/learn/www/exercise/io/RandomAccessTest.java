package com.learn.www.exercise.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author lowo
 * 2021/10/23->21:11
 */

//RandomAccessFile的使用
//1.RandomAccessFile直接继承于java.Lang.Object类，实现了 DataInput 和 DataOutput 接口
//2.RandomAccessFiLe既可以作为一个输入流，又可以作为一个输出流
//3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建如果写出到的文件存在，
//  则会对原有文件内容进行覆盖。(默认情况下，从头覆盖)
//4.可以通过相关的操作，实现RandomAccessFiLe"插入"数据的效果

public class RandomAccessTest {

    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\hello.txt"),"r");
            raf2 = new RandomAccessFile(new File("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\hello1.txt"),"rw");
            byte[] buffer = new byte[1024];
            int len = raf1.read(buffer);
            while (len != -1) {
                raf2.write(buffer, 0, len);
                len = raf1.read(buffer);
            }
            raf2.seek(3);
            raf2.write("_TRY1_".getBytes());//覆盖

            //使用RandomAccessFile实现数据的插入效果
            raf2.seek(3);
            //保存指针3后面的所有数据到StringBuilder中 [参数传入int型]
            //思考:将StringBuilder替换为ByteArrayOutputStream
            StringBuffer str = new StringBuffer((int) new File("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\hello1.txt").length());
            int len2 = raf2.read(buffer);
            while (len2 != -1) {
                str.append(new String(buffer, 0, len2));
                len2 = raf2.read(buffer);
            }
            //调回指针，写入"_TRY2_"
            raf2.seek(3);
            raf2.write("_TRY2_".getBytes());
            raf2.write(str.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
