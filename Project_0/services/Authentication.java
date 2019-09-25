package services;

import com.company.Models.AccountInfo;
import com.company.Models.EmployeeAccount;
import com.company.data.dao.EmpRepositoryImpl;
import com.company.data.dao.UserRepositoryImpl;

import java.sql.SQLException;

public class Authentication {
    private UserRepositoryImpl dao;
    private EmpRepositoryImpl empdao;

    public Authentication() throws SQLException, ClassNotFoundException {
    }

    public boolean authenticate(String userName, String password, String position) throws SQLException, ClassNotFoundException {

        if (position.equals("customer")){
            dao = new UserRepositoryImpl();
            AccountInfo user = dao.findUserName(userName);
            if ((user != null) && user.getPassword().equals(password)) return true;
            else return false;
        }
        else if (position.equals("employee")){
            empdao = new EmpRepositoryImpl();
            EmployeeAccount user = empdao.findUserName(userName);
            if ((user!= null) && user.getPassword().equals(password)) return true;
            else return false;
        }
        return false;
    }
    public boolean authenticate(String userName) throws SQLException, ClassNotFoundException {

        dao = new UserRepositoryImpl();
        AccountInfo user = dao.findUserName(userName);
        if ((user != null)) return true;
        else return false;
    }

}

