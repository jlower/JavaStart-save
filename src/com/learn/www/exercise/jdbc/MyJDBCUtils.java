package com.learn.www.exercise.jdbc;

import org.apache.commons.dbutils.DbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author lowo
 * @Email
 * @Date 2021/10/30
 * @Description java or javascript
 */
public class MyJDBCUtils {
    public static Connection getConnectionByProperties(String str) throws ClassNotFoundException, SQLException, IOException {
        //1.读取配置文件中的4个基本信息
        //InputStream is = ConnectionTest.class.getResourceAsStream("jdbc.properties");//与ConnectionTest类同目录开始找
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream(str);//从src目录下开始找,因为用的是类的加载器
        Properties prop = new Properties();
        prop.load(is);
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String driverClass = prop.getProperty("driverClass");
        //2.加载驱动
        Class.forName(driverClass);
        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    //使用dbutils.jar包中提供的DbUtils工具类，实现资源的关闭
    public static void closeResourceByDbUtils(Connection conn, Statement ps, ResultSet resultSet) {
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(resultSet);
//        try {
//            DbUtils.close(conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DbUtils.close(ps);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DbUtils.close(resultSet);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public static void closeResource(Statement ps) {
        //7.资源的关闭
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection conn) {
        //7.资源的关闭
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, Statement ps) {
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

    public static void closeResource(Connection conn, Statement ps , ResultSet resultSet) {
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
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
