package com.learn.www.exercise.map;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author lowo
 * 2021/10/21->13:20
 */
public class PropertiesTest {

    @Test
    public void test1(){
        FileInputStream fis = null;

        try {
            Properties pros = new Properties();
            fis = new FileInputStream("test.properties");
            pros.load(fis);
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            String password1 = pros.getProperty("password1");
            System.out.println("password1 = " + password1);
            System.out.println("password = " + password);
            System.out.println("name = " + name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
