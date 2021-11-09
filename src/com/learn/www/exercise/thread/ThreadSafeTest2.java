package com.learn.www.exercise.thread;

/**
 * @author lowo
 * 2021/10/16->22:05
 */

//使用同步方法解决实现Runnable接口的线程安全问题
//关于同步方法的总结:
//1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
//2.非静态的同步方法，同步监视器是:this[有可能有安全问题]
//  静态的同步方法，同步监视器是:当前类本身Xxx.class[没有安全问题]


class SaleTick2 implements Runnable{
    private int ticket = 10000;
    private int all = 0;

    public int getAll() {
        return all;
    }
    public static synchronized boolean sale2(){//同步监视器: Xxx.class[没有安全问题]
        return true;
    }
    public synchronized boolean sale(){//同步监视器: this[有可能有安全问题]
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "ticket = " + ticket);
            ticket--;
            all++;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void run() {
        while(true){
            if(ticket <= 0) return;//这样效率高[有一个人进去完成最后一个了,后面的就没必要在阻塞等判断了]
            if(!sale()) return;
        }

    }
}
public class ThreadSafeTest2 {
    public static void main(String[] args) {
        SaleTick2 saleTick2 = new SaleTick2();
        Thread t1 = new Thread(saleTick2);
        t1.start();
        Thread t2 = new Thread(saleTick2);
        t2.start();
        Thread t3 = new Thread(saleTick2);
        t3.start();
        while(true){
            if(!t1.isAlive()&&!t2.isAlive()&&!t3.isAlive()){
                System.out.println("saleTick.getAll() = " + saleTick2.getAll());
                break;
            }
        }
    }
}
