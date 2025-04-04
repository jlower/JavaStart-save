package com.learn.www.exercise.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lowo
 * 2021/10/23->15:55
 */

//处理流之二:转换流的使用
//1.转换流:属于字符流
//  InputStreamReader:将一个 字节 的输入流转换为 字符 的输入流   读到程序中显示要解码
//  OutputStreamWriter:将一个 字符 的输出流转换为 字节 的输出流  写到文件中要编码变为字节储存
//2.作用:提供字节流与字符流之间的转换
//3.    解码: 字节、字节数组 -> 字符数组、字符串  InputStreamReader
//      编码: 字符数组、字符串 -> 字节、字节数组  OutputStreamWriter
//4.字符集
//ASCII:美国标准信息交换码。
//      用一个字节的7位可以表示。
//ISO8859-1:拉丁码表。欧洲码表
//          用一个字节的8位表示。
//GB2312:中国的中文编码表。最多两个字节编码所有字符
//GBK:中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
//Unicode:国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
//UTF-8:变长的编码方式，可用1-4个字节来表示一个字符。

public class InputStreamReaderTest {

    //此时处理异常的话，仍然应该使用try-catch-finally
    //InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\hello.txt");
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        // 参数2指明了字符集，具体使用哪个字符集，取决于文件hello.txt保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        char[] cbuf = new char[20];
        int len = isr.read(cbuf);
        while (len != -1) {
            String str = new String(cbuf, 0, len);
            System.out.println("str = " + str);
            len = isr.read(cbuf);
        }
        isr.close();



    }
}
