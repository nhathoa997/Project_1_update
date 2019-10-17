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
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        createManager new_mang = new createManager();
        new_mang.create("David Beckam", "password");
    }
}
