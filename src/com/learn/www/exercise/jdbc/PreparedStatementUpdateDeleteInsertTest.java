package com.learn.www.exercise.jdbc;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @Author lowo
 * @Email
 * @Date 2021/10/30
 * @Description java or javascript
 */
public class PreparedStatementUpdateDeleteInsertTest {

    @Test
    public void testCommonUpdate() {
//        String sql = "delete from customers where id = ?";
//        update(sql,20);
        String sql = "update `order` set order_name = ? where order_id = ?";//如果表名,字段名...名字为MySQL关键字则要用 `` 将它包起来 否则MySQL会报错
        CommonUpdate(sql, "order", "2");//值为关键字则不用 `` 将它包起来
    }

    //通用的增删改操作
    public void CommonUpdate(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn, ps);
        }
    }


    //修改customers表的一条记录
    @Test
    public void testUpdate() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //用自己写的MyJDBCUtils工具类
            //1.获取数据库的连接
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            //2.预编译sql语句，返回PreparedStatement的实例
            String sql = "update customers set name = ? where id = ?";//?为占位符 //末尾可以加;  也可以不加;
            //3.填充占位符
            ps = conn.prepareStatement(sql);
            //ps.setString(1, "中文2");
            ps.setObject(1, "中文1");//可以用setObject替代特定类型
            //ps.setInt(2, 20);
            ps.setObject(2, 19);//可以用setObject替代特定类型
            //4.执行
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            MyJDBCUtils.closeResource(conn, ps);
        }
    }

    //向customers表中添加一条记录
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.读取配置文件中的4个基本信息
            //InputStream is = ConnectionTest.class.getResourceAsStream("jdbc.properties");//与ConnectionTest类同目录开始找
            InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("com/learn/www/exercise/jdbc/jdbc.properties");//从src目录下开始找,因为用的是类的加载器
            Properties prop = new Properties();
            prop.load(is);
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            String driverClass = prop.getProperty("driverClass");
            //2.加载驱动
            Class.forName(driverClass);
            //3.获取连接
            conn = DriverManager.getConnection(url, user, password);
//        System.out.println("conn = " + conn);
            String sql = "insert into customers(name, email, birth) values (?,?,?)";//?为占位符 //末尾可以加;  也可以不加;
            ps = conn.prepareStatement(sql);
            //5.填充占位符
            ps.setString(1, "中文");//索引从1开始
            ps.setString(2, "zhongwen@qq.com");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse("1000-2-2");
            ps.setDate(3, new java.sql.Date(parse.getTime()));
            //6.执行操作
            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            //7.资源的关闭
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
