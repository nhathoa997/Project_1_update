package com.company.data.dao;


import com.company.connection.Connection;
import com.company.data.ManagerRepository;
import com.company.models.EmployeeInfo;
import com.company.models.ManagerInfo;

import java.sql.*;

import org.postgresql.Driver;

import java.util.Collection;
import com.company.connection.*;

public class ManagerRepositoryImpl implements ManagerRepository {
    private ManagerInfo manager;

    public ManagerRepositoryImpl() throws SQLException {
        try{
            Statement statement = Connection.conn.createStatement();
            statement.execute("CREATE TABLE IF not EXISTS ManagerAccount(ManagerName TEXT,Password TEXT) ");
            statement.execute("CREATE TABLE IF not EXISTS ResolvedCases(ReimbursementID INTEGER,Status TEXT,ManagerName TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ManagerInfo findUserName(String userName) {
        String sql = "SELECT * from ManagerAccount where ManagerName = '" + userName + "'";
        try {
            Statement statement = Connection.conn.createStatement();
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
            Statement statement = Connection.conn.createStatement();
            String sql = "INSERT INTO ManagerAccount VALUES ('" + manager.getUserName() +"','" + manager.getPassword() + "')";
            statement.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePassword(ManagerInfo manager){
        try{
            Statement statement = Connection.conn.createStatement();
            String sql = "UPDATE manageraccount SET Password = '" + manager.getPassword() +"' WHERE managername = '"
                    + manager.getUserName() + "'";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUpdate(EmployeeInfo emp, Integer reimbursementID){
        try{
            Statement statement = Connection.conn.createStatement();
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
