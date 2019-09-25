package com.company.data;

import com.company.Models.EmployeeAccount;

public interface EmpRepository extends Repository<Integer, EmployeeAccount> {
    EmployeeAccount findUserName(String userName);
}
