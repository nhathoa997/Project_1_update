package services;

import com.company.Models.AccountInfo;
import com.company.data.dao.UserRepositoryImpl;

import java.sql.SQLException;

public class AccountTransaction {
    private UserRepositoryImpl dao;

    {
        try {
            dao = new UserRepositoryImpl();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private double new_balance;
    public double withdrawal(AccountInfo userInfo, double amount) throws SQLException {
        if (amount < 0 || ((userInfo.getBalance() - amount) < 0)) {
            System.out.println("Transaction unsuccessful. You enter: $" + amount + ", your balance: $" + userInfo.getBalance());
            return -1;
        }
        else {
            new_balance = userInfo.getBalance() - amount;
            System.out.println("Transaction successful. Your new balance is: $" + new_balance);
            userInfo.setBalance(new_balance);
            userInfo.setDifference(amount);
            dao.update(userInfo);
            dao.saveTransaction(userInfo,"Withdrawal");
            return new_balance;
        }
    }
    public double deposit(AccountInfo userInfo, double amount) throws SQLException {
        if (amount <0) {
            System.out.println("Transaction unsuccessful. You enter: $" + amount + ", your balance: $" + userInfo.getBalance());
            return -1;
        }
        else {
            new_balance = userInfo.getBalance() + amount;
            System.out.println("Transaction successful. Your new balance is: $" + new_balance);
            userInfo.setBalance(new_balance);
            userInfo.setDifference(amount);
            dao.update(userInfo);
            dao.saveTransaction(userInfo,"Deposit");
            return new_balance;
        }
    }
}
