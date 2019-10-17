package services;

import data.dao.EmpRepositoryImpl;
import models.EmployeeInfo;

import java.sql.SQLException;

public class createEmployee {
    private EmployeeInfo emp;
    EmpRepositoryImpl repository = new EmpRepositoryImpl();
    public createEmployee(EmpRepositoryImpl repository) throws SQLException {
        this.repository = repository;
    }
    public EmployeeInfo create(String userName, String password){
        this.emp = new EmployeeInfo(userName, password);
        repository.save(emp);
        System.out.println("A new manager has been created");
        return emp;
    }
}
