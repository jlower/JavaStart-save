package com.learn.www.exercise.jdbc;

import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author lowo
 * @Email
 * @Date 2021/10/31
 * @Description java or javascript
 */
public class MultipleInsertTest {
    //使用PreparedStatement实现批量数据的操作
    //update delete本身就具有批量操作的效果。
    //此时的批量操作，主要指的是批量插入。使用PreparedStatement如何实现更高效的批量插入?
    //向goods表中插入20000条数据
    //CREATE TABLE goods(
    //  id INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(25)
    //);

    //批量插入方式一:使用Statement[不好]
    //Connection conn = JDBCUtils.getConnection();
    //Statement st =conn.createStatement();
    //for(int i = 1;i <= 200ee ;i++){
    //  String sql = "insert into goods(name)values( 'name_" + i + "')";
    //  st.execute(sql);
    //}

    //批量插入的方式四: 设置不允许自动提交数据  conn.setAutoCommit(false);  最后统一提交  conn.commit();
    //      最高效 用这种写法
    @Test
    public void testInsert3() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            String sql = "insert into goods(name) values(?)";//写SQL语句最好不要加 ; 否则批量拼接处理时会报错  [不加 ; 普通写也不会报错] {记住不加 ; }
            ps = conn.prepareStatement(sql);
            //设置不允许自动提交数据
            conn.setAutoCommit(false);
            for (int i = 1; i <= 2001000; i++) {
                ps.setObject(1, "name_" + i);
                //1."攒"sql
                ps.addBatch();
                if (i % 5000 == 0) {
                    //2.执行batch
                    ps.executeBatch();
                    //3.清空batch
                    ps.clearBatch();
                }
                if (i == 2001000) {//最后一次要将其提交
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            //提交数据
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
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

    //批量插入方式二:使用PreparedStatement
    @Test
    public void testInsert1() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            String sql = "insert into goods(name) values(?)";//3.写SQL语句最好不要加 ; 否则批量拼接处理时会报错  [不加 ; 普通写也不会报错] {记住不加 ; }
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < 20000; i++) {
                ps.setObject(1, "name_" + i);
                ps.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
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

    //批量插入的方式三:
    //1.addBatch()、executeBatch()、clearBatch()
    //2.mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。[新版也要加]
    //      ?rewriteBatchedStatements=true写在配置文件的url后面
    //3.写SQL语句最好不要加 ; 否则批量拼接处理时会报错  [不加 ; 普通写也不会报错] {记住不加 ; }
    //4.使用新的mysql驱动: mysql-connector-java-5.1.37-bin.jar
    @Test
    public void testInsert2() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            String sql = "insert into goods(name) values(?)";//写SQL语句最好不要加 ; 否则批量拼接处理时会报错  [不加 ; 普通写也不会报错] {记住不加 ; }
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 2001000; i++) {
                ps.setObject(1, "name_" + i);
                //1."攒"sql
                ps.addBatch();
                if (i % 500 == 0) {//500次语句合成后将其提交一次
                //2.执行batch
                    ps.executeBatch();
                //3.清空batch
                    ps.clearBatch();
                }
                if (i == 2001000) {//最后一次要将其提交
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
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
}
