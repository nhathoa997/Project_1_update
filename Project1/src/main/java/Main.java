import data.ManagerRepository;
import data.dao.EmpRepositoryImpl;
import models.EmployeeInfo;
import models.ManagerInfo;
import services.createEmployee;
import services.createManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        EmpRepositoryImpl repository = new EmpRepositoryImpl();
        createManager newManager = new createManager();
        newManager.create("David Beckam", "password");
        createEmployee newEmployee  = new createEmployee(repository);
        EmployeeInfo emp = newEmployee.create("Henry Dinh", "password");
        emp.createRequest("Certification",350.5, repository);
    }
}
