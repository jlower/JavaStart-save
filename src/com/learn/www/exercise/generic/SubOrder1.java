package com.learn.www.exercise.generic;

/**
 * @author lowo
 * 2021/10/21->21:07
 */
public class SubOrder1<T> extends Order<T>{
    public SubOrder1() {
    }

    public SubOrder1(int orderId, String orderName, T orderE) {
        super(orderId, orderName, orderE);
    }
}
