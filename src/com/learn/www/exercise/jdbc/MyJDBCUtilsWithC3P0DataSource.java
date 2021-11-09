package com.learn.www.exercise.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author lowo
 * @Email
 * @Date 2021/11/1
 * @Description java or javascript
 */
//不常用
public class MyJDBCUtilsWithC3P0DataSource {

    //只造一个数据连接池
    //数据库连接池只需提供一个即可 用static以后都调用这个
    static ComboPooledDataSource cpds = new ComboPooledDataSource("MyC3P0");//自定义的名字
    public static Connection getConnection() throws SQLException {
        Connection conn = cpds.getConnection();
        return conn;
    }
}
