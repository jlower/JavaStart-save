package com.learn.www.exercise.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lowo
 * 2021/10/17->4:06
 */

//创建线程的方式四:使用线程池
//背景:经常创建和销毁、使用量特别大的资源，比如并发情况下的线程，对性能影响很大。
//思路:提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。可以避免频繁创建销毁、实现重复利用。
//    类似生活中的公共交通工具。
//好处:
//>提高响应速度（减少了创建新线程的时间)
//>降低资源消耗(重复利用线程池中线程，不需要每次都创建)
//>便于线程管理
//  corePoolSize:核心池的大小
//  maximumPoolSize:最大线程数
//  keepAliveTime:线程没有任务时最多保持多长时间后会终止
//  ......

class NumberThread implements Runnable{

    @Override
    public void run() {
        for(int i = 1;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for(int i = 1;i <= 100;i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadPoolTest {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //设置线程池的属性
        //System.out.println(service.getClass());
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(3);
        //service1.setKeepAliveTime();

        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合适用于Runnable
        service.execute(new NumberThread1());//适合适用于Runnable
        //Future future = service.submit(new Xx(x));//适合使用于Callable[Xx为实现Callable的实现类]

        //3.关闭连接池
        service.shutdown();


    }
}
