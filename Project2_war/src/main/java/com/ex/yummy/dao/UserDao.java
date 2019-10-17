package com.ex.yummy.dao;

import com.ex.yummy.entities.Users;

public interface UserDao {
    Users getById (int id);
    Users getByUserName(String userName);
    Users getByEmail(String email);
}
