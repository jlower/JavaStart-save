package com.learn.www.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author lowo
 * 2021/10/19->18:44
 */

//  |----collection接口:单列集合，用来存储一个一个的对象
//      |----List接口:存储有序的、可重复的数据。-->“动态”数组,替换原有的数组
//          |----ArrayList:作为List接口的主要实现类;线程不安全的，效率高;底层使用object[]存储
//          |----LinkedList:对于频繁的插入、删除操作，使用此类效率比ArrayList高;底层使用双向链表存储
//          |----Vector:作为List接口的古老实现类;线程安全的，效率低;底层使用object[]存储
//面试题:ArrayList、LinkedList. Vector三者的异同?
//同:三个类都是实现了List接口，存储数据的特点相同:存储有序的、可重复的数据
//不同:见上
//ArrayList的源码分析:
//      jdk 7情况下
//ArrayList list = new ArrayList();//底层创建了长度是10的object[]数组elementData
//list.add(123);//elementData[0] = new Integer(123);
//...
//list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
//默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
//结论:建议开发中使用带参的构造器:ArrayList list = new ArrayList(int capacity)
//      jdk 8中ArrayList的变化:
//ArrayList list = new ArrayList();//底层object[] elementData初始化为{} 并没有创建长度为10的数组
//list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据 123 添加到elementData数组中
//...
//后续的添加和扩容操作与jdk 7无异。
//2.3小结: jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象的创建类似于单例的懒汉式，
//        延迟了数组的创建，节省内存。

//3.LinkedList的源码分析:
//LinkedList list = new LinkedList();//内部声明了Node类型的first和Last属性，默认值为null
//list.add(123);//将123封装到Node中，创建了Node对象。
//其中，Node定义为:体现了LinkedList的双向链表的说法
//private static class Node<E> {
//  E item;
//  Node<E>next;
//  Node<E> prev;
//  Node(Node<E> prev, E eLement， Node<E> next) {
//      this.item = element;
//      this.next = next;
//      this.prev = prev;
//  }
//}

//4.Vector的源码分析: jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组
//                  在扩容方面，默认扩容为原来的数组长度的2倍。

public class ListTest {


    //void add(int index, object ele):在index位置插入ele元素
    //boolean addAll(int index,collection eles):从index位置开始将eles中的所有元素添加进来
    //Object get(int index):获取指定index位置的元素
    //int indexOf(object obj):返回obj在集合中首次出现的位置   如果不存在，返回-1.
    //int lastIndexOf(object obj):返回obj在当前集合中末次出现的位置   如果不存在，返回-1.
    //Object remove(int index):移除指定index位置的元素，并返回此元素
    //Object set(int index,object ele):设置指定index位置的元素为ele [替换]
    //List sublist(int fromIndex,int toIndex):返回从fromIndex到toIndex位置的子集合

    //总结:常用方法
    //增: add(object obj)
    //删: remove(int index) / remove(object obj)改: set(int index, object eLe)
    //查: get(int index)
    //插: add(int index, object ele)长度: size()
    //遍历:  Iterator迭代器方式
    //      增强for循环
    //      普通的循环

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person(23,"lowo"));
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println("iterator.next() = " + iterator.next());
        }
        for (Object o : list) {
            System.out.println("o = " + o);
        }

        System.out.println(list);
        //void add(int index, object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);
        //boolean addAll(int index,collection eles):从index位置开始将 eles 中的所有元素添加进来
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        //list.add(list1);//当作一个元素加入
        System.out.println(list.size());//8
        //int indexOf(object obj):返回obj在集合中首次出现的位置   如果不存在，返回-1.
        int index = list.indexOf("AA");
        System.out.println(index);
        //int lastIndexOf(object obj):返回obj在当前集合中末次出现的位置   如果不存在，返回-1.
        System.out.println(list.lastIndexOf(456));
        //object remove(int index):移除指定index位置的元素，并返回此元素
        //区分List中 remove(int index) 和 remove(object obj)

        Object obj = list.remove(index);//按索引删除返回此元素
        //Object obj2 = list.remove(123);//索引123
        Object obj2 = list.remove(new Integer(123));//删去元素123返回boolean
        System.out.println("obj2 = " + obj2);
        System.out.println("obj = " + obj);
        System.out.println(list);
        //Object set(int index,object ele):设置指定index位置的元素为ele [替换]
        list.set(1,"CC");
        System.out.println(list);
        //List sublist(int fromIndex,int toIndex):返回从fromIndex到toIndex位置的子集合
        List subList = list.subList(2,4);
        System.out.println(subList);
        System.out.println(list);
    }

}
