package models;

import java.util.Date;

public class reimbursement {
    private String reimbursementID;
    private String type;
    private String status;
    private String totalAmount;
    private Date createdDate;
    private Date submittedDate;

    public String getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(String reimbursementID) {
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

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }
}
