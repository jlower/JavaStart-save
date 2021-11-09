package com.learn.www.exercise.thread;

/**
 * @author lowo
 * 2021/10/16->18:25
 */

//多线程的创建:
//方式二:实现Runnable接口
//1.创建一个实现了Runnable接口的类
//2.实现类去实现Runnable中的抽象方法: run()
//3.创建实现类的对象
//4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
//5.通过Thread类的对象调用start()//调用了Runnable类型的target的run()

class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +
                        Thread.currentThread().getPriority()+":" + i);
            }
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread2 m1 = new MyThread2();
        Thread t1 = new Thread(m1);
        t1.setName("线程1");
        t1.start();
        Thread t2 = new Thread(m1);
        t2.setName("线程2");
        t2.start();
    }
}

