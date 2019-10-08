package com.company.Tables;

import com.company.FileIO.WriteToJSON;
import com.company.data.dao.EmpRepositoryImpl;
import com.company.models.EmployeeInfo;
import com.company.models.reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewReimbursementTable {
    public static String viewTable(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        EmpRepositoryImpl dao = new EmpRepositoryImpl();
        EmployeeInfo user = (EmployeeInfo)request.getSession().getAttribute("User");
        List<reimbursement> reims = user.getReimbursementID();
//        WriteToJSON write = new WriteToJSON();
//        write.write(user);
        System.out.println("Hey I was at view table");
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(reims));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/employee/emplreimbrst.html";

    }
}
