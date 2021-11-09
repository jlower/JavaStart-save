package com.learn.www.exercise.io;

/**
 * @author lowo
 * 2021/10/23->16:32
 */

//其他流的使用
//1.标准的输入、输出流
//2.打印流
//3.数据流

public class OtherStreamTest {
    //1.标准的输入、输出流
    //1.1
    //System.in:标准的输入流，默认从键盘输入
    //System.out:标准的输出流，默认从控制台输出
    //1.2
    //system类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的流。
    //InputStreamReader isr = new InputStreamReader(System.in); //可以传入System.in代表读取输入的东西
    //2．打印流:PrintStream 和 PrintWriter [ 实现将基本数据类型的数据格式转化为字符串输出 ]
    //2.1提供了一系列重载的print()和 println()
    //ps = new PrintStream(fos, true);//创建打印输出流，设置为自动刷新模式(写入换行符或字节'\n’时都会刷新输出缓冲区)
    //  if (ps != nu11) {
    //      System.setOut(ps);//把标准输出流(控制台输出)改成输出到文件中
    //  }
    //3．数据流
    //3.1 DataInputStream和DataOutputStream
    //3.2作用:用于读取或写出基本数据类型的变量或字符串练习:将内存中的字符串、基本数据类型的变量写出到文件中。
    //注意:处理异常的话，仍然应该使用try-catch-finally.
    //将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中。
    //注意点:读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致!
}
