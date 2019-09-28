package models;

import java.util.ArrayList;

public class EmployeeInfo {
    private String userName;
    private String password;
    private ArrayList<reimbursement> reimbursementID = new ArrayList<reimbursement>();
    private String email;

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
}
