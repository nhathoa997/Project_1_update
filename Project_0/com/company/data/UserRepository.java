package com.company.data;

import com.company.Models.AccountInfo;

public interface UserRepository extends Repository<Integer, AccountInfo> {
    AccountInfo findUserName(String email);
}

