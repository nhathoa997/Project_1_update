package com.company.models;

import java.util.ArrayList;

public class ManagerInfo {
    private String userName;
    private String password;
    private ArrayList<EmployeeInfo> empList = new ArrayList<EmployeeInfo>();

    public ManagerInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<EmployeeInfo> getEmpList() {
        return empList;
    }

    public void setEmpList(ArrayList<EmployeeInfo> empList) {
        this.empList = empList;
    }
}
