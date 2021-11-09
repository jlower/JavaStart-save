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

public class TransactionTest {
    //1.什么叫数据库事务?
    //  事务:一组逻辑操作单元,使数据从一种状态变换到另—种状态。
    //      >一组逻辑操作单元:一个或多个DML操作。
    //2.事务处理的原则:保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。
    //  当在一个事务中执行多个操作时，要么所有的事务都被提交(commit)，那么这些修改就永久地保存下来，
    //  要么数据库管理系统将放弃所作的所有修改，整个事务回滚(rollback)到最初状态。
    //3.数据一旦提交，就不可回滚
    //4.哪些操作会导致数据的自动提交?
    //  >DDL操作一旦执行，都会自动提交。
    //      >set autocommit = false 对DDL操作失效
    //  >DML默认情况下，一旦执行，就会自动提交。
    //      >我们可以通过set autocommit = false的方式取消DML操作的自动提交。   setAutoCommit(false);
    //  >默认在关闭连接时，会自动提交数据


    //针对于数据表user_table来说: AA用户给BB用户转账100
    //考虑数据库事务后的转账操作
    @Test
    public void testTransactionUpdate() {
        Connection conn = null;
        try {
            //1.获取数据库的连接
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            //取消数据的自动提交
            conn.setAutoCommit(false);
            String sql1 ="update user_table set balance = balance - 100 where user = ?";
            CommonUpdateWithTransaction(conn, sql1, "AA");
//            System.out.println(10/0); //模拟报错 网络连接断开 事务数据没提交全
            String sql2 ="update user_table set balance = balance + 100 where user = ?";
            CommonUpdateWithTransaction(conn, sql2, "BB");
            //提交数据
            conn.commit();
        } catch (Exception e) {//抓到所有错误 [有错就要回滚]
            try {
                //3.回滚数据
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            //修改其为自动提交数据
            //主要针对于使用数据库连接池的使用
            try {
                conn.setAutoCommit(true);//用数据连接池时链接不会关闭 只是放回数据连接池中 要将连接恢复原样 保证下一次调用时是连接的默认初始状态
            } catch (SQLException e) {
                e.printStackTrace();
            }
            MyJDBCUtils.closeResource(conn);
        }
    }

    @Test
    public void testTransactionQuery() {
        Connection conn = null;
        try {
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            //获取当前连接的隔离级别
            System.out.println("conn.getTransactionIsolation() = " + conn.getTransactionIsolation());
            //设置数据库的隔离级别
            //conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);//TRANSACTION_SERIALIZABLE  有几个常量
            //服务器服务重启后会自动变回默认的隔离级别

            String sql = "select user ,password , balance from user_table where user = ?";
            ArrayList<User> user = commonQueryWithTransaction(conn, User.class, sql, "CC");
            System.out.println("user = " + user);
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

//    @Test
//    public void testTransactionIsolation() {
//        Connection conn = null;
//        try {
//            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
//            String sql = "update user_table set balance = ? where user = ?";
//            CommonUpdateWithTransaction(conn, sql, 5000, "CC");
//            Thread.sleep(15000);
//            System.out.println("修改结束");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            MyJDBCUtils.closeResource(conn);
//        }
//    }

    //通用的查询操作,用于返回数据表中的一条记录[考虑事务]
    public <T> ArrayList<T> commonQueryWithTransaction(Connection conn, Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
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
        } catch (SQLException e) {
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
            MyJDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }

    //通用的增删改操作[返回成功操作几条数据,失败则返回0]
    public int CommonUpdateWithTransaction(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            MyJDBCUtils.closeResource(ps);
        }
        return 0;
    }
}
