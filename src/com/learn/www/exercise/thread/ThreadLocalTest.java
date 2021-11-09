package com.learn.www.exercise.thread;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author lowo
 * @Email
 * @Date 2021/11/6
 * @Description JavaStart
 */

public class ThreadLocalTest {
    //ThreadLocal 的作用，它可以解决多线程的数据安全问题。
//ThreadLocal它可以给当前线程关联一个数据（可以是普通变量，可以是对象，也可以是数组，集合)
//ThreadLocal的特点:
//  1、ThreadLocal可以为当前线程关联一个数据。(它可以像Map一样存取数据，key为当前线程)
//  2、每一个 ThreadLocal对象，只能为当前线程关联一个数据，如果要为当前线程关联多个数据，就需要使用多个ThreadLocal对象实例。
//  3、每个ThreadLocal 对象实例定义的时候，一般都是static类型
//  4、ThreadLocal中保存数据，在线程销毁后。会由JVM虚拟自动释放。
    public final static Map<String, Object> data = new ConcurrentHashMap<>();
    public static Random random = new Random();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static class Task implements Runnable {
        @Override
        public void run() {
            //在Run方法中，随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到map中
            int i = random.nextInt(1000);
            //获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("在线程[" + name + "]创建时关联的数据是:" + i);
            data.put(name, i);
            threadLocal.set(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new TryThreadLocal().create();
            //在Run方法结束之前，以当前线程名获取出数据并打印。查看是否可以取出操作
            Object o = data.get(name);
            System.out.println("在线程[" + name + "]快结束时取出关联的数据是:" + o);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();

        }
    }

}
