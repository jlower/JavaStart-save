package com.learn.www.exercise.jdbc;

import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * @Author lowo
 * @Email
 * @Date 2021/10/31
 * @Description java or javascript
 */
public class BlobTest {

    //查询数据表customers中Blob类型的字段
    @Test
    public void testQuery() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            String sql = "select photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 22);
            rs = ps.executeQuery();
            if (rs.next()) {
                //将Blob类型的字段下载下来，以文件的方式保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\jdbc\\photo.jpg");
                byte[] buffer = new byte[1024];
                int len = is.read(buffer);
                while (len != -1) {
                    fos.write(buffer, 0, len);
                    len = is.read(buffer);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            MyJDBCUtils.closeResource(conn, ps, rs);
        }

    }

    //向数据表customers中插入Blob类型的字段
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream is = null;
        try {
            conn = MyJDBCUtils.getConnectionByProperties("com/learn/www/exercise/jdbc/jdbc.properties");
            String sql = "insert into customers(name, email, birth, photo) VALUES (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "tt");
            ps.setObject(2, "tt@gmai.com");
            ps.setObject(3, "2100-07-14");
//            is = new FileInputStream(new File("D:\\LOWO\\JavaLearn\\JavaStart\\src\\com\\learn\\www\\exercise\\io\\try_1.png"));
            is = new FileInputStream(new File("D:\\LOWO\\图\\桌面93130508_p1.png"));
            ps.setBlob(4, is);
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            MyJDBCUtils.closeResource(conn, ps);
        }
    }
}
