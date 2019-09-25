package com.company.Models;

import java.util.ArrayList;

public class CustomerInfo {
    private ArrayList<AccountInfo> account_lst = new ArrayList<>();

    public CustomerInfo(AccountInfo newUser){
        account_lst.add(newUser);
    }
    public ArrayList<AccountInfo> getAccount_lst() {
        return account_lst;
    }
    public void setAccount_lst(ArrayList<AccountInfo> account_lst) {
        this.account_lst = account_lst;
    }
}
