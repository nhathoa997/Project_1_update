package services;

import com.company.Models.EmployeeAccount;
import com.company.io.DAOClass;

public class CreateNewEmployee {
    private DAOClass dao = new DAOClass();
    private EmployeeAccount employee = new EmployeeAccount("nemo", "000000");

    public void create(String userName, String password){

    }

}
