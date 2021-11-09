package com.learn.www.exercise.normalclass.datetime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author lowo
 * 2021/10/17->14:51
 */

//JDK 8之前日期和时间的API测试
public class DateTimeTest {


    //获取月份时:一月是0，二月是1，以此类推，12月是11
    //获取星期时:周日是1，周二是2, ... ... ,周六是7
    //Calendar日历类(抽象类)的使用
    //而Calendar并不比Date好多少。它们面临的问题是:
    //可变性:像日期和时间这样的类应该是不可变的。
    //偏移性:Date中的年份是从1900开始的，而月份都从O开始。
    //格式化:格式化只对Date有用，Calendar则不行。
    //此外，它们也不是线程安全的;不能处理闰秒等。
    @Test
    public void calendarTest(){
        //1.实例化
        //方式一:创建其子类(java.util.GregorianCalendar)的对象
        //方式二:调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();//得到 class java.util.GregorianCalendar
        System.out.println(calendar.getClass());//class java.util.GregorianCalendar
        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //getTime():日历类 ---> Date
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }



    //simpleDateFormat的使用: SimpleDateFormat对日期Date类的格式化和解析
    //1.两个操作:
    //1.1格式化:日期--->字符串
    //1.2解析:格式化的逆过程，字符串--->日期
    //2.SimpleDateFormat的实例化
    @Test
    public void testSimpleDateFormat() {
        //实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化:日期--->字符串
        Date date = new Date();
        System.out.println("date = " + date);
        String format = sdf.format(date);
        System.out.println("format = " + format);
        //解析:格式化的逆过程，字符串--->日期
        String str = "2021/10/17 下午8:41";
        Date date1 = null;
        try {
            date1 = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date1);
        //按照指定的方式格式化和解析:调用带参的构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println("format1 = " + format1);
        //解析
        Date date3 = null;
        try {
            date3 = sdf1.parse("2021-10-17 08:47:13");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date3);


    }

    //java.util.Date类
    //      |---java.sql.Date类
    //java.sql.Date类为java.util.Date类的子类[子类向上自动转换类型]
    //1.两个构造器的使用
    //  >构造器一: Date():创建一个对应当前时间的Date对象
    //  >构造器二:创建指定毫秒数的Date对象
    //2.两个方法的使用
    //  >toString()∶显示当前的年、月、日、时、分、秒
    //  >getTime()∶获取当前Date对象对应的毫秒数。(时间戳)
    //3.java.sql.Date对应着数据库中的日期类型的变量
    //  >如何实例化
    //  >如何将java.util.Date对象转换为java.sql.Date对象[通过构造器传时间戳]
    @Test
    public void test2(){
        //构造器一: Date():创建一个对应当前时间的Date对象
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());
        //构造器二:创建指定毫秒数的Date对象 (固定)
        Date date2 = new Date(1634453972712L);//(固定)
        System.out.println(date2.toString());//Sun Oct 17 14:59:32 CST 2021(固定)
        //创建java.sql.Date对象
        java.sql.Date date1 = new java.sql.Date(12634453972712L);
        System.out.println(date1.toString());
        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一:
//        Date date4 = new java.sql.Date(2343243242323L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二:
        Date date6 = new Date();
        //java.sql.Date date7 = (java.sql.Date) date6;//报错[new的父类不能强转为子类(多态才能)]
        java.sql.Date date7 = new java.sql.Date(date6.getTime());//[通过构造器传时间戳]
        System.out.println(date7.toString());
        
    }

    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。[称为时间戳]
        System.out.println("time = " + time);
    }


}
