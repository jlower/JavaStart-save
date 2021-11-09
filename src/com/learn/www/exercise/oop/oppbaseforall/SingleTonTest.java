package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/14->20:46
 */

//单例设计模式
//所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例

//网站的计数器:一般是单例模式实现，否则难以同步
//应用程序的日志应用:一般都使用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，
//因为只能有一个实例去操作，否则内容不好追加
//数据库连接池的设计:一般也是采用单例模式，因为数据库连接是一种数据库资源。

//项目中，读取配置文件的类，一般也只有一个对象。没有必要每次使用配置文件数据，都生成一个对象去读取。

//Application:也是单例的典型应用
//Windows的TaskManager（任务管理器）:就是很典型的单例模式
//Windows的RecycleBin（回收站）:也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。


//饿汉式vs懒汉式
//3.区分饿汉式和懒汉式
//饿汉式：
//  坏处：对象加载时间过长
//  好处：饿汉式是线程安全的
//懒汉式：
//  好处：延退对象的创建。
//  目前的写法坏处：线程不安全  -->  可以改成线程安全的

//单例模式的优点:  [java.lang.Runtime]
//  由于单例模式只生成一个实例，减少了系统性能开销，当一个对象的产生需要比较多的资源时，
//  如读取配置、产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后永久驻留内存的方式来解决


public class SingleTonTest {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1 == bank2);//true   因为是同一个对象
        Bank2 bank3 = Bank2.getInstance();
        Bank2 bank4 = Bank2.getInstance();
        System.out.println(bank3 == bank4);//true   因为是同一个对象
    }
}
//懒汉式[不用则不造]     目前的写法坏处：线程不安全  -->  可以改成线程安全的
//改成线程安全的
class Bank2{
    //1.私有化类的构造器
    private Bank2(){

    }
    //2.声明当前类对象[static]，没有初始化
    private static Bank2 instance = null;
    //3.提供公共的静态的方法[static][因为构造器外部不能访问所以不能new只能"类名."("Bank.")]，返回类的对象
    public  static Bank2 getInstance(){//synchronized Bank2.class synchronized (Bank2.class){
        if(instance == null){//这样效率高[有一个人进去了后面的就没必要在阻塞等判断了]
            synchronized (Bank2.class){
                //判断要包在内部才安全[不然有可能创造多个Bank2实例,多个线程被阻塞一个个进来执行需要判断]
                if(instance == null) {
                    instance = new Bank2();
                }
            }
        }
        return instance;
    }
}
//饿汉式[不用也造]
class Bank{

    //1.私有化类的构造器
    private Bank(){

    }
    //2.内部创建类静态的对象[static]
    private static Bank instance = new Bank();
    //3.提供公共的静态的方法[static][因为构造器外部不能访问所以不能new只能"类名."("Bank.")]，返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}