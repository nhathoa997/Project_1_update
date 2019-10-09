package com.company.services;

import com.company.data.dao.EmpRepositoryImpl;
import com.company.data.dao.ManagerRepositoryImpl;
import com.company.models.EmployeeInfo;
import com.company.models.ManagerInfo;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class UpdateInfo {
    private EmpRepositoryImpl dao = new EmpRepositoryImpl();
    private ManagerRepositoryImpl man_dao = new ManagerRepositoryImpl();

    public UpdateInfo() throws SQLException {
    }

    public String update(HttpServletRequest req, String position){
        String confirm_pass = req.getParameter("confirm_password");
        String new_pass = req.getParameter("new_password");
        System.out.println(confirm_pass);
        System.out.println(new_pass);
        if ((confirm_pass.equals(new_pass)) && (position.equals("employee"))){
            EmployeeInfo user = (EmployeeInfo)req.getSession().getAttribute("User");
            user.setPassword(new_pass);
            dao.updatePassword(user);
            System.out.println("Password update successful!");
            return "/employee/emplhome.html";
        }else if ((confirm_pass.equals(new_pass)) && (position.equals("manager"))){
            ManagerInfo user = (ManagerInfo) req.getSession().getAttribute("User");
            user.setPassword(new_pass);
            man_dao.updatePassword(user);
            System.out.println("Password update successful!");
            return "/manager/manghome.html";
        }
        System.out.println("updating unsuccessful!");
        return "/employee/emplhome.html";
    }
}
