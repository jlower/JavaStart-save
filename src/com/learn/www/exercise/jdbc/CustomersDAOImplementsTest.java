package com.learn.www.exercise.jdbc;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

//自动生成测试,自己写里面的测试
class CustomersDAOImplementsTest {

    private CustomersDAOImplements dao = new CustomersDAOImplements();

    @Test
    void insert() {
        Connection conn = null;
        try {
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            Customer cust = new Customer(1,"于小飞", "xiaofei@126.com", new Date(43534646435L));
            dao.insert(conn, cust);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void getAll() {
        Connection conn = null;
        try {
            conn = MyJDBCUtilsWithDruidDataSource.getConnection();//用Druid数据库连接技术写的获得链接的方法

            //conn = MyJDBCUtilsWithDBCPDataSource.getConnection();//用DBCP数据库连接技术写的获得链接的方法
            //conn = MyJDBCUtilsWithC3P0DataSource.getConnection();//用C3P0数据库连接技术写的获得链接的方法
            //conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            List<Customer> list = dao.getAll(conn);
            list.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    @Test
    void getCount() {
    }

    @Test
    void getMaxBirth() {
    }
}