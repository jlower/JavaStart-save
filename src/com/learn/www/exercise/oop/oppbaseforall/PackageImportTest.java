package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/11->22:31
 */

//一、package关键字的使用
//1.为了更好的实现项目中类的管理，提供包的概念
//2.使用package声明类或接口所属的包，声明在源文件的首行
//3.包，属于标识符，遵循标识符的命名规则、规范（xxxyyyzzz）、"见名知意"
//4.每“.“一次，就代表一层文件目录。
//补充：同一个包下，不能命名同名的接口、类;  不同的包下，可以命名同名的接口、类。 [类似一个文件夹内不能建立同名文件]

//1.java.lang----包含一些Java语言的核心类，如String、Math、Integer、System和Thread，提供常用功能
//2.java.net----包含执行与网络相关的操作的类和接口。
//3.java.io----包含能提供多种输入/输出功能的类。
//4.java.util----包含一些实用工具类，如定义系统特性、接口的集合框架类、使用与日期日历相关的函数。
//5.java.text----包含了一些java格式化相关的类
//6.java.sql----包含了java进行JDBC数据库编程的相关类/接口
//7.java.awt----包含了构成抽象窗口工具集（abstractwindowtoolkits）的多个类
// ，这些类被用来构建和管理应用程序的图形用户界面（GUI）。B/S C/S


//MVC设计模式
//MVC是常用的设计模式之一，将整个程序分为三个层次：数据模型层，视图模型层与控制器层。
//这种将程序输入输出、数据处理，以及数据的展示分离开来的设计模式使程序结构变的灵活而且清晰，
//同时也描述了程序各个对象间的通信方式，降低了程序的耦合性。


//              模型层model主要处理数据
//>数据对象封装model.bean/domain
//>数据库操作类model.dao
//>数据库model.db
//              视图层view显示数据
//>相关工具类    view.utils
//>自定义view   view.ui
//              控制层controller处理业务逻辑
//>应用界面相关   controller.activity
//>存放fragment  controller.fragment
//>显示列表的适配器controller.adapter
//>服务相关的controller.service
//>抽取的基类controller.base

//二、import关键字的使用
//import:导入
//1.在源文件中显式的使用import结构导入指定包下的类、接口
//2.声明在包的声明和类的声明之间
//3.如果需要导入多个结构，则并列写出即可
//4.可以使用“import xx.xxx.*;“的方式，表示可以导入xx.xxx包下的所有结构  eg.import java.util.*;
//5.如果使用的类或接口是java.1ang包下定义的，则可以省略import结构
//6.如果使用的类或接口是本包下定义的，则可以省略import结构
//7.如果在源文件中，使用了不同包下的同名的类，则必须至少有一个类需要以全类名的方式显示
//  全类名的方式显示  com.atguigu.exer3.Account a = new com.atguigu.exer3.Account()
//8.使用“xxx.*"的方式表明可以调用xxx包下的所有结构。
//  但是如果使用的是xxx子包下的结构，则仍需要显示调用import  [eg. import xxx.xx.x]
//9.import static：导入指定类或接口中的静态结构
//  eg.若import static java.lang.System.*;则之后System.out.println();可以写为out.println();省掉System.

public class PackageImportTest {
    public static void main(String[] args) {
        System.out.println();
    }
}
