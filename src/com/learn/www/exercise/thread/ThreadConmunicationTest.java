package com.learn.www.exercise.thread;

/**
 * @author lowo
 * 2021/10/17->0:54
 */

//线程通信的例子:使用两个线程打印 1~100 ***(线程1,线程2 交替打印)***
//涉及到的三个方法:
//wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
//notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个
//notifyALL():一旦执行此方法,就会唤醒所有被wait的线程。
//说明:[wait()，notify()，notifyAll()三个方法一般省略 this. 可以自己更改前缀为其他eg.  Xxx.class. ]
//1.wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中。
//2.wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器(要相同)
//  否则，会出现IllegalMonitorStateException异常
//3.wait()，notify()，notifyAll()三个方法是定义在java.lang.object类中。

//面试题: sleep()和wait()的异同?
//1.相同点:一旦执行方法，都可以使得当前的线程进入阻塞状态。
//2.不同点:1）两个方法声明的位置不同: Thread类中声明sleep() , object类中声明wait()
//        2）调用的范围不同:sLeep()可以在任何需要的场景下调用。wait()必须使用在同步代码块或同步方法中
//        3）关于是否释放同步监视器:如果两个方法都使用在同步代码块或同步方法中，
//           sleep()不会释放锁，wait()会释放锁。

class Number implements Runnable{
    private int num = 0;
    @Override
    public void run() {
        while(true){
            synchronized (Number.class){//this
                Number.class.notifyAll();//唤醒所有线程//省略this.
                //notify();//唤醒一个线程[按优先级幻想](否则随机唤醒)//省略this.

                if(num<=100){
                    System.out.println(Thread.currentThread().getName() + "num = " + num);
                    num++;
                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态[释放锁]
                        //方法本身有异常必须try-catch   Thread.sleep()方法本身也有异常[同样操作]
                        Number.class.wait();//省略this.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    break;
                }
            }
        }
    }
}
public class ThreadConmunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
