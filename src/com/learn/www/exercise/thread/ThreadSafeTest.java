package com.learn.www.exercise.thread;

/**
 * @author lowo
 * 2021/10/16->20:20
 */

//1.问题:卖票过程中，出现了重票、错票-->出现了线程的安全问题
//2.问题出现的原因:当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票。
//3.如何解决:当一个线程a在操作ticket的时候，其他线程不能参与进来。直到线程a操作完ticket时,
//         其他线程才可以开始操作ticket。这种情况即使线程a出现了阻塞，也不能被改变。
//4.在Java中，我们通过同步机制，来解决线程的安全问题。[有共享数据才有线程安全问题]
//  方式一:同步代码块
//      synchronized(同步监视器){//同步监视器，俗称:锁。任何一个类的对象，都可以充当锁。
//          //需要被同步的代码
//      }
//  说明:操作共享数据的代码，即为需要被同步的代码
//      -->不能包含代码多了(效率低，包含了循环的话可能一个线程一直执行没有多线程实现)
//      ，也不能包含代码少了[判断要包在内部才安全]
//      共享数据:多个线程共同操作的变量。比如: ticket就是共享数据。
//  同步监视器，俗称:锁。任何一个类的对象，都可以充当锁。
//      [要求:多个线程必须要共用同一把锁][小心注意造了几个锁]
//      补充:在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
//      说明:在继承Thread类创建多线程的方式中，慎用this充当同步监视器。考虑使用当前类充当同步监视器。
//      (如果只创造一个对象[Xxx implements Runnable时只用new一个Xxx之后new的都是Thread]
//      同步监视器可以用this)(否则用Xxx.class[类可以是对象 且唯一])

//  方式二:同步方法(方法的修饰词加上synchronized即可)
//  使用同步方法解决实现Runnable接口的线程安全问题
//  关于同步方法的总结:
//  1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
//  2.非静态的同步方法，同步监视器是:this[有可能有安全问题]
//    静态的同步方法，同步监视器是:当前类本身Xxx.class[没有安全问题]

//5.同步的方式，解决了线程的安全问题。---好处
//  操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。---坏处



class SaleTick implements Runnable{
    private int ticket = 10000;
    private int all = 0;

    public int getAll() {
        return all;
    }

    private static Object obj = new Object();
    @Override
    public void run() {
        while(true){
            if(ticket <= 0) return;//这样效率高[有一个人进去完成最后一个了,后面的就没必要在阻塞等判断了]
            synchronized (SaleTick.class) {//synchronized(obj){   //this
                //判断要包在内部才安全
                if (ticket > 0) {//判断要包在内部才安全

                        System.out.println(Thread.currentThread().getName() + "ticket = " + ticket);
                        ticket--;
                        all++;
                } else {
                    return;
                }
            }
        }
    }
}
public class ThreadSafeTest {
    public static void main(String[] args) {
        SaleTick saleTick = new SaleTick();
        Thread t1 = new Thread(saleTick);
        t1.start();
        Thread t2 = new Thread(saleTick);
        t2.start();
        Thread t3 = new Thread(saleTick);
        t3.start();
        while(true){
            if(!t1.isAlive()&&!t2.isAlive()&&!t3.isAlive()){
                System.out.println("saleTick.getAll() = " + saleTick.getAll());
                break;
            }
        }


    }
}
