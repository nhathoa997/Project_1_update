package com.company.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class AccountInfo implements Serializable {
    private String userName;
    private double balance;
    private String password;
    ArrayList<Integer> accountID = new ArrayList<Integer>();
    private String[] transactionHist;
    private static final long serialVersionUID = 340681967564469107L;


    public AccountInfo(String userName, String password){
        this.userName = userName;
        this.transactionHist = new String[1];
        this.balance = 0.0;
        this.accountID.add((int)Math.random());
        this.password = password;

    }
    public AccountInfo(String userName, double balance, int accountID, String[] transactionHist, String password){
        this.userName = userName;
        this. balance = balance;
        this.accountID.add(accountID);
        this.transactionHist = transactionHist;
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public ArrayList<Integer> getAccountID() {
        return accountID;
    }

    public void getUserInfo(){
        System.out.println("User Name: " + userName);
        System.out.println("Balance: $" + balance);
        System.out.println("Accounts: " + Arrays.toString(accountID.toArray()));
        System.out.println("Transaction History: ");
        for(int i = 0; i<transactionHist.length; i++){
            System.out.println(transactionHist[i]);
        }
    }

    public String[] getTransactionHist() {
        return transactionHist;
    }

    public void setTransactionHist(String[] transactionHist) {
        this.transactionHist = transactionHist;
    }
    public void viewTranHist(){
        for(int i = 0; i < transactionHist.length; i++){
            System.out.println(transactionHist[i]);
        }
    }
}
