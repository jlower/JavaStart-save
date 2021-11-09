package com.learn.www.exercise.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author lowo
 * @Email
 * @Date 2021/11/1
 * @Description java or javascript
 */
//不常用
public class C3P0Test {
    @Test
    public void testGetConnection1() throws SQLException, PropertyVetoException {
        //获取C3P0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver"); //loads the jdbc driver
        cpds.setJdbcUrl("jdbc:mysql:///test");
        //链接本地机器可以省略 localhost:3306  不用  jdbc:mysql://localhost:3306/test
        cpds.setUser("root");
        cpds.setPassword("xrj343114");
        //通过设置相关的参数，对数据库连接池进行管理;
        //设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);
        Connection conn = cpds.getConnection();
        System.out.println("conn = " + conn);
        //销毁C3P0数据库连接池
//        DataSources.destroy(cpds);
    }

    //方式二: 使用配置文件
    //c3p0-config.xml配置文件名字不能改
    //c3p0-config.xml配置文件必须放在当前工程的src目录下
    @Test
    public void testGetConnection2() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("MyC3P0");//自定义的名字
        Connection conn = cpds.getConnection();
        System.out.println("conn = " + conn);
    }
}
