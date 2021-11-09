package com.learn.www.exercise.normalclass.datetime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author lowo
 * 2021/10/17->21:40
 */
//jdk 8中日期时间API的测试
//      导包import java.time.
public class JDK8DateTimeTest {

    //DateTimeFormatter:格式化或解析日期、时间[类似于SimpleDateFormat]
    @Test
    public void test3(){
        //方式一:预定义的标准格式。如: ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime) ;
        System. out.println(localDateTime);
        System.out.println(str1);
        //解析:字符串-->日期
        TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
        System.out.println(parse);

        //方式二:
        //本地化相关的格式。如: ofLocalizedDateTime(FormatStyle.LONG)
        //FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT ∶ 适用于LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String str2 = dateTimeFormatter.format(localDateTime);
        System.out.println(str2);

        //本地化相关的格式。如: ofLocalizedDate()
        //FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str3 = dateTimeFormatter2.format(localDateTime);
        System.out.println(str3);
        //重点:方式三:自定义的格式。如: ofPattern("yyyy-MM-dd hh:mm: ss")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);
        //解析
        TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
        System.out.println(accessor);



    }


    //Instant的使用
    @Test
    public void test2(){
        //now()∶获取本初子午线对应的标准时间 [创建实例]
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);
        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);
        //获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数
        long mili = instant.toEpochMilli();
        System.out.println("mili = " + mili);
        //ofEpochMiLLi(long millis):通过给定的毫秒数，获取Instant实例 --> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(16344852772229L);
        System.out.println("instant1 = " + instant1);

    }

    //LocalDate. LocalTime. LocalDateTime的使用说明:
    //  1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
    //  2.类似于Calendar
    @Test
    public void test(){
        //now()∶获取当前的日期、时间、日期+时间 [创建实例]
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now( );
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        //of():设置指定的年、月、日、时、分、秒、纳秒[1纳秒=十亿分之一秒]。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2021,10,23,3,32,34,2);
        System.out.println("localDateTime1 = " + localDateTime1);
        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());//17
        System.out.println(localDateTime.getDayOfWeek());//SUNDAY
        System.out.println(localDateTime.getMonthValue());//10
        System.out.println(localDateTime.getMonth());//OCTOBER
        System.out.println(localDateTime.getMinute());//2
        //体现不可变性[有返回值，并非直接改本身]
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(1);
        localDateTime2 = localDateTime2.withHour(3);
        localDateTime2 = localDateTime2.plusDays(6);
        localDateTime2 = localDateTime2.minusHours(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
    }
}
