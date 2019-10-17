package com.ex.dao;

import org.springframework.stereotype.Component;

@Component
public class DaoImpl implements Dao {
    @Override
    public void getEmployeeById() {
        System.out.println("DaoImpl#getEmployeeById");
    }
}
