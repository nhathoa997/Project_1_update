package com.company.Tables;

import com.company.data.dao.EmpRepositoryImpl;
import com.company.models.EmployeeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class viewEmployeesTable {
    public static String viewTable(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        EmpRepositoryImpl dao = new EmpRepositoryImpl();
        System.out.println("Hey I was at view emp table");
        List<String> emps = dao.findEmpNames();
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(emps));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/manager/mangemployees.html";
    }
}
