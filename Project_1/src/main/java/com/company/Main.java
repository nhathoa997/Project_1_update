package com.company;

import com.company.data.dao.EmpRepositoryImpl;
import com.company.models.EmployeeInfo;
import com.company.services.createEmployee;
import com.company.services.createManager;


import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("org.postgresql.Driver");
        //DriverManager.getConnection("jdbc:postgresql://henrydinh.cdrs9lfdhqu1.us-east-2.rds." +
                //"amazonaws.com:5432/henrydb?user=henry_dinh&password=Henry8354392.");
        EmpRepositoryImpl repository = new EmpRepositoryImpl();
        //repository.updateRequestDate(5622779);
        repository.updateRequest(5622779,"Approved");
//        createManager newManager = new createManager();
//        newManager.create("Alfredo", "password");
//        createEmployee newEmployee  = new createEmployee(repository);
//        EmployeeInfo emp = newEmployee.create("Alfredo", "password");
//        emp.createRequest("Certification",350.5, repository);


    }
}
