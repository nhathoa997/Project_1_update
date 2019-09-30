package com.company.data;


import com.company.models.EmployeeInfo;

public interface EmployeeRepository extends Repository<Integer, EmployeeInfo> {
    EmployeeInfo findUserName(String userName);
}
