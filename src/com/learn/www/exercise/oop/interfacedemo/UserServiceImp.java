package com.learn.www.exercise.oop.interfacedemo;

/**
 * @author lowo
 * 2021/10/7->5:45
 */
//抽象类：extends
//类可以实现接口 implements 按口
//接口名+Imp   接口的实现类的类名
//  类名  implements 接口名
// 实现了接口的类，就需要重写接口中的方法

//多继承～利用按口实现多继承    一个类可以实现多个接口
public class UserServiceImp implements UserService,TimerService{
    @Override
    public void add(String name) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void update(String name) {


    }

    @Override
    public void query(String name) {

    }

    @Override
    public void timer() {

    }
}
