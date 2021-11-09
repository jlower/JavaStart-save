package com.learn.www.exercise.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author lowo
 * 2021/10/19->23:26
 */
public class TreeSetTest {

    //1.向TreeSet中添加的数据，要求是相同类的对象。
    //2.两种排序方式:自然排序和定制排序
    //3.自然排序中，比较两个对象是否相同的标准为: compareTo()返回0  不再是equals()
    //      [如果compareTo()没有把所有的对象加入则有可能误判两元素相等，从而不加入TreeSet中]
    //eg.treeSet.add(new Person(23,"wowo"));treeSet.add(new Person(234,"wowo"));
    //   [compareTo()中只比较了name字符串,没比较age,则name相同,age不同的数据也不能加入TreeSet中]
    //4.定制排序中，比较两个对象是否相同的标准为: compare()返回0 不再是equals()
    @Test
    public void test1(){
        TreeSet treeSet = new TreeSet();
        //失败:不能添加不同类的对象
//        treeSet.add(123);
//        treeSet.add(456);
//        treeSet.add("AA");
//        treeSet.add(new Person(23,"lowo"));
//        treeSet.add(123);
//        treeSet.add(2);
//        treeSet.add(13412);
        treeSet.add(new Person(23,"lowo"));
        treeSet.add(new Person(23,"wowo"));
        treeSet.add(new Person(23,"leowo"));
        treeSet.add(new Person(234,"wowo"));
        treeSet.add(new Person(23,"rowo"));
        System.out.println("treeSet = " + treeSet);
    }

    @Test
    public void test2(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        TreeSet treeSet = new TreeSet(com);



    }
}
