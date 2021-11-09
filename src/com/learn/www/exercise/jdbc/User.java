package com.learn.www.exercise.jdbc;

/**
 * @Author lowo
 * @Email
 * @Date 2021/10/31
 * @Description java or javascript
 */
public class User {
    private String user;
    private String password;
    private int balance;

    public User() {
    }

    public User(String user, String password, int balance) {
        this.user = user;
        this.password = password;
        this.balance = balance;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String toString() {
        return "User [user=" + this.user + ", password=" + this.password + ", balance=" + this.balance + "]";
    }
}
