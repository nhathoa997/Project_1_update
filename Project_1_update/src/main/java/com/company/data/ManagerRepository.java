package com.company.data;


import com.company.models.ManagerInfo;

public interface ManagerRepository extends Repository<Integer, ManagerInfo> {
    ManagerInfo findUserName(String userName);
}
