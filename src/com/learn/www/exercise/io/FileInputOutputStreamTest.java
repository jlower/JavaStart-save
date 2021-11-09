package com.learn.www.exercise.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lowo
 * 2021/10/23->1:41
 */

//测试FileInputStream和FileOutputStream的使用
//ctrl + r: 当前文件内容替换，指的是在当前打开的文件中替换匹配的字符，只操作一个文件。 
//ctrl + shift + r: 在路径中替换，指的是在选定的目录下或者类包下，查找要被替换的字符，
//                  再在第二个输入框中输入要替换的字符，点击弹出框的右下角的 replace 或者 replace all 即可。
//结论:
//1.对于文本文件( .txt , .java , .c , .cpp ,......)，使用字符流处理
//2．对于非文本文件( .jpg , .mp3 , .mp4 , .avi , .doc , .ppt ,......)，使用字节流处理
//使用字节流FileInputStream处理文本文件，可能出现乱码。
public class FileInputOutputStreamTest {

    //实现对图片的复制操作    //src : source
    public void copyFile(String srcPath, String destPath) {
        //使用字节流FileInputStream处理文本文件，可能出现乱码。
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1.File类的实例化
            File file1 = new File(srcPath);
            File file2 = new File(destPath);
            //2.流的实例化
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            //3.读入的操作
            byte[] buffer = new byte[1024];
            int len = fis.read(buffer);
            while (len != -1) {
                fos.write(buffer, 0, len);
                len = fis.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.资源的关闭
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                //4.资源的关闭
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test2() {
        copyFile("D:\\LOWO\\JavaLearn\\JavaStart" +
                "\\src\\com\\learn\\www\\exercise\\io\\try_1.png","D:\\LOWO\\JavaLearn\\JavaStart" +
                "\\src\\com\\learn\\www\\exercise\\io\\try_2.png");
    }
    //使用字节流FileInputStream处理文本文件，可能出现乱码。
    @Test
    public void test1() {
        //使用字节流FileInputStream处理文本文件，可能出现乱码。
        FileInputStream fis = null;
        try {
            //1.File类的实例化
            File file = new File("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\hello.txt");//相较于当前module
            //2.流的实例化
            fis = new FileInputStream(file);
            //3.读入的操作
            byte[] buffer = new byte[5];
            int len = fis.read(buffer);
            while (len != -1) {
                String str = new String(buffer, 0, len);
                System.out.println(str);
                len = fis.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.资源的关闭
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
