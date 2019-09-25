package com.company.Models;

import java.io.Serializable;

public class EmployeeAccount implements Serializable {
    private String userName;
    private String password;
    public String getUserName() {
        return userName;
    }

    public EmployeeAccount (String userName, String password){
        this.userName = userName;
        this.password = password;
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
}
