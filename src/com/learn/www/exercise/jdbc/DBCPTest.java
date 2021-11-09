package com.learn.www.exercise.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author lowo
 * @Email
 * @Date 2021/11/1
 * @Description java or javascript
 */

//测试DBCP的数据库连接池技术
//不常用
public class DBCPTest {
    @Test
    public void testGetConnection1() throws SQLException {
        //创建了DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();

        //设置基本信息
        source.setPassword("xrj343114");
        source.setUsername("root");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");

        //还可以设置其他涉及数据库连接池管理的相关属性:
        source.setInitialSize(10);
        source.setMaxTotal(10);

        Connection conn = source.getConnection();
        System.out.println("conn = " + conn);
    }

    //方式二:使用配置文件
    @Test
    public void testGetConnection2() {
        FileInputStream is = null;
        try {
            Properties pros = new Properties();
            //方式1:
            //InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("com/learn/www/exercise/jdbc/dbcp.properties");
            //方式2:
            is = new FileInputStream("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\jdbc\\dbcp.properties");
            pros.load(is);
            BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(pros);
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
