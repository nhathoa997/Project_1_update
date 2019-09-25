package services;

import com.company.Models.AccountInfo;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class AccountTransactionTest {
    private AccountTransaction transaction;
    private AccountInfo user;

    @Before
    public void init(){
        transaction = new AccountTransaction();
        user = new AccountInfo("Henry", "12345", 1500.5, 1765878);
    }

    @Test
    public void withdrawalFailTooBig() throws SQLException {
        double balance = transaction.withdrawal(user, 1500.56);
        assertEquals(-1, balance, 0.00);
    }

    @Test
    public void succesfullWithdrawal() throws SQLException {
        double balance = transaction.withdrawal(user, 1400.5);
        assertEquals(100, balance, 0.00);
    }

    @Test
    public void deposit() throws SQLException {
        AccountTransaction transaction = new AccountTransaction();
        AccountInfo user = new AccountInfo("Henry", "12345", 1500.5, 1765878);
        double balance = transaction.deposit(user, -1500.56);
        assertEquals(-1, balance, 0.00);
        balance = transaction.deposit(user, 1400.5);
        assertEquals(2901, balance, 0.00);
    }
}