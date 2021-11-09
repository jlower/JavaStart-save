package com.learn.www.exercise.thread;

/**
 * @author lowo
 * 2021/10/16->16:37
 */
//多线程的创建:
//方式一：创建继承于Thread类的子类  /  创建Thread类的匿名子类的方式[简单使用]
//    [造多个子类][不能不用static而直接共用子类中的属性]
//  1.创建一个继承于Thread类的子类
//  2.重写Thread类的run()  ->  将此线程执行的操作声明在run()中
//  3.创建Thread类的子类的对象
//  4.通过此对象调用start():①启动当前线程②调用当前线程的run()方法
//我们不能通过直接调用run()的方式启动线程
//不可以还让已经start()的线程去执行start(),我们需要重新创建一个线程的对象去执行start()实现多线程
//  否则报错IllegalThreadStateException
//方式二:实现Runnable接口[只用造一个实现类后面造多个Thread的类][直接使用同一个实现类中的属性不用static]
//1.创建一个实现了Runnable接口的类
//2.实现类去实现Runnable中的抽象方法: run()
//3.创建实现类的对象
//4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
//5.通过Thread类的对象调用start()//调用了Runnable类型的target的run()

//比较创建线程的两种方式。
//开发中:优先选择:实现Runnable接口的方式
//原因: 1.实现的方式没有类的单继承性的局限性
//     2.实现的方式更适合来处理多个线程有共享数据的情况。
//联系:   public class Thread implements Runnable
//相同点:两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。

//测试Thread中的常用方法：
//1.start():启动当前线程：调用当前线程的run()
//2.run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
//3.currentThread():静态方法[可以直接用类调]，返回执行当前代码的线程
//4.getName():获取当前线程的名字
//5.setName():设置当前线程的名字
//6.yield():释放当前cpu的执行权
//7.join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态,直到线程b完全执行完以后,线程a才结束阻塞状态
//8.stop():已过时。当执行此方法时，强制结束当前线程
//9.sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒。
//  在指定的millitime毫秒时间内，当前线程是阻塞状态
//10.isAlive():判断当前线程是否存活

//线程的优先级：
//1.
//MAX_PRIORITY:10
//MIN_PRIORITY:1
//NORM_PRIORITY:5
//2.如何获取和设置当前线程的优先级:
//getPriority():获取线程的优先级
//setPriority (int p)∶设置线程的优先级
//说明:高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下被执行。
//    并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +
                        Thread.currentThread().getPriority()+":" + i);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(i % 20 == 0){
                //yield();//省略this.yield();

            }
        }
    }
    public MyThread(){

    }
    public MyThread(String name){
        super(name);
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("线程1");
        //设置分线程的优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        //不可以还让已经start()的线程去执行start(),我们需要重新创建一个线程的对象去执行start()
        //t1.start();//报错IllegalThreadStateException
//        MyThread t2 = new MyThread("线程2");
//        t2.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 50; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if(i == 20){
                try {
                    t1.join();//必须try-catch
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(t1.isAlive());
        //创建Thread类的匿名子类的方式
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 0; i < 50; i++) {
//                    if(i % 2 == 0){
//                        System.out.println(Thread.currentThread().getName() + ":" + i);
//                    }
//                }
//            }
//        }.start();
    }
}
