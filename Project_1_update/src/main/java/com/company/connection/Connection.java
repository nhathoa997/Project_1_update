package com.company.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static java.sql.Connection conn;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://henrydinh.cdrs9lfdhqu1.us-east-2.rds." +
                        "amazonaws.com:5432/henrydb?user=henry_dinh&password=Henry8354392.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ;


}
