package com.company.services;

import com.company.data.dao.EmpRepositoryImpl;
import com.company.data.dao.ManagerRepositoryImpl;
import com.company.models.EmployeeInfo;
import com.company.models.ManagerInfo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class Authenticate {
    private ManagerRepositoryImpl man_dao;
    private EmpRepositoryImpl dao;
    private String userName;
    private String password;

    public Authenticate() throws SQLException, ClassNotFoundException {
    }

    public String authenticate(HttpServletRequest request, String position) throws SQLException, ClassNotFoundException {
        if (position.equals("employee")){

            userName = request.getParameter("emp_username");
            password = request.getParameter("emp_password");
            this.dao = new EmpRepositoryImpl();
            EmployeeInfo user = dao.findUserName(userName);
            if ((user != null) && user.getPassword().equals(password)) {
                request.getSession().setAttribute("User", user);
                return "/employee/emplhome.html";
            }
            else return "/employee/employeeLogin.html";
        }
        else if (position.equals("manager")){
            userName = request.getParameter("manager_userName");
            password = request.getParameter("manager_password");
            man_dao = new ManagerRepositoryImpl();
            ManagerInfo user = man_dao.findUserName(userName);
            if ((user != null) && user.getPassword().equals(password)){
                request.getSession().setAttribute("User", user);
                return "/manager/manghome.html";
            }
            else return "/manager/managerLogin.html";
        }
        return "home.html";
    }
    public boolean authenticate(String userName, String password) throws SQLException, ClassNotFoundException {

        man_dao = new ManagerRepositoryImpl();
        ManagerInfo user = man_dao.findUserName(userName);
        if ((user != null) && user.getPassword().equals(password)) return true;
        else return false;
    }
}
