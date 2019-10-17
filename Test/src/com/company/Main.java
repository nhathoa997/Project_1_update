package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://henrydinh.cdrs9lfdhqu1.us-east-2.rds." +
                "amazonaws.com:5432/henrydb?user=henry_dinh&password=Henry8354392.");
    }
}
