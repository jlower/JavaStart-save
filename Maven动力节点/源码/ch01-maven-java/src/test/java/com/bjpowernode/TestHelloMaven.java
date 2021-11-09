package com.bjpowernode;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class TestHelloMaven {

    @Test
    public void testAddNumber1(){
        System.out.println("testAddNumber1111111111111111");
        HelloMaven hello = new HelloMaven();
        int res  = hello.addNumber(10,20);
        Assert.assertEquals(30, res);
    }

    @Test
    public void testAddNumber2(){
        System.out.println("testAddNumber22222222222222222");
        HelloMaven hello = new HelloMaven();
        int res  = hello.addNumber(10,20);
        Assert.assertEquals(30, res);
    }
}
