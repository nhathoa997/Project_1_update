package com.company.services;




import com.company.data.dao.ManagerRepositoryImpl;
import com.company.models.ManagerInfo;

import java.sql.SQLException;

public class createManager {
    private ManagerInfo manager;
    private ManagerRepositoryImpl repository;

    {
        try {
            repository = new ManagerRepositoryImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ManagerInfo create(String userName, String password){
        manager = new ManagerInfo(userName, password);
        repository.save(manager);
        System.out.println("A new manager has been created");
        return manager;

    }

}
