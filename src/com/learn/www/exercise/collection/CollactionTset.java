package com.learn.www.exercise.collection;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author lowo
 * 2021/10/18->22:12
 */

//一、集合框架的概述
//1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
//  说明:此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储(.txt, .jpg..avi，数据库中)
//2.1数组在存储多个数据方面的特点:
//>一旦初始化以后，其长度就确定了。
//>数组一旦定义好，其元素的类型也就确定了,我们也就只能操作指定类型的数据了。比如: String[] arr;int[] arr1;
//2.2数组在存储多个数据方面的缺点:
//>一旦初始化以后，其长度就不可修改。
//>数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便。
//>获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
//>数组存储数据的特点:有序、可重复。对于无序、不可重复的需求，不能满足。
//二、集合框架
//   |----collection接口:单列集合，用来存储一个一个的对象
//          |----List接口:存储有序的、可重复的数据。 -->"动态数组
//              |----ArrayList、LinkedList、Vector
//          |----Set接口:存储无序的、不可重复的数据  -->集合[确定性,无序性,互异性]
//              |----HashSet、 LinkedHashSet、 TreeSet
//   |----Map接口:双列集合，用来存储一对(key - value)一对的数据
//              |----HashMap、 LinkedHashMap、TreeMap、HashTable、Properties
//三、Collection接口中的方法的使用
//向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
    //

public class CollactionTset {

    //Collections常用方法[static]
    //reverse(List):反转List中元素的顺序
    //shuffle(List):对 List集合元素进行随机排序
    //sort(List):根据元素的自然顺序对指定List集合元素按升序排序
    //sort(List，Comparator):根据指定的 Comparator产生的顺序对List集合元素进行排序
    //swap(List，int， int):将指定 list集合中的i处元素和j处元素进行交换
    //Object max(Collection):根据元素的自然顺序，返回给定集合中的最大元素
    //Object max(Collection，Comparator):根据Comparator指定的顺序，返回给定集合中的最大元素
    //Object min(Collection)
    //Object min(Collection，Comparator)
    //int frequency(Collection，Object):返回指定集合中指定元素的出现次数
    //void copy(List dest,List src):将src中的内容复制到dest中
    //boolean replaceAll(List list，Object oldVal，Object newVal):使用新值替换List对象的所有旧值
    @Test
    public void test4(){
        List list = new ArrayList();
        list.add(2);
        list.add(-1342);
        list.add(232);
        list.add(224);
        list.add(-2);
        System.out.println("list = " + list);
        //Collections.reverse(list);
        //Collections.shuffle(list);
        //Collections.sort(list);
        //Collections.swap(list,1,2);
        int all = Collections.frequency(list,232);
        System.out.println("list = " + list);
        System.out.println("all = " + all);
        List dest = Arrays.asList(new Object[list.size()]);//标准写法
        //copy时必须dest.size() >= list.size() 若大于则dest后面的元素保留
        System.out.println("dest = " + dest);
        Collections.copy(dest,list);
        System.out.println("dest = " + dest);
        //Collections类中提供了多个synchronizedXxx()方法，该方法可使将指定集合包装成线程同步的集合，
        //  从而可以解决多线程并发访问集合时的线程安全问题
        //返回的List1即为线程安全的List
        List list1 = Collections.synchronizedList(list);


    }

    //集合元素的遍历操作，使用Iterator接口
    //jdk 5.0新增了foreach循环，用于遍历集合、数组
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(345);
        coll.add(new String("tom"));
        Person p = new Person(23, "lowo");
        coll.add(p);

        //jdk 5.0新增了foreach循环，用于遍历集合、数组
        //for(集合元素的类型  局部变量名  :  集合对象)
        //内部仍然调用了迭代器。[不会改变原有数组的值,只会将原来数组的值提取出来赋给新的对象]
        for (Object obj : coll) {
            System.out.println(obj);
        }

        //测试Iterator中的remove()
        //Iterator可以删除集合的元素，但是是遍历过程中通过迭代器对象的remove方法，不是集合对象的remove方法。
        //如果还未调用next()或在上一次调用next()方法之后已经调用了remove方法，
        //  再调用remove都会报IllegalStateException
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            if (iterator.next().equals("tom")) {
                iterator.remove();
            }
        }
        iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    //coLLection接口中声明的方法的测试
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(345);
        coll.add(new String("tom"));
        Person p = new Person(23, "lowo");
        coll.add(p);
        //contains(object obj):判断当前集合中是否包含obj
        //      我们在判断时会调用obj对象所在类的equals()。
        boolean contains = coll.contains(123);
        System.out.println("contains = " + contains);
        System.out.println(coll.contains(new String("tom")));//调用的equals()
        System.out.println(coll.contains(new Person(23,"lowo")));//调用的equals()
        //containsAll(Collection coll1):判断形参coll1集合中的所有元素是否都存在于当前集合coll中
        Collection coll1 = Arrays.asList(123,345);
        System.out.println(coll.containsAll(coll1));
        //remove(object obj):[返回值boolean是否删除成功,先判断有没有该元素]调用equals(),要重写equals()
        System.out.println(coll.remove(123));
        coll.remove(new Person(23, "lowo"));
        System.out.println(coll);
        //4. removeAll(Collection coll1):从当前集合中移除coll1集合中所有的元素
        //      [没有某元素,就不管它,移除别的相同元素][只有所有元素都不在当前集合时,返回false{没有移除元素}]
        System.out.println(coll.removeAll(coll1));
        System.out.println(coll);
        //retainAll(collection coll1):交集:获取当前集合和coll1集合的交集，并修改当前集合
        //equals(object obj):要想返回true，需要当前集合和形参集合的元素都相同。[ArrayList有序,HashSet无序...]
        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());
        //8.集合--->数组: toArray()
        Object[] arr = coll.toArray();
        System.out.println(arr);
        //拓展:数组--->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA","BB","CC"});
        System.out.println(list);
        List arr1 = Arrays.asList(new int[]{123,456});
        System.out.println( arr1.size());//1 [数组当作一个元素]
        List arr2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size());//2 [包装类则把里面每一个元素都放入]

    }

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add(object e):将元素e添加到集合coLl中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Object());
        //size():获取添加的元素的个数
        System.out.println(coll.size());//4
        //addALL(colLection coll1):将coLL1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println("coll = " + coll);
        //cLear():清空集合元素
        coll.clear();
        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }
}
