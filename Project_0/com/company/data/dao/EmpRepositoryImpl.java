package com.company.data.dao;

import com.company.Models.EmployeeAccount;
import com.company.data.EmpRepository;

import java.sql.*;
import java.util.Collection;

public class EmpRepositoryImpl implements EmpRepository {
    private EmployeeAccount user;
    private Connection conn;

    {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://henrydinh.cdrs9lfdhqu1.us-east-2.rds.amazonaws.com:5432/henrydb?user=henry_dinh&password=Henry8354392.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EmpRepositoryImpl() {
        try{
            //Class.forName("org.postgresql.Driver");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF not EXISTS EmpAccount(UserName TEXT,Password TEXT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public EmployeeAccount findUserName(String userName) {
        String sql = "SELECT * from EmpAccount where Username = '" + userName + "'";
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);

            ResultSet results = statement.getResultSet();
            if (results.next()){
                user = new EmployeeAccount(results.getString("UserName"), results.getString("Password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeeAccount findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<EmployeeAccount> findAll() {
        return null;
    }

    @Override
    public void save(EmployeeAccount user) {
        try{
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO EmpAccount VALUES ('" + user.getUserName()
                    + "', '" + user.getPassword() + "'" + ")";
            statement.execute(sql);
            statement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String userName) {
        String sql = "DELETE FROM EmpAccount WHERE UserName = '" + userName + "'";
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Row(s) deleted");
    }
}
