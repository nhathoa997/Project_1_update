package com.company.Tables;

import com.company.data.dao.EmpRepositoryImpl;
import com.company.models.EmployeeInfo;
import com.company.models.reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class viewEmpHist {
    public static String viewTable(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        EmpRepositoryImpl dao = new EmpRepositoryImpl();
        EmployeeInfo user = dao.findUserName(request.getParameter("user_name"));
        List<reimbursement> reims = user.getReimbursementID();
        System.out.println("Hey I was at view emp history");
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(reims));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/manager/mangemployeerq.html";
    }
}
