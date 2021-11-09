package com.learn.www.exercise.jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;

/**
 * @Author lowo
 * @Email
 * @Date 2021/10/31
 * @Description java or javascript
 */

//DAO:data(base) access object
//封装了针对于数据表的通用的操作   abstract class
public abstract class BaseDAO<T> {
    private Class<T> clazz = null;
    {
        //获取当前BaseDAO的子类继承的父类BaseDAO中的泛型<T>
        Type genericSuperclass = this.getClass().getGenericSuperclass();//获取了父类的范形
        //这里的this是 new子类对象时 子类的this并非此类的this //此类是abstract类并不会new
        //new子类对象时先执行其父类的这段代码块 执行时这里的this代表子类

        ParameterizedType paramType = (ParameterizedType) genericSuperclass;//参数化获取的范形
        Type[] typeArguments = paramType.getActualTypeArguments();//获取了父类的范形参数
        clazz = (Class<T>) typeArguments[0];//泛型的第一个参数
    }
    //用于查询特殊值的通用的方法
    public <T> T getValueFinal(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                return (T) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }

    //通用的查询操作,用于返回数据表中的一条记录[考虑事务]
    public <T> ArrayList<T> commonQueryFinal(Connection conn, String sql, Object... args) {
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
                T t = (T) clazz.getDeclaredConstructor().newInstance();
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
    public int CommonUpdateFinal(Connection conn, String sql, Object... args) {
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
