package com.learn.www.exercise.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lowo
 * 2021/10/21->21:00
 */
public class Order<E> {
    int orderId;
    String orderName;
    //类的内部结构就可以使用类的泛型
    E orderE;

    //泛型方法:在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以声明为静态的。原因:泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public <T> List<T> copyFromArrayToList(T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        for (T t : arr) {
            list.add(t);
        }
        return list;
    }



    public Order() {
        //编译不通过
        //E[] arr= new E[10];
        //编译通过
        E[] arr = (E[]) new Object[10];
    }

    public Order(int orderId, String orderName, E orderE) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderE = orderE;
    }

    public void setOrderE(E orderE) {
        this.orderE = orderE;
    }

    public E getOrderE() {
        return orderE;
    }

    @Override
    public String toString() {

        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", orderE=" + orderE +
                '}';
    }
}
