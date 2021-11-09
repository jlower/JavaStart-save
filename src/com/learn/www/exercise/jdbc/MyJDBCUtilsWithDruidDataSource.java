package com.learn.www.exercise.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
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
public class MyJDBCUtilsWithDruidDataSource {
    //使用Druid数据库连接池技术获取数据库连接
    private static DataSource source = null;
    static {
        FileInputStream is = null;
        try {
            Properties pros = new Properties();
            //方式1:
            //InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("com/learn/www/exercise/jdbc/dbcp.properties");
            //方式2:
            is = new FileInputStream("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\jdbc\\druid.properties");
            pros.load(is);
            source = DruidDataSourceFactory.createDataSource(pros);
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
    public static Connection getConnection() throws SQLException {
        Connection conn = source.getConnection();
        return conn;
    }
}
