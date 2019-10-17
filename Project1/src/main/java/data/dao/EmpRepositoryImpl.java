package data.dao;

import data.EmployeeRepository;
import models.EmployeeInfo;
import models.ManagerInfo;
import models.reimbursement;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class EmpRepositoryImpl implements EmployeeRepository {

    private EmployeeInfo emp;
    private Connection conn = DriverManager.getConnection("jdbc:postgresql://henrydinh.cdrs9lfdhqu1.us-east-2.rds.amazonaws.com:5432/henrydb?user=henry_dinh&password=Henry8354392.");;

    public EmpRepositoryImpl() throws SQLException {
        try{
            //Class.forName("org.postgresql.Driver");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF not EXISTS EmployeeAccount(EmployeeName TEXT,Password TEXT, " +
                    "FOREIGN KEY (EmployeeName) REFERENCES ReimbursementTable(EmployeeName))");
            statement.execute("CREATE TABLE IF not EXISTS ReimbursementTable(EmployeeName TEXT, ReimbursementID INTEGER," +
                    "Type TEXT, Status TEXT,TotalAmount REAL, CreatedDate TEXT, " +
                    "SubmittedDate TEXT, FOREIGN KEY (ReimbursementID) REFERENCES EmployeeAccount(ReimbursementID))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EmployeeInfo findUserName(String EmployeeName) {
        String sql = "SELECT * from EmployeeAccount where EmployeeName = '" + EmployeeName + "'";
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);

            ResultSet results = statement.getResultSet();
            if (results.next()){
                emp = new EmployeeInfo(results.getString("EmployeeName"), results.getString("Password"));
                return emp;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public EmployeeInfo findById(Integer integer) {
        return null;
    }

    public Collection<EmployeeInfo> findAll() {
        return null;
    }

    public void save(EmployeeInfo obj) {
        try{
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO EmployeeAccount VALUES ('" + emp.getUserName() +"','" + emp.getPassword() + "')";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void saveRequest(EmployeeInfo emp) {
        try{
            reimbursement request = emp.getReimbursementID().get(emp.getReimbursementID().size() -1);
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO ReimbursementTable VALUES ('" + emp.getUserName() +"'," +
                    request.getReimbursementID() + ", '"+ request.getType() + "','" + request.getStatus() + "', "+
                    request.getTotalAmount() + ", '"+ request.getCreatedDate()+ "','" + request.getSubmittedDate()+ "')";
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(String obj) {

    }
}
