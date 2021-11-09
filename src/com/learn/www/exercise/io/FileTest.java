package com.learn.www.exercise.io;

import org.junit.Test;

import java.io.File;

/**
 * @author lowo
 * 2021/10/21->23:39
 */

//File类的使用
//1. File类的一个对象，代表一个文件或一个文件目录(俗称:文件夹)
//2. File类声明在java.io包下
//3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
//      并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
//4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点".

public class FileTest {

    //1.如何创建FiLe类的实例
    //File(string filePath)
    //File(String parentPath, String childPath)
    //File(File parentFile,string childPath)
    //2.
    //相对路径:相较于某个路径下，指明的路径。
    //绝对路径:包含盘符在内的文件或文件目录的路径
    //3.路径分隔符
    // windows : \
    // unix: /

    //public string getAbsolutePath():获取绝对路径
    //public string getPath():获取路径
    //public string getName():获取名称
    //public string getParent():获取上层文件目录路径。若无，返回null
    //public long length() :获取文件长度（即:字节数）。不能获取目录的长度。
    //public long lastModified():获取最后一次的修改时间，毫秒值
    //如下的两个方法适用于文件目录:
    //public string[] list():获取指定目录下的所有文件或者文件目录的名称数组
    //public File[] listFiles():获取指定目录下的所有文件或者文件目录的File数组

    //public boolean renameTo(FiLe dest):把文件重命名为指定的文件路径
    //比如: fiLe1.renameTo(file2)为例:
    //      要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。

    //public boolean isDirectory():判断是否是文件目录
    //public booLean isFile():判断是否是文件
    //public booLean exists():判断是否存在
    //public boolean canRead():判断是否可读
    //public boolean canWrite():判断是否可写
    //public boolean isHidden():判断是否隐藏

    //File类的创建功能
    //public boolean createNewFile():创建文件。若文件存在，则不创建，返回false
    //public boolean mkdir():创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，就不创建。
    //public boolean mkdirs():创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，将上层目录一并创建
    //注意事项:如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。

    //删除磁盘中的文件或文件目录
    //public boolean delete():删除文件或者文件夹
    //删除注意事项:
    //      Java中的删除不走回收站。
    //      要想删除成功，文件目录下不能有子目录或文件
    @Test
    public void test1(){
        File file1 = new File("\\src\\com\\learn\\www\\exercise\\io\\hello.txt");//相对于当前module
        File file2 = new File("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\hello.txt");
//        File file3 = new File("d:" + File.separator + "lowo"+ File.separator + "info.txt" );
//        File file4 = new File( "d:/atguigu" );
//        System.out.println("file1 = " + file1);
//        System.out.println("file3 = " + file3);
        String path1 = file2.getPath();
        System.out.println("path1 = " + path1);

    }
}
