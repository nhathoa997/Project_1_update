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

    public Authenticate() throws SQLException, ClassNotFoundException {
    }

    public String authenticate(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String userName = request.getParameter("emp_username");
        String password = request.getParameter("emp_password");
        String position = "employee";
        if (position.equals("employee")){
            this.dao = new EmpRepositoryImpl();
            EmployeeInfo user = dao.findUserName(userName);
            if ((user != null) && user.getPassword().equals(password)) return "/employee/emplhome.html";
            else return "home.html";
        }
        else if (position.equals("manager")){
            man_dao = new ManagerRepositoryImpl();
            ManagerInfo user = man_dao.findUserName(userName);
            if ((user!= null) && user.getPassword().equals(password)) return "manghome.html";
            else return "home.html";
        }
        return "home.html";
    }
    public boolean authenticate(String userName, String password) throws SQLException, ClassNotFoundException {

        dao = new EmpRepositoryImpl();
        EmployeeInfo user = dao.findUserName(userName);
        if ((user != null)) return true;
        else return false;
    }
}
