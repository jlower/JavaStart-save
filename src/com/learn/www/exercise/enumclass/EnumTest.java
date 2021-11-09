package com.learn.www.exercise.enumclass;

/**
 * @author lowo
 * 2021/10/18->18:53
 */
//Ctrl+Alt+Shift+j 选中所有一样的单词一起更改
//Alt+Shift+方向键上/下 把选中的所有代码上下移动

//一、枚举类的使用
//1.枚举类的理解:类的对象只有有限个，确定的。我们称此类为枚举类
//2.当需要定义一组常量时，强烈建议使用枚举类
//3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
//二、如何定义枚举类
//方式一: jdk5.0之前，自定义枚举类
//方式二: jdk5.0，可以使用enum关键字定义枚举类
//  说明:定义的枚举类默认继承于java.lang.Enum类
//三、Enum类的主要方法:
//values()方法:返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
//valueOf(String str):可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。
//                    如不是或没有找到，会有运行时异常:IllegalArgumentException。
//toString():返回当前枚举类对象常量的名称
//四、使用enum关键字定义的枚举类实现接口的情况
//  情况一:实现接口，在enum类中实现抽象方法[直接在enum中写重载方法,每个对象调用的方法实现一样]
//  情况二:让枚举类的对象分别实现接口中的抽象方法[每个对象加{}在{}中写重载方法,每个对象调用的方法实现不一样]
//    SPRING("春","spring"){
//        @Override
//        public void show() {
//
//        }
//    },
//    SUMMER("夏", "summer"){
//        @Override
//        public void show() {
//
//        }
//    },
//    AUTUMN("秋", "autumn"){
//        @Override
//        public void show() {
//
//        }
//    },
//    WINTER("冬", "winter"){
//        @Override
//        public void show() {
//
//        }
//    };
public class EnumTest {
    public static void main(String[] args) {
        Season summer = Season.SUMMER;
        //toString():System.out.println(xxx);时自动调
        System.out.println("summer = " + summer);
        //values()
        Season[] values = Season.values();
        for (int i = 0; i < values.length; i++) {
            Season value = values[i];
            System.out.println("value = " + value);
        }
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            Thread.State state = values1[i];
            System.out.println("state = " + state);
        }
        //valueOf(String str):返回枚举类中对象名是objName的对象。
        //如果没有objName的枚举类对象，则抛异常:IllegalArgumentException
        Season winter = Season.valueOf("WINTER");
        System.out.println("winter = " + winter);
        Season1 spring = Season1.SPRING;
        System.out.println("spring = " + spring);
        System.out.println("spring.toString() = " + spring.toString());
    }
}
interface Info{
    void show();
}
//使用enum关键字定义枚举类
enum Season implements Info{
    //1.提供当前枚举类的对象，多个对象之间用"","隔开，末尾对象" ;"结束
    //      [必须一开始就提供]
    SPRING("春","spring"){
        @Override
        public void show() {

        }
    },
    SUMMER("夏", "summer"){
        @Override
        public void show() {

        }
    },
    AUTUMN("秋", "autumn"){
        @Override
        public void show() {

        }
    },
    WINTER("冬", "winter"){
        @Override
        public void show() {

        }
    };
    //2.声明Season对象的属性: private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器,并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    //4.其他诉求1:获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    //5.其他诉求2:提供toString()        [一般不重写了][默认打印当前对象的名字]
//
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
//自定义枚举类
class Season1{
    //1.声明Season1对象的属性: private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值
    private Season1(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    //3.提供当前枚举类的多个对象: public static final的
    public static final Season1 SPRING = new Season1("春","spring");
    public static final Season1 SUMMER = new Season1("夏", "summer");
    public static final Season1 AUTUMN = new Season1("秋", "autumn");
    public static final Season1 WINTER = new Season1("冬", "winter");

    //4.其他诉求1:获取枚举类对象的属性

    public String getSeason1Name() {
        return seasonName;
    }

    public String getSeason1Desc() {
        return seasonDesc;
    }

    //5.其他诉求2:提供toString()

    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
