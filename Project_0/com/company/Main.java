package com.company;

import com.company.data.dao.UserRepositoryImpl;

import java.sql.SQLException;

public class Main {
    static String bankTitle =  "Loanly Peoples Credit Union";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        Application app = new BankApplication();
//        app.setTitle(bankTitle);
//        app.run(args);
        UserRepositoryImpl dao = new UserRepositoryImpl();

    }
}
