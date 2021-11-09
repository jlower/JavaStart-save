package com.learn.www.exercise.thread;

/**
 * @Author lowo
 * @Email
 * @Date 2021/11/6
 * @Description JavaStart
 */
public class TryThreadLocal {
    public void create() {
        String name = Thread.currentThread().getName();
        System.out.println("TryThreadLocal在线程[" + name + "]取出关联的数据是:" + ThreadLocalTest.data.get(name));
        System.out.println("TryThreadLocal在线程[" + name + "]取出关联的数据是:" + ThreadLocalTest.threadLocal.get());

    }
}
