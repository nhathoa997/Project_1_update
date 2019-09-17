package com.company.Models;
import services.AccountTransaction;
import services.TransactionHistory;
import java.util.*;

import java.io.Serializable;

public class AccountInfo implements Serializable {
    private String userName;
    private double balance;
    private String password;
    ArrayList<Integer> accountID = new ArrayList<Integer>();
    private String[] transactionHist;
    AccountTransaction transaction;



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

    public void withdraw(double amount){
        if (transaction.withdrawal(this.balance, amount) == -1)
            System.out.println("Transaction unsuccessful. You enter: $" + amount + ", your balance: $" + balance);
        else {

            balance = transaction.withdrawal(balance,amount);
            TransactionHistory withdrawHist = new TransactionHistory();
            this.transactionHist = withdrawHist.setTranHist(balance,amount,"Withdrawal", transactionHist);
            System.out.println("Transaction successful. Your new balance is: $" + balance);
        }
    }
    public void deposit(double amount){
        if (transaction.deposit(this.balance, amount) == -1)
            System.out.println("Transaction unsuccessful. You enter: $" + amount + ", your balance: $" + balance);
        else {
            balance = transaction.deposit(balance,amount);
            TransactionHistory depositHist = new TransactionHistory();
            this.transactionHist = depositHist.setTranHist(balance,amount,"Deposit", transactionHist);
            System.out.println("Transaction successful. Your new balance is $" + balance);
        }

    }
    public void viewTransactionHist(){
        for(int i = 0; i<transactionHist.length; i++) System.out.println(transactionHist[i]);
    }

}
