package com.company.models;

import com.company.data.dao.EmpRepositoryImpl;



import java.util.ArrayList;

public class EmployeeInfo {
    private String userName;
    private String password;
    private ArrayList<reimbursement> reimbursementID;
    private String email;

    public EmployeeInfo(String userName, String password) {
        this.reimbursementID = new ArrayList<reimbursement>();
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

    public ArrayList<reimbursement> getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(ArrayList<reimbursement> reimbursementID) {
        this.reimbursementID = reimbursementID;
    }
    public void createRequest(String type, Double totalAmount, EmpRepositoryImpl repository){
        reimbursement request = new reimbursement(type, totalAmount);
        reimbursementID.add(request);
        repository.saveRequest(this);
        System.out.println("A new request has been created.");
    }
}
