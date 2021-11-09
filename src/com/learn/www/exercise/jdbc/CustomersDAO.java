package com.learn.www.exercise.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

//此接口用于规范针对于customers表的常用操作
public interface CustomersDAO {
    /**
     * @param conn
     * @param cust
     * @Description 将Customer对象添加到数据库中
     */
    public abstract void insert(Connection conn, Customer cust);

    /**
     * @param conn
     * @param id
     * @Description 针对指定的id，册除表中的一条记录
     */
    void deleteById(Connection conn, int id);

    /**
     * @param conn
     * @param cust
     * @Description 针对内存中的cust对象，去修改数据表中指定的记录
     */
    void updateById(Connection conn, Customer cust);

    /**
     * @param conn
     * @param id
     * @Description 针对指定的id查询得到对应的Customer对象
     */
    List<Customer> getCustomerById(Connection conn, int id);

    /**
     * @param conn
     * @return
     * @Description 查询表中的所有记录构成的集合
     */
    List<Customer> getAll(Connection conn);

    /**
     * @param conn
     * @return
     * @Description 返回数据表中的数据的条目数
     */
    Long getCount(Connection conn);

    /**
     * @param conn
     * @return
     * @Description 返回数据表中最大的生日
     */
    Date getMaxBirth(Connection conn);

}
