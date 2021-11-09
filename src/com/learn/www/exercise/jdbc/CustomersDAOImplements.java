package com.learn.www.exercise.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @Author lowo
 * @Email
 * @Date 2021/10/31
 * @Description java or javascript
 */

//ctrl+shift+t新建测试方法
//或者选中代码 右键 Go To -> Test 来新建测试方法
public class CustomersDAOImplements extends BaseDAO<Customer> implements CustomersDAO{
    @Override
    public void insert(Connection conn, Customer cust) {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        CommonUpdateFinal(conn, sql, cust.getName(), cust.getEmail(), cust.getBirth());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        CommonUpdateFinal(conn, sql, id);
    }

    @Override
    public void updateById(Connection conn, Customer cust) {
        String sql = "update customers set name = ? ,email = ? ,birth = ? where id = ?";
        CommonUpdateFinal(conn, sql, cust.getName(), cust.getEmail(), cust.getBirth(), cust.getId());
    }

    @Override
    public List<Customer> getCustomerById(Connection conn, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        List<Customer> customers = commonQueryFinal(conn, sql, id);
        return customers;
    }

    @Override
    public List<Customer> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        List<Customer> list = commonQueryFinal(conn, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from customers" ;
        return getValueFinal(conn, sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select max(birth) from customers";
        return getValueFinal(conn, sql);
    }
}
