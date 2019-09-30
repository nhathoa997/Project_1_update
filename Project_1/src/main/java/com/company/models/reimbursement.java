package com.company.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class reimbursement {
    private Integer reimbursementID;
    private String type;
    private String status;
    private Double totalAmount;
    private String createdDate;
    private String submittedDate;

    public reimbursement(String type, Double totalAmount) {
        this.reimbursementID = new Random().nextInt(9999999-1000000)+1000000;
        this.totalAmount = totalAmount;
        this.type = type;
        this.status = "Pending";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String valnow = formatter.format(date);
        this.createdDate = valnow;
    }

    public Integer getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(Integer reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }
}
