package data.dao;

import data.ManagerRepository;
import models.EmployeeInfo;
import models.ManagerInfo;
import models.reimbursement;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ManagerRepositoryImpl implements ManagerRepository {
    private ManagerInfo manager;
    private Connection conn = DriverManager.getConnection("jdbc:postgresql://henrydinh.cdrs9lfdhqu1.us-east-2.rds.amazonaws.com:5432/henrydb?user=henry_dinh&password=Henry8354392.");;

    public ManagerRepositoryImpl() throws SQLException {
        try{
            //Class.forName("org.postgresql.Driver");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF not EXISTS ManagerAccount(ManagerName TEXT,Password TEXT) ");
            statement.execute("CREATE TABLE IF not EXISTS ResolvedCases(ReimbursementID INTEGER,Status TEXT,ManagerName TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ManagerInfo findUserName(String userName) {
        String sql = "SELECT * from ManagerAccount where ManagerName = '" + userName + "'";
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);

            ResultSet results = statement.getResultSet();
            if (results.next()){
                manager = new ManagerInfo(results.getString("ManagerName"), results.getString("Password"));
                return manager;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ManagerInfo findById(Integer integer) {
        return null;
    }

    public Collection<ManagerInfo> findAll() {
        return null;
    }

    public void save(ManagerInfo manager) {
        try{
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO ManagerAccount VALUES ('" + manager.getUserName() +"','" + manager.getPassword() + "')";
            statement.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUpdate(EmployeeInfo emp, Integer reimbursementID){
        try{
            ArrayList<reimbursement> emp_reimbursement = emp.getReimbursementID();
            Statement statement = conn.createStatement();
//            int position = 0;
//            for (int i = 0; i < emp_reimbursement.size(); i++){
//                if (emp_reimbursement.get(i).getReimbursementID() == reimbursementID){
//                    position = i;
//                }
//            }
            String sql = "UPDATE Reimbursements SET Status = 'Approved' WHERE ReimbursementID = " + reimbursementID;
            statement.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(String obj) {
    }
}
