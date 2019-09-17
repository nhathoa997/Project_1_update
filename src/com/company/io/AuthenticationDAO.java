package com.company.io;

public class AuthenticationDAO extends DAOClass {
    public boolean Authenticate(String userName, String password){
        DAOClass dao = new DAOClass();
        this.data = dao.getData();
        return ((data.get(userName).getUserName().equals(userName)) && (data.get(userName).getPassword().equals(password)));
    }
}
