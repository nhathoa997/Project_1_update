package com.company.screenDirectory;

import com.company.Tables.*;
import com.company.data.dao.EmpRepositoryImpl;
import com.company.data.dao.ManagerRepositoryImpl;
import com.company.models.EmployeeInfo;
import com.company.models.ManagerInfo;
import com.company.services.Authenticate;
import com.company.services.UpdateInfo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

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
                return viewResolvedTable.viewTable(request,response);
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
            case "/Project_1_war/redirectEmpHist":
                System.out.println(request.getParameter("user_name"));
//                request.getSession().setAttribute("employee_name", request.getParameter("user_name"));
                return "/manager/mangemployeerq.html";
            case "/Project_1_war/handleEmpRequest":
                return viewEmpRequest.viewTable(request,response);
            case "/Project_1_war/handleDecision":
                EmpRepositoryImpl dao = new EmpRepositoryImpl();
                ManagerInfo manager = (ManagerInfo) request.getSession().getAttribute("User");
                ManagerRepositoryImpl man_dao = new ManagerRepositoryImpl();
                int id = (int) request.getSession().getAttribute("reimbursement_id");
                if (request.getParameter("decision").equals("Approve")){
                    dao.updateRequest(id,"Approved");
                    dao.updateRequestDate(id);
                    man_dao.saveDecision(id,"Approved", manager.getUserName());
                }
                else if (request.getParameter("decision").equals("Deny")){
                    dao.updateRequest(id,"Denied");
                    dao.updateRequestDate(id);
                    man_dao.saveDecision(id,"Denied", manager.getUserName());
                }
                return "/manager/mangpendingl.html";
        }
        return "home.html";
    }
}
