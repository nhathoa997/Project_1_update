package com.company.screenDirectory;

import com.company.Tables.ViewReimbursementTable;
import com.company.services.Authenticate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class screenRequest {
    public String nextScreen(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        switch(request.getRequestURI()){
            case "/Project_1_war/emp_clarification":
                return "/employee/employeeLogin.html";
            case "/Project_1_war/manager_clarification":
                return "/manager/managerLogin.html";
            case "/Project_1_war/emp_Login":
                Authenticate auth = new Authenticate();
                return auth.authenticate(request, "employee");
            case "/Project_1_war/manager_Login":
                Authenticate auth2 = new Authenticate();
                return auth2.authenticate(request, "manager");
            case "/Project_1_war/viewTable":
                return ViewReimbursementTable.viewTable(request, response);
//            case "/Project1/Update.do":
//                return UpdateTable.update(request);
//            case "/Project1/Create.do":
//                return CreateTable.create(request);
        }
        return "home.html";
    }
}
