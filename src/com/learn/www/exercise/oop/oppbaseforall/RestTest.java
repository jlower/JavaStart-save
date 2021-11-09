package com.learn.www.exercise.oop.oppbaseforall;

/**
 * @author lowo
 * 2021/10/10->12:42
 */
//

//JavaSE5.0中提供了Varargs(variablernumberofarguments）机制，允许直接定义能和多个实参相匹配的形参。

//可以用一种更简单的方式，从而来传递个数可变的实参  [传递个数可为0]
//1.jdk5.0新增的内容
//2.具体使用：
//2.1可变个数形参的格式：     数据类型... 变量名
//2.2当调用可变个数形参的方法时，传入的参数个数可以是：0个，1个，2个......
//2.3可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
//2.4可变个数形参的方法与本类中方法名相同，形参类型也相同的数组之间不构成重载。换句话说，二者不能共存
//public void show(String... strs) 与 public void show(String[] strs)不能同时存在，不构成重载
//2.5可变个数形参在方法的形参中，必须声明在末尾    public void show(int i,String... strs)
//public void show(String... strs,int i)//错误
//2.6可变个数形参在方法的形参中，最多只能声明一个可变形参
public class RestTest {
    public static void main(String[] args) {
        RestTest test = new RestTest();
        test.show("asfd");//是可变个数形参 [传递个数为1] 但优先找有没有public void show(String str)
        test.show("sfsd","sfsd","sfsd","sfsd");
//        test.show();//不输入也是可变个数形参 [传递个数可为0] 但优先找有没有public void show()
        String[] arr = new String[]{"12","432"};
        test.show(arr);//输入一个数组也是可变个数形参  可变个数形参依然为一维数组
        //可变个数形参strs为一维数组 若输入一个数组则直接让 strs = 输入的数组的地址   指向同一个对象
        //System.out.println("arr[0] = " + arr[0]);// strs[0] = "23";//strs改变  输入的数组内的值也会变
        //test.show(new String[]{"12","432"}, new String[]{"12","12","432"});//输入多个数组则报错
    }
//    public void show(){
//        System.out.println(0);
//    }
    public void show(int i){
        System.out.println(1);
    }
    public void show(String... strs){
        //可变个数形参strs为一维数组 若输入一个数组则直接让 strs = 输入的数组的地址   指向同一个对象
        // strs[0] = "23";//strs改变  输入的数组内的值也会变
        System.out.println(3);

        for (String str : strs) {
            System.out.print(str + " " );
        }
        System.out.println();
    }
    public void show(String str){
        System.out.println(2);
    }

}
