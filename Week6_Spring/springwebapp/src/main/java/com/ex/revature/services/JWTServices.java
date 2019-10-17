package com.ex.revature.services;

import com.ex.revature.entities.EmployeeBean;
import com.ex.revature.entities.Role;

public interface JWTServices {
    public String build(EmployeeBean emp);
    public EmployeeBean verify(String token);
}
