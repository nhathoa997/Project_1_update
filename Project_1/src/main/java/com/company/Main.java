package com.company;

import com.company.FileIO.WriteToJSON;
import com.company.data.dao.EmpRepositoryImpl;
import com.company.models.EmployeeInfo;
import com.company.services.Authenticate;
import com.company.services.createEmployee;
import com.company.services.createManager;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        EmpRepositoryImpl dao = new EmpRepositoryImpl();
//        createEmployee newEmp = new createEmployee(dao);
//        EmployeeInfo emp = newEmp.create("Minamoto", "password");
//        emp.createRequest("Certify",700.25,dao);
//        emp.createRequest("Travel",850.56,dao);
//        emp.createRequest("Travel",960.56,dao);
//        WriteToJSON write = new WriteToJSON();
//        write.write(emp);
        Authenticate auth = new Authenticate();
        System.out.println(auth.authenticate("Takeda Shingen","password",  "employee"));
    }
}
