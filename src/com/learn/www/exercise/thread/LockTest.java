package com.learn.www.exercise.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lowo
 * 2021/10/17->0:19
 */

//解决线程安全问题的方式三:Lock锁 --- JDK5.0新增
//1.实例化ReentrantLock
//2.调用锁定方法lock()
//3.调用解锁方法: unlock()

//1.面试题: synchronized 与lock的异同?
//      相同:二者都可以解决线程安全问题
//      不同:synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
//          lock需要手动的启动同步lock()，同时结束同步也需要手动的实现unlock()
//2.优先使用顺序:
//  lock -> 同步代码块(已经进入了方法体，分配了相应资源) -> 同步方法(在方法体之外)
//面试题:如何解决线程安全问题?有几种方式?

class SaleTick3 implements Runnable{
    private int ticket = 100;
    private int all = 0;
    public int getAll() {
        return all;
    }
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();//Ctrl+P 看应该的参数

    @Override
    public void run() {
        while(true){
            try {
                //2.调用锁定方法lock()   //要解锁unlock()所以用 try-finally
                lock.lock();
                if (ticket > 0) {
    //                try {
    //                    Thread.sleep(100);
    //                } catch (InterruptedException e) {
    //                    e.printStackTrace();
    //                }
                    System.out.println(Thread.currentThread().getName() + "ticket = " + ticket);
                    ticket--;
                    all++;
                } else {
                    return;
                }
            } finally {
                //3.调用解锁方法: unlock()
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        SaleTick3 saleTick3 = new SaleTick3();
        Thread t1 = new Thread(saleTick3);
        t1.start();
        Thread t2 = new Thread(saleTick3);
        t2.start();
        Thread t3 = new Thread(saleTick3);
        t3.start();
        while(true){
            if(!t1.isAlive()&&!t2.isAlive()&&!t3.isAlive()){
                System.out.println("saleTick.getAll() = " + saleTick3.getAll());
                break;
            }
        }
    }
}
