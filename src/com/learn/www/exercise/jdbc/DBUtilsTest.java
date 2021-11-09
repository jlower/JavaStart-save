package com.learn.www.exercise.jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author lowo
 * @Email
 * @Date 2021/11/1
 * @Description java or javascript
 */

//Apache-DBUtils实现CRUD操作
    //  QueryRunner
//commons -dbutils 是Apache 组织提供的一个开源JDBC工具类库,封装了针对于数据库的增删改查操作
public class DBUtilsTest {

    //测试插入
    @Test
    public void testInsert() throws SQLException {
        //QueryRunner
        QueryRunner runner = new QueryRunner();
        Connection conn = MyJDBCUtilsWithDruidDataSource.getConnection();
        String sql = "insert into customers(name, email, birth) VALUES (?,?,?)";
        int insertCount = runner.update(conn, sql, "蔡徐坤", "caixukun@126.com", "97-09/8");
        // "97-09/8" = "1997-09-08"
        //返回影响了几条数据
        System.out.println("insertCount = " + insertCount);
    }

    //测试查询
    //BeanHandler:是ResultSetHandler接口的实现类，用于封装表中的一条记录。
    @Test
    public void testQueryBeanHandler() {
        Connection conn = null;
        try {
            //QueryRunner
            QueryRunner runner = new QueryRunner();
            conn = MyJDBCUtilsWithDruidDataSource.getConnection();
            String sql = "select id,name,birth from customers where id = ?";
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
            Customer customer = runner.query(conn, sql, handler, 13);
            System.out.println("customer = " + customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    //BeanListHandler:是ResultSetHandler接口的实现类，用于封装表中的多条记录构成的集合。
    @Test
    public void testQueryBeanListHandler() throws SQLException {
        Connection conn = null;
        try {
            //QueryRunner
            QueryRunner runner = new QueryRunner();
            conn = MyJDBCUtilsWithDruidDataSource.getConnection();
            String sql = "select id,name,birth from customers where id < ?";
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
            List<Customer> customers = runner.query(conn, sql, handler, 13);
            customers.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    //MapHandler:是ResultSetHandler接口的实现类，对应表中的一条记录。
    //  将字段及相应字段的值作为map中的key和value
    @Test
    public void testQueryMapHandler() {
        Connection conn = null;
        try {
            //QueryRunner
            QueryRunner runner = new QueryRunner();
            conn = MyJDBCUtilsWithDruidDataSource.getConnection();
            String sql = "select id,name,birth from customers where id = ?";
            MapHandler handler = new MapHandler();
            Map<String, Object> map = runner.query(conn, sql, handler, 13);
            System.out.println("map = " + map);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    //MapListHandler:是ResultSetHandler接口的实现类，对应表中的多条记录。
    //  将字段及相应字段的值作为map中的key和value。将这些map添加到List中
    @Test
    public void testQueryMapListHandler() {
        Connection conn = null;
        try {
            //QueryRunner
            QueryRunner runner = new QueryRunner();
            conn = MyJDBCUtilsWithDruidDataSource.getConnection();
            String sql = "select id,name,birth from customers where id < ?";
            MapListHandler handler = new MapListHandler();
            List<Map<String, Object>> mapList = runner.query(conn, sql, handler, 13);
            mapList.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    //ScalarHandler:用于查询特殊值
    @Test
    public void testQueryScalarHandler() {
        Connection conn = null;
        try {
            //QueryRunner
            QueryRunner runner = new QueryRunner();
            conn = MyJDBCUtilsWithDruidDataSource.getConnection();
            String sql = "select count(*) from customers";
            ScalarHandler handler = new ScalarHandler();
            Long count = (Long) runner.query(conn, sql, handler);//返回Object要强转才能赋值给Long型
            System.out.println("count = " + count);
            sql = "select max(birth) from customers";
            Date maxBirth = (Date) runner.query(conn, sql, handler);//返回Object要强转才能赋值给Long型
            System.out.println("maxBirth = " + maxBirth);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    //自定义ResultSetHandler的实现类
    @Test
    public void testQueryByMyResultSetHandler() {
        Connection conn = null;
        try {
            //QueryRunner
            QueryRunner runner = new QueryRunner();
            conn = MyJDBCUtilsWithDruidDataSource.getConnection();
            String sql = "select id,name,birth from customers where id = ?";
            ResultSetHandler<Customer> handler = new ResultSetHandler<Customer>() {
                @Override
                public Customer handle(ResultSet resultSet) throws SQLException {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        Date birth = resultSet.getDate("birth");
                        Customer customer = new Customer();
                        customer.setBirth(birth);
                        customer.setId(id);
                        customer.setName(name);
                        return customer;
                    }
                    return null;
                }
            };
            Customer customer = runner.query(conn, sql, handler, 13);
            System.out.println("customer = " + customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

}
