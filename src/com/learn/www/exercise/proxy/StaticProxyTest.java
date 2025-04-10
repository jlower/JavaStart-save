package com.learn.www.exercise.proxy;

/**
 * @author lowo
 * 2021/10/25->23:19
 */

interface clothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements clothFactory {
        private clothFactory factory;//用被代理类对象进行实例化
        public ProxyClothFactory(clothFactory factory) {

            this.factory = factory;
        }
        @Override
        public void produceCloth() {
            System.out.println("代理工厂做一些准备工作");
            factory.produceCloth();
            System.out.println("代理工厂做一些后续的收尾工作");
        }
}
//被代理类
class NikeClothFactory implements clothFactory{
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        clothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}
