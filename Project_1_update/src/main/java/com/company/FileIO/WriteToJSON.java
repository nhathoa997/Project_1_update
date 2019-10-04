package com.company.FileIO;

import com.company.models.EmployeeInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class WriteToJSON {
    public void write(EmployeeInfo emp){

        JSONObject employeeRequestDetails = new JSONObject();
        ArrayList<JSONObject> employeeRequests = new ArrayList<>();
        JSONObject employeeDetails = new JSONObject();
        JSONObject employeeObject = new JSONObject();
        for(int i = 0; i < emp.getReimbursementID().size(); i++){
            employeeRequestDetails.put("Reimbursement ID",emp.getReimbursementID().get(i).getReimbursementID());
            employeeRequestDetails.put("Type",emp.getReimbursementID().get(i).getType());
            employeeRequestDetails.put("Status",emp.getReimbursementID().get(i).getStatus());
            employeeRequestDetails.put("Total Amount",emp.getReimbursementID().get(i).getTotalAmount());
            employeeRequestDetails.put("Created Date",emp.getReimbursementID().get(i).getCreatedDate());
            employeeRequestDetails.put("Submitted Date",emp.getReimbursementID().get(i).getSubmittedDate());
            employeeRequests.add(employeeRequestDetails);
            employeeRequestDetails = new JSONObject();
        }
        employeeDetails.put("Name", emp.getUserName());
        employeeDetails.put("Password", emp.getPassword());
        employeeDetails.put("Requests", employeeRequests);
        employeeObject.put("Employee", employeeDetails);

        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        try (FileWriter file = new FileWriter("C:\\Users\\dinhh\\1908-aug09-java-aug\\Project_1\\src\\main\\java\\com\\company\\Json\\employees.json")) {
            System.out.println("Data have been written to the Json File");
            file.write(employeeList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
