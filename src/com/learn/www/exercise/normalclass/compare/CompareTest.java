package com.learn.www.exercise.normalclass.compare;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lowo
 * 2021/10/18->6:50
 */

//一、说明: Java中的对象，正常情况下，只能使用 == 或 != 进行比较    不能使用 > 或 <
//         但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
//         如何实现?使用两个接口中的任何一个: Comparable或 Comparator
//二、Comparable接口与Comparator的使用的对比:
//   Comparable接口的方式一旦确定，保证Comparable接口实现类的对象在任何位置都可以比较大小
//   Comparator接口属于临时性的比较
public class CompareTest {

    //Comparator接口的使用:定制排序
    //1.背景:
    //当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码
    //或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
    //那么可以考虑使用Comparator的对象来排序
    //2.重写compare(Object o1,Object o2)方法，比较 o1 和 o2 的大小:
    //如果方法返回正整数，则表示 o1 大于 o2
    //如果返回0，表示相等
    //返回负整数，表示 o1 小于 o2
    @Test
    public void test3() {
        Goods[] arr2 = new Goods[5];
        arr2[0] = new Goods("lenovoMouse",34);
        arr2[1] = new Goods("de1lMouse",43);
        arr2[2] = new Goods("xiaomiMouse",12);
        arr2[3] = new Goods("huaweiMouse",65);
        arr2[4] = new Goods("huaweiMouse",654);
        Arrays.sort(arr2, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());//大的在前
                    }
                    else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });//数组内不能有空指针
        System.out.println("arr2 = " + Arrays.toString(arr2));

        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);//从大到小反排序
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println("arr = " + Arrays.toString(arr));
    }

    //Comparable接口的使用举例:自然排序
    //1.像String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式
    //2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
    //3.重写compareTo(obj)的规则:
    //      如果当前对象this大于形参对象obj，则返回正整数
    //      如果当前对象this小于形参对象obj，则返回负整数，
    //      如果当前对象this等于形参对象obj，则返回零。
    //4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法
    //  在compareTo(obj)方法中指明如何排序 [cannot be cast to 不能转换为]
    @Test
    public void test1() {
        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr);//默认从小到大
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Test
    public void test2() {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("de1lMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        Arrays.sort(arr);//数组内不能有空指针
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
