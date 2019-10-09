package com.company.Tables;

import com.company.data.dao.EmpRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class viewPendingTable {
    public static String viewTable(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        EmpRepositoryImpl dao = new EmpRepositoryImpl();
        System.out.println("Hey I was at view pending table");
        List<List> pending_lst = dao.viewPendingList();
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(pending_lst));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/manager/mangpendingl.html";
    }
}
