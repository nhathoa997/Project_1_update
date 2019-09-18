package services;

import com.company.Models.AccountInfo;
import com.company.io.DAOClass;

public class AccountTransaction {
    private DAOClass dao = new DAOClass();
    private double new_balance;
    private TransactionHistory tranHist = new TransactionHistory();
    public void withdrawal(AccountInfo userInfo, double amount){
        if (amount < 0 || ((userInfo.getBalance() - amount) < 0)) {
            System.out.println("Transaction unsuccessful. You enter: $" + amount + ", your balance: $" + userInfo.getBalance());
        }
        else {
            new_balance = userInfo.getBalance() - amount;
            System.out.println("Transaction successful. Your new balance is: $" + new_balance);
            userInfo.setBalance(new_balance);
            userInfo.setTransactionHist(tranHist.setTranHist(new_balance,amount,"withdrawal",userInfo.getTransactionHist()));
            dao.Write(userInfo.getUserName(),userInfo);
        }
    }
    public void deposit(AccountInfo userInfo, double amount){
        if (amount <0) {
            System.out.println("Transaction unsuccessful. You enter: $" + amount + ", your balance: $" + userInfo.getBalance());
        }
        else {
            new_balance = userInfo.getBalance() + amount;
            System.out.println("Transaction successful. Your new balance is: $" + new_balance);
            userInfo.setBalance(new_balance);
            userInfo.setTransactionHist(tranHist.setTranHist(new_balance,amount,"deposit",userInfo.getTransactionHist()));
            dao.Write(userInfo.getUserName(),userInfo);
        }
    }
}
