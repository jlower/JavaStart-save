package com.learn.www.exercise.normalclass.compare;

/**
 * @author lowo
 * 2021/10/18->6:59
 */
public class Goods implements Comparable{
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //指明商品比较大小的方式
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods = (Goods)o;
//            if(this.price > goods.price){
//                return 1;
//            }
//            else if (this.price < goods.price){
//                return -1;
//            }
//            else{
//                return 0;
//            }
            //方式二:
            return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致!");
    }
}
