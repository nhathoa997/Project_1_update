package com.company.Models;

public class EmployeeAccount {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public EmployeeAccount(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
