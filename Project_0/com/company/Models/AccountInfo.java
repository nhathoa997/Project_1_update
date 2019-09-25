package com.company.Models;

import java.io.Serializable;
import java.util.Random;

public class AccountInfo  implements Serializable {
    private String userName;
    private String password;
    private double balance;
    private int accountID;
    private double difference;
    private static final long serialVersionUID = 340681967564469107L;


    public AccountInfo(String userName, String password){
        this.userName = userName;
        this.balance = 0.0;
        this.accountID = new Random().nextInt(9999999-1000000)+1000000;
        this.password = password;
        //this.account_lst.add(this);

    }

    public AccountInfo(String userName, String password, Double balance, Integer id){
        this.userName = userName;
        this.password = password;
        this.balance = balance;
        this.accountID = id;
    }
    public AccountInfo(String userName){
        this.userName = userName;
    }
    public String getPassword(){
        return this.password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setDifference(Double amount){
        this.difference = amount;
    }
    public double getDifference(){
        return this.difference;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountID() {
        return accountID;
    }

    public void getUserInfo(){
        System.out.println("User Name: " + this.userName);
        System.out.println(this.password);
        System.out.println("Balance: $" + this.balance);
        System.out.println("Account ID: " + this.accountID);
    }
}
