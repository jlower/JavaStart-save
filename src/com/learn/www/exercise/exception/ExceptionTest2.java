package com.learn.www.exercise.exception;

/**
 * @author lowo
 * 2021/10/15->21:26
 */

//异常的处理：抓抛模型
//过程一：“抛”：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象
//并将此对象抛出。一旦抛出对象以后，其后的代码就不再执行
// 关于异常对象的产生：①系统自动生成的异常对象
//                  ②手动的生成一个异常对象，并抛出(throw)
//过程二：“抓”：可以理解为异常的处理方式：①try-catch-final1y②throws


//①try-catch-final1y说明:
//1.finally是可选的。
//2.使用try将可能出现异常代码包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，
//   根据此对象的类型，去catch中进行匹配
//3.一旦try中的异常对象匹配到某一个catch时，就进就进入catch中进行异常的处理。
//  一旦处理完成，就跳出当前的try-catch结构（在没有写finally的情况）。继续执行其后的代码
//4.catch中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下无所谓
//  catch中的异常类型如果满足子父类关系，则要求子类一定声明在父类的上面。否则，报错
//5.常用的异常对象处理的方式：①String getMessage() ②printStackTrace()
//6.在try结构中声明的变量，再出了try结构以后，就不能再被调用
//  [如果在外面要用，则先在外面声明，再在里面赋值(判断有无出异常)]
//7.finally中声明的是一定会被执行的代码。
//  即使catch中又出现异常了,try中有return语句,catch中有return语句等情况    也会先执行finally再返回值或报错
//8.try-catch-finally结构可以嵌套


//体会:使用try-catch-finally处理编译时异常，是得程序在编译时就不再报错，但是运行时仍可能报错。
//相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现。
//体会2:开发中,由于运行时异常比较常见,所以我们通常就不针对运行时异常编写try-catch-finally了。
//     而针对于编译时异常，我们说一定要考虑异常的处理
//
//3.开发中如何选择使用try-catch-finally还是使用throws？
//  3.1如果父类中被重写的方法没有throws方式处理异常,则子类重写的方法也不能使用throws方式处理异常
//     意味着如果子类重写的方法中有异常，必须使用try-catch-fina1ly方式处理
//  3.2执行的方法a中，先后又调用了另外的几个方法，这几个方法是递进关系执行的。我们建议这几个方法使用throws
//     的方式进行处理。而执行的方法a中可以考虑使用try-catch-finally的方式进行处理。
//

public class ExceptionTest2 {
    public static int method(){
        String s1 = "abc";
        try{
            Integer i1 = new Integer(s1);
            return 1;
        }catch (NumberFormatException e){
//            System.out.println("NumberFormatException.......");
//            System.out.println(e.getMessage());
//            System.out.println(e);
//            e.printStackTrace();
            String[] s = null;
            System.out.println(s[0]);
            return 2;
        }catch (Exception e){
        }finally {
            System.out.println("out1...");
        }
        return 0;
    }
    public static void main(String[] args) throws Exception {
        boolean f =true;
        if(f){
            //throw new RuntimeException("f == true");//运行时异常不需要显示处理
            throw new Exception("f exception");//包含编译异常需要显示处理[throws/try-catch-finally]
        }
        System.out.println(method());
        String s1 = "abc";
        try{
            Integer i1 = new Integer(s1);
        }catch (NumberFormatException e){
            System.out.println("NumberFormatException.......");
            System.out.println(e.getMessage());
            System.out.println(e);
//            e.printStackTrace();
        }catch (Exception e){

        }finally {
            System.out.println("out1...");
        }

        System.out.println("out2...");
    }
}
