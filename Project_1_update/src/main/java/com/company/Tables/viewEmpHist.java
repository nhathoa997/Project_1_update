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
    private static int count = 0;
    private static String user_name;
    public static String viewTable(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        count ++;
        if (count%2 == 1){
            user_name = request.getParameter("user_name");
        }
        System.out.println("Hey I was at view emp history");
        System.out.println(user_name);
        EmpRepositoryImpl dao = new EmpRepositoryImpl();
        EmployeeInfo user = dao.findUserName(user_name);
        List<reimbursement> reims = user.getReimbursementID();
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(reims));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/manager/mangemployeerq.html";
    }
}
