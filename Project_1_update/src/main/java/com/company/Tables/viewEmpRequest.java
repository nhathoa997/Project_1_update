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

import static java.lang.Integer.parseInt;

public class viewEmpRequest {
    private static int count = 0;
    private static Integer id;
    public static String viewTable(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        count ++;
        if (count%2 == 1){
            id = parseInt(request.getParameter("reimbursement_id"));
            request.getSession().setAttribute("reimbursement_id", id);
        }
        System.out.println("Hey I was at handle request");
        System.out.println(id);
        EmpRepositoryImpl dao = new EmpRepositoryImpl();
        List<reimbursement> req = dao.findById(id);
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(req));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/manager/mangrembrstdl.html";
    }
}
