package com.company.Tables;

import com.company.data.dao.EmpRepositoryImpl;
import com.company.data.dao.ManagerRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class viewResolvedTable {
    public static String viewTable(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ManagerRepositoryImpl dao = new ManagerRepositoryImpl();
        List<List> emps = dao.viewResolvedList();
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(emps));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/manager/mangapprovedl.html";
    }
}
