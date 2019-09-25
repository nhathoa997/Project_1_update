package services;

import com.company.Models.EmployeeAccount;
import com.company.data.dao.EmpRepositoryImpl;

public class CreateNewEmployee {
    private EmpRepositoryImpl dao = new EmpRepositoryImpl();

    public void create(String userName, String password){
        EmployeeAccount newUser = new EmployeeAccount(userName, password);
        dao.save(newUser);
        System.out.println("A new user has been created.");
    }

}
