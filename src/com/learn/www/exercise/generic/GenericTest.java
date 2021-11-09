package com.learn.www.exercise.generic;

import org.junit.Test;

import java.util.*;

/**
 * @author lowo
 * 2021/10/21->20:26
 */

//泛型的使用
//1.jdk 5.0新增的特性
//2.在集合中使用泛型:
//总结:
//集合接口或集合类在jdk5.0时都修改为带泛型的结构。
//在实例化集合类时，可以指明具体的泛型类型
//指明完以后，在集合类或接口中凡是定义类或接口时，内部结构(比如:方法、构造器、属性等)使用到类的泛型的位置，都指定为实例化的泛型类型。
//      比如: add(E e)--->实例化以后: add(Integer e)
//注意点:泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类代替
//如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
//3.如何自定义泛型结构:泛型类、泛型接口、泛型方法
//泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如:<E1,E2,E3>
//泛型类的构造器如下:public GenericClass()。而下面是错误的: public GenericClass<E>()
//实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。泛型不同的引用不能相互赋值。
//尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是，在运行时只有个ArrayList被加载到JVM中。
//泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价Object。
//经验:泛型要使用一路都用。要不用，一路都不要用。
//如果泛型类是一个接口或抽象类，则不可创建泛型类的对象。
//jdk1.7，泛型的简化操作: ArrayList<Fruit> list = new ArrayList<>();
//泛型的指定中不能使用基本数据类型，可以使用包装类替换。
//在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态属性的类型、非静态方法的参数类型、非静态方法的返回值类型。但在静态方法中不能使用类的泛型。
//异常类不能是泛型的
//不能使用new E[]。但是可以:E[] elements = (E[])new Object[capacity];
//  参考:ArrayList源码中声明:Object[]elementData，而非泛型参数类型数组。
//父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型:
//子类不保留父类的泛型:按需实现
//  没有类型 -> 擦除
//  具体类型
//子类保留父类的泛型:泛型子类
//  全部保留
//  部分保留
//结论:子类必须是“ 富二代 ”，子类除了指定或保留父类的泛型，还可以增加自己的泛型
public class GenericTest {

    //1.泛型在继承方面的体现
    //虽然类A是类B的父类，但是 G<A> 和 G<B> 二者不具备子父类关系，二者是并列关系。
    //补充:类A是类B的父类， A<G> 是 B<G> 的父类
    //2.通配符的使用
    //  通配符:?
    //      添加:对于List<?>就不能向其内部添加数据。
    //      除了添加null之外。
    //      获取(读取):对于List<?>允许读取数据，读取的数据类型为Object
    //3.有限制条件的通配符的使用
    //  ? extends A:
    //      G<? extends A>可以作为 G<A> 和 G<B> 的父类，其中 B 是 A 的子类 [小于等于A]
    //          添加:对于G<? extends A>就不能向其内部添加数据。
    //          除了添加null之外。
    //          获取(读取):对于G<? extends A>允许读取数据，读取的数据类型为Object
    //  ? super A:
    //      G<? super A>可以作为 G<A> 和 G<B> 的父类，其中 B 是 A 的父类 [大于等于A]
    //          添加:对于G<? super A>就能向其内部添加数据[可以加 A 类与 B 类的数据]
    //          获取(读取):对于G<? super A>允许读取数据，读取的数据类型为Object
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;
        //list1 = list2;//报错
        List<?> list = null;
        list = list1;
        list = list2;
        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("b");
        list3.add("e");
        list3.add("d");
        list = list3;
        //添加:对于List<?>就不能向其内部添加数据。
        //除了添加null之外。
        //list.add("AA");
        list.add(null);
        System.out.println("list = " + list);
        //获取(读取):对于List<?>允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println("o = " + o);


    }

    @Test
    public void test2() {
        //测试泛型方法
        Order<String> order2 = new Order<>();
        Integer arr[] = new Integer[]{10,23,4,24,2,12};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> integers = order2.copyFromArrayToList(arr);
        System.out.println("integers = " + integers);

        Order order = new Order();
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为object类型
        //要求:如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        order.setOrderE(123);
        order.setOrderE("ABC");
        //建议:实例化时指明类的泛型
        Order<String> order1 = new Order<>(1,"A","try");
        order1.setOrderE("tryA");
        System.out.println("order1 = " + order1);
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        SubOrder sub1 = new SubOrder();
        sub1.setOrderE(1223123);
        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderE("tryB");

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //泛型不同的引用不能相互赋值。
        //list1 = list2;


    }

    @Test
    public void test1(){
        //在集合中使用泛型之前的情况:
        //问题一:类型不安全
        //问题二:强转时，可能出现ClassCastException
        //在集合中使用泛型的情况:[泛型不能为基本数据类型]
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(13);
        list.add(1543);
        list.add(123);
        //编译时，就会进行类型检查，保证数据的安全
        //list.add("13");//报错
        //避免了强转操作
        //方式1
        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }
        //方式2
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            System.out.println("i = " + i);
        }
        //在集合中使用泛型的情况:以HashMap为例
        //HashMap<String, Integer> map = new HashMap<String, Integer>();
        //jdk7新特性:类型推断[后面直接 <> 就行]
        HashMap<String, Integer> map = new HashMap<>();
        map.put("lowo",324);
        map.put("owo",21224);
        map.put("wo",3224);
        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        //Map.Entry<String, Integer>也行 因为导入了import java.util.*;
        //如果要直接用Entry<String, Integer> 还需要导入import java.util.Map.*;
        Iterator<Map.Entry<String, Integer>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> e = iterator1.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        }
    }
}
