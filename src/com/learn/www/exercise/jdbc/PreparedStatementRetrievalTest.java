package com.learn.www.exercise.jdbc;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

/**
 * @Author lowo
 * @Email
 * @Date 2021/10/31
 * @Description java or javascript
 */
public class PreparedStatementRetrievalTest {

    //ps.execute():
    //如果执行的是查询操作，有返回结果，则此方法返回true;
    //如果执行的是增、删、改操作，没有返回结果，则此方法返回false;

    //PreparedStatement预编译订好了语句的逻辑，之后再插入的数据不能改变原始语句的逻辑
    //除了解决Statement的拼串、sql注入问题之外，PreparedStatement还有哪些好处呢?
    //1.PreparedStatement操作Blob的数据，而Statement做不到。
    //2.PreparedStatement可以实现更高效的批量操作。

    @Test
    public void testCommonQuery() {
        String sql = "select id,name,birth,email from customers where id < ?";
        ArrayList<Customer> customer = commonQuery(Customer.class, sql, 13);
        customer.forEach(System.out::println);

        sql = "select name , email from customers where name != ?";//没查的字段赋的是空参构造器给的默认值
        ArrayList<Customer> customer1 = commonQuery(Customer.class, sql, "周杰伦");
        System.out.println(customer1);
    }

    public <T> ArrayList<T> commonQuery(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount =rsmd.getColumnCount();
            //创建集合对象
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                //处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object value = rs.getObject(i + 1);
                    //获取列的列名:getColumnName()  -->  不推荐使用
                    //String columnName = rsmd.getColumnName(i + 1);

                    //获取列的别名:getColumnLabel()  -->  推荐,有别名则返回别名;无别名,则返回列名
                    //别名的SQL语法是  Xxx as Xx / Xxx Xx 将Xxx命名为别名Xx
                    //再写sql语句时命名别名 使列的别名与Class中的属性名相同
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //给customer对象指定的columnName属性，赋值为columnValue:  通过反射
                    Field field = t.getClass().getDeclaredField(columnLabel);//clazz / t.getClass()
                    field.setAccessible(true);
                    field.set(t, value);
                }
                list.add(t);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }

    @Test
    public void testQueryForCustomer() {
        String sql = "select id,name,birth,email from customers where id = ?";
        ArrayList<Customer> customer = queryForCustomer(sql, 13);
        System.out.println(customer);

        sql = "select name , email from customers where name = ?";//没查的字段赋的是空参构造器给的默认值
        ArrayList<Customer> customer1 = queryForCustomer(sql, "周杰伦");
        System.out.println(customer1);
    }

    //针对于表的字段名与类的属性名不相同的情况:
    //1.必须声明sql时，使用类的属性名来命名字段的别名
    //2.使用ResultSetMetaData时,需要使用getColumnLabel()来替换getColumnName()获取列的别名。
    //  说明:如果sql中没有给字段其别名，getColumnLabel()获取的就是列名
    //别名的SQL语法是  Xxx as Xx / Xxx Xx 将Xxx命名为别名Xx
    //再写sql语句时命名别名 使列的别名与Class中的属性名相同
    public ArrayList<Customer> queryForCustomer(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount =rsmd.getColumnCount();
            ArrayList<Customer> list = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer();
                //处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object value = rs.getObject(i + 1);
                    //获取列的列名:getColumnName()  -->  不推荐使用
                    //String columnName = rsmd.getColumnName(i + 1);

                    //获取列的别名:getColumnLabel()  -->  推荐,有别名则返回别名;无别名,则返回列名
                    //别名的SQL语法是  Xxx as Xx / Xxx Xx 将Xxx命名为别名Xx
                    //再写sql语句时命名别名 使列的别名与Class中的属性名相同
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //给customer对象指定的columnName属性，赋值为columnValue:  通过反射
                    Field field = Customer.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(customer, value);
                }
                list.add(customer);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }

    @Test
    public void testQuery() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;//需要关闭
        Customer customer = null;
        try {
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            String sql = "select id,name,email,birth from customers where id = ?";
            ps = conn.prepareStatement(sql);
            //执行,并返回结果集
            ps.setObject(1,1);
            resultSet = ps.executeQuery();
            //处理结果集
            if (resultSet.next()) {//判断结果集的下一条是否有数据,如果有数据返回true,并指针下移;  如果返回false,指针不会下移。
                //获取当前这条数据的各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                //方式三:将数据封装为一个对象（推荐)
                customer = new Customer(id,name,email, birth);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn, ps, resultSet);
        }
//        System.out.println("customer = " + customer);
    }
}
