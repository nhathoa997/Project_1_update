package com.company.data.dao;

import com.company.connection.Connection;
import com.company.data.EmployeeRepository;
import com.company.models.EmployeeInfo;
import com.company.models.reimbursement;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.postgresql.Driver;
import com.company.connection.*;
public class EmpRepositoryImpl implements EmployeeRepository {

    private EmployeeInfo emp;

    public EmpRepositoryImpl() throws SQLException {
        try{

            Statement statement = Connection.conn.createStatement();

            statement.execute("CREATE TABLE IF not EXISTS EmployeeAccount(EmployeeName TEXT,Password TEXT)");
            statement.execute("CREATE TABLE IF not EXISTS ReimbursementTable(EmployeeName TEXT, ReimbursementID INTEGER," +
                    "Type TEXT, Status TEXT,TotalAmount REAL, CreatedDate TEXT, " +
                    "SubmittedDate TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EmployeeInfo findUserName(String EmployeeName) {
        String sql = "SELECT * from EmployeeAccount where EmployeeName = '" + EmployeeName + "'";
        String sql2;
        try {
            Statement statement = Connection.conn.createStatement();
            statement.execute(sql);

            ResultSet all_employees = statement.getResultSet();
            while (all_employees.next()){
                ArrayList<reimbursement> requests = new ArrayList<>();
                emp = new EmployeeInfo(all_employees.getString("EmployeeName"), all_employees.getString("Password"));
                sql2 = "SELECT * from ReimbursementTable WHERE EmployeeName = '" + emp.getUserName() + "'";
                Statement statement2 = Connection.conn.createStatement();
                statement2.execute(sql2);
                ResultSet requests_per_emp = statement2.getResultSet();
                while (requests_per_emp.next()){
                    reimbursement request = new reimbursement(requests_per_emp.getInt("ReimbursementID"),
                            requests_per_emp.getString("Type"), requests_per_emp.getString("Status"),
                            requests_per_emp.getDouble("TotalAmount"),requests_per_emp.getString("CreatedDate"),
                            requests_per_emp.getString("SubmittedDate"));
                    requests.add(request);
                }
                emp.setReimbursementID(requests);
            }
            return emp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String findUserJson(String userName){
        return "C:\\Users\\dinhh\\1908-aug09-java-aug\\Project_1_update\\src\\main\\java\\com\\company\\Json\\" + userName + ".txt";
    }


    public EmployeeInfo findById(Integer integer) {
        return null;
    }

//

    public ArrayList<EmployeeInfo> findAll() {
        String sql = "SELECT * from EmployeeAccount";
        String sql2;
        ArrayList<EmployeeInfo> employees = new ArrayList<>();
        try {
            Statement statement = Connection.conn.createStatement();
            statement.execute(sql);

            ResultSet all_employees = statement.getResultSet();
            while (all_employees.next()){
                ArrayList<reimbursement> requests = new ArrayList<>();
                emp = new EmployeeInfo(all_employees.getString("EmployeeName"), all_employees.getString("Password"));
                sql2 = "SELECT * from ReimbursementTable WHERE EmployeeName = '" + emp.getUserName() + "'";
                Statement statement2 = Connection.conn.createStatement();
                statement2.execute(sql2);
                ResultSet requests_per_emp = statement2.getResultSet();
                while (requests_per_emp.next()){
                    reimbursement request = new reimbursement(requests_per_emp.getInt("ReimbursementID"),
                            requests_per_emp.getString("Type"), requests_per_emp.getString("Status"),
                            requests_per_emp.getDouble("TotalAmount"),requests_per_emp.getString("CreatedDate"),
                            requests_per_emp.getString("SubmittedDate"));
                    requests.add(request);
                }
                emp.setReimbursementID(requests);
                employees.add(emp);
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(EmployeeInfo emp) {
        try{
            Statement statement = Connection.conn.createStatement();
            String sql = "INSERT INTO EmployeeAccount VALUES ('" + emp.getUserName() +"','" + emp.getPassword() + "')";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void saveRequest(EmployeeInfo emp) {
        try{
            if (emp.getReimbursementID().size() >= 1){
                reimbursement request = emp.getReimbursementID().get(emp.getReimbursementID().size()-1);
                Statement statement = Connection.conn.createStatement();
                String sql = "INSERT INTO ReimbursementTable VALUES ('" + emp.getUserName() +"'," +
                        request.getReimbursementID() + ", '"+ request.getType() + "','" + request.getStatus() + "', "+
                        request.getTotalAmount() + ", '"+ request.getCreatedDate()+ "','" + request.getSubmittedDate()+ "')";
                statement.execute(sql);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateRequestDate(Integer reimbursementID) throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        java.util.Date date = new Date();
        String valnow = formatter.format(date);
        String sql = "UPDATE ReimbursementTable SET SubmittedDate = '" + valnow + "' WHERE ReimbursementID = '" + reimbursementID
                + "'";
        Statement statement = Connection.conn.createStatement();
        statement.execute(sql);

    }
    public void updateRequest(Integer reimbursementID,String decision) throws SQLException {
        String sql = "UPDATE ReimbursementTable SET Status = '" + decision + "' WHERE ReimbursementID = '" + reimbursementID
                + "'";
        Statement statement = Connection.conn.createStatement();
        statement.execute(sql);

    }
    public void delete(String userName) {
    }
}
