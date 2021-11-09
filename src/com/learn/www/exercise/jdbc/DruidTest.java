package com.learn.www.exercise.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author lowo
 * @Email
 * @Date 2021/11/1
 * @Description java or javascript
 */

//常用

public class DruidTest {

    @Test
    public void testGetConnection1() throws SQLException {
        InputStream is = null;
        try {
            //ctrl+h
            //DruidDataSource source = new DruidDataSource();
            Properties pros = new Properties();
            //方式1:
            is = ClassLoader.getSystemClassLoader().getResourceAsStream("com/learn/www/exercise/jdbc/druid.properties");
            //方式2:
            //FileInputStream is = new FileInputStream("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\jdbc\\druid.properties");
            pros.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);
            Connection conn = dataSource.getConnection();
            System.out.println("conn = " + conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
