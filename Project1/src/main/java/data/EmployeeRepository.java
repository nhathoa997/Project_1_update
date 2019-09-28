package data;

import models.EmployeeInfo;

public interface EmployeeRepository extends Repository<Integer, EmployeeInfo> {
    EmployeeInfo findUserName(String userName);
}
