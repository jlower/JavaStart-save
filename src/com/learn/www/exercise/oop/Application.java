package com.learn.www.exercise.oop;

/**
 * @author lowo
 * 2021/10/5->22:43
 */

//Ctrl+F12:打开当前类里面的member 输入就可以查
//Ctrl+H:打开当前类的继承树

//一个项目因该只存在一个main方法
public class Application {
    public static void main(String[] args) {


    }
}
/*
        Outer outer=new Outer();
        //通过这个外部类来实例化内部类 Outer.Inner
        Outer.Inner inner = outer.new Inner();
        inner.in();
        inner.getID();
 */
/*
        //Object > String
        //Object > Person > Student
        //Object > Person > Teacher
        Object object = new Student();
        //A instanceof B判断是否相关  B与A有祖宗/父子关系则为true
        System.out.println(object instanceof Person);//ture
        System.out.println(object instanceof Object);//true
        System.out.println(object instanceof Student);//true
        System.out.println(object instanceof String);//false
        System.out.println(object instanceof Teacher);//false
        System.out.println("========================================================");
        Person person = new Student();
        //A instanceof B判断是否相关  B与A有祖宗/父子关系则为true
        System.out.println(person instanceof Person);//ture
        System.out.println(person instanceof Object);//true
        System.out.println(person instanceof Student);//true
        //System.out.println(person instanceof String);//编译错误   同级无关
        System.out.println(person instanceof Teacher);//false
        System.out.println("========================================================");
        Student student = new Student();
        //A instanceof B判断是否相关  B与A有祖宗/父子关系则为true
        System.out.println(student instanceof Person);//ture
        System.out.println(student instanceof Object);//true
        System.out.println(student instanceof Student);//true
        //System.out.println(student instanceof String);//编译错误   同级无关
        //System.out.println(student instanceof Teacher);//编译错误   同级无关

*/
/*
        //一个对象的实际类型是确定的
        //new Person();
        //new Student();

        //可以指向的引用类型不确定:祖宗类&父类的引用可以指向子类
        //Student能调用的方法都是自己的或者从父类继承下来的
        Student s1 = new Student();
        //Person父类的引用可以指向子类,但不能调用子类独有的方法
        Person s2 = new Student();
        Object s3 = new Student();
        //若父类的引用指向子类
        //子类重写了父类的方法,就要执行子类的方法//对象能执行哪些方法主要看对象左边的类型
        s2.run();//父类的引用可以指向子类
        s1.run();
        //对象能执行哪些方法主要看对象左边的类型
        //s2.eat();//不行
        ((Student) s2).eat();//父子类之间才能转换
        s1.eat();
 */
/*
//        //若全用static : 方法的调用只和左边定义的数据类型有关
//        A a = new A();
//        a.test();//A类的方法
//
//        //父类的引用指向了子类
//        B b = new A();
//        b.test();//B类的方法

        //若全不用static
        //static final private 修饰的不能重写
        //非静态才能重写

        A a = new A();
        a.test();//A类的方法

        //父类的引用指向了子类
        B b = new A();//子类重写了父类的方法
        b.test();//B类的方法
 */
/*
        Teacher teacher1 = new Teacher();
        teacher1.test("test");
        teacher1.test2();
 */
/*
        Teacher teacher1 = new Teacher();
        teacher1.say();
 */
/*
        Student student1 = new Student();
        String name1 = student1.getName();
        System.out.println("name1 = " + name1);
        student1.setName("lowo");
        name1 = student1.getName();
        System.out.println("name1 = " + name1);
        System.out.println(student1.getName());
        student1.setAge(11111);
        System.out.println(student1.getAge());//排除了不合法的输入
        student1.setAge(24);
        System.out.println(student1.getAge());
 */
/*
        Pet dog = new Pet();

        dog.name = "kawii";
        dog.age = 3;
        dog.shout();
        System.out.println("dog.name = " + dog.name);
        System.out.println("dog.age = " + dog.age);
 */
/*
        Person person1 = new Person();
        Person person2 = new Person("lowo2");

        System.out.println("person1.name = " + person1.name);
        System.out.println("person2.name = " + person2.name);
 */
/*
        //类实例化后返回一个自己的对象  实例
        Student student1 = new Student();

 */