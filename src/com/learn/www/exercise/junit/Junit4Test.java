package com.learn.www.exercise.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author lowo
 * @Email
 * @Date 2021/11/2
 * @Description JavaStart
 */
public class Junit4Test {
    //初始化方法:@Before
    //用于资源申请，所有测试方法在执行之前都会先执行该方法
    @Before
    public void before() {
        System.out.println("bef");
    }

    //释放资源方法:@After
    //在所有测试方法执行完后，都会自动执行该方法
    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void test() {
        int res = 2;
        System.out.println("test");
        //断言我断言这个的结果为3
        //  一般我们会使用断言操作来处理结果
        //  Assert.assertEquals(期望的结果,运算的结果);
        Assert.assertEquals(3,res);

    }
}
