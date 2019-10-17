package com.company.data.dao;

import com.company.Models.AccountInfo;
import com.company.data.UserRepository;

import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Collection;

public class UserRepositoryImpl implements UserRepository  {
    private AccountInfo user;
    private Connection conn = DriverManager.getConnection("jdbc:postgresql://henrydinh.cdrs9lfdhqu1.us-east-2.rds.amazonaws.com:5432/henrydb?user=henry_dinh&password=Henry8354392.");;

    public UserRepositoryImpl() throws ClassNotFoundException, SQLException {
        try{
            //Class.forName("org.postgresql.Driver");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF not EXISTS UserAccount(UserName TEXT,Password TEXT, Balance REAL, ID INTEGER) ");
            statement.execute("CREATE TABLE IF not EXISTS UserTransaction(UserName TEXT,Type TEXT,Date TEXT, Amount REAL, ID INTEGER) ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AccountInfo findUserName(String userName) {
        String sql = "SELECT * from UserAccount where Username = '" + userName + "'";
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);

            ResultSet results = statement.getResultSet();
            if (results.next()){
                user = new AccountInfo(results.getString("UserName"), results.getString("Password"),
                        results.getDouble("Balance"), results.getInt("ID"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public AccountInfo findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<AccountInfo> findAll() {
        return null;
    }

    @Override
    public void save(AccountInfo user) {
        try{
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO UserAccount VALUES ('" + user.getUserName()
                    + "', '" + user.getPassword() + "', " + user.getBalance() + ", " + user.getAccountID() + ")";
            statement.execute(sql);
            statement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void saveTransaction(AccountInfo user, String type){
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String valnow = formatter.format(date);
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO UserTransaction VALUES ('" + user.getUserName()
                    + "', '" + type + "', '" + valnow + "', " + user.getDifference() +  ", "+ user.getAccountID()+ ")";
            statement.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewHistory(String userName) throws SQLException {
        String sql = "Select * from UserTransaction where UserName = '" + userName + "'";
        Statement statement = conn.createStatement();
        statement.execute(sql);
        ResultSet results = statement.getResultSet();
        while(results.next()){
            System.out.println("[ID: "+results.getInt("id")+". Transaction Type: " + results.getString("type") + ". Amount: $"
                    + results.getDouble("amount") + ". Date: " + results.getString("date")+ "]");
        }


    }
    public void update(AccountInfo user) throws SQLException {
        String sql = "UPDATE UserAccount SET Balance = " + user.getBalance() + " WHERE UserName = '" + user.getUserName()
                + "'";
        Statement statement = conn.createStatement();
        statement.execute(sql);

    }
    @Override
    public void delete(String userName) {
        String sql = "DELETE FROM UserAccount WHERE UserName = '" + userName + "'";
        String sql2 = "DELETE FROM UserTransaction WHERE UserName = '" + userName + "'";
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute(sql);
            statement.execute(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Row(s) deleted");
    }
}

