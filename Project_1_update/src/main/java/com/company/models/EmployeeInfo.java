package com.company.models;

import com.company.data.dao.EmpRepositoryImpl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeInfo {
    private String userName;
    private String password;
    private List<reimbursement> reimbursementID;
    private String email;
    EmpRepositoryImpl dao = new EmpRepositoryImpl();

    public EmployeeInfo(String userName, String password) throws SQLException {
        this.reimbursementID = new ArrayList<>();
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

    public List<reimbursement> getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(ArrayList<reimbursement> reimbursementID) {
        this.reimbursementID = reimbursementID;
    }
    public void createRequest(String type, Double totalAmount){
        reimbursement request = new reimbursement(type, totalAmount);
        reimbursementID.add(request);
        dao.saveRequest(this);
        System.out.println("A new request has been created.");
    }
    public void getEmpInfo(){
        System.out.println(userName);
        System.out.println(password);
        for(int i = 0; i < reimbursementID.size(); i++){
            reimbursementID.get(i).reimbursementInfo();
        }
    }

}
