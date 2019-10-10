package com.company.screenDirectory;

import com.company.Tables.ViewReimbursementTable;
import com.company.Tables.viewEmpHist;
import com.company.Tables.viewEmployeesTable;
import com.company.Tables.viewPendingTable;
import com.company.data.dao.EmpRepositoryImpl;
import com.company.models.EmployeeInfo;
import com.company.services.Authenticate;
import com.company.services.UpdateInfo;

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
            case "/Project_1_war/redirectSettings":
                return "/employee/emplsettings.html";
            case "/Project_1_war/updateInformation":
                UpdateInfo update = new UpdateInfo();
                return update.update(request,"employee");
            case "/Project_1_war/createRequest":
                EmployeeInfo user = (EmployeeInfo)request.getSession().getAttribute("User");
                user.createRequest(request.getParameter("type"),Double.parseDouble(request.getParameter("amount")));
                return "/employee/emplhome.html";
            case "/Project_1_war/redirectToCreate":
                return "/employee/emplexprdetails.html";
            case "/Project_1_war/redirectReimbursement":
                return "/employee/emplreimbrst.html";
            case "/Project_1_war/redirectManagerSettings":
                return "/manager/mangsettngs.html";
            case "/Project_1_war/redirectManagerHome":
                return "/manager/manghome.html";
            case "/Project_1_war/redirectEmployees":
                return "/manager/mangemployees.html";
            case "/Project_1_war/redirectPending":
                return "/manager/mangpendingl.html";
            case "/Project_1_war/viewApproved":
                return "/manager/mangapprovedl.html";
            case "/Project_1_war/updateManagerInformation":
                UpdateInfo man_update = new UpdateInfo();
                return man_update.update(request,"manager");
            case "/Project_1_war/viewEmployees":
                return viewEmployeesTable.viewTable(request,response);
            case "/Project_1_war/viewPendingList":
                return viewPendingTable.viewTable(request,response);
            case "/Project_1_war/viewEmpHist":
                return viewEmpHist.viewTable(request,response);
            case "/Project_1_war/redirectEmpHome":
                return "/employee/emplhome.html";
        }
        return "home.html";
    }
}
