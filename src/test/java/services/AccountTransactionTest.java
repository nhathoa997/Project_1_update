package services;

import com.company.Models.AccountInfo;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class AccountTransactionTest {


    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void withdrawal() throws SQLException {
        AccountTransaction transaction = new AccountTransaction();
        AccountInfo user = new AccountInfo("Henry","12345",1500.5,1765878);
        double balance = transaction.withdrawal(user,1500.56);
        assertEquals(-0.06,balance,0.00);
        balance = transaction.withdrawal(user,1500.56);
        assertEquals(-1,balance,0.00);
        balance = transaction.withdrawal(user,1400.5);
        assertEquals(100,balance,0.00);
    }

    @Test
    public void deposit() throws SQLException {
        AccountTransaction transaction = new AccountTransaction();
        AccountInfo user = new AccountInfo("Henry","12345",1500.5,1765878);
        double balance = transaction.deposit(user,-1500.56);
        assertEquals(-1,balance,0.00);
        balance = transaction.withdrawal(user,1400.5);
        assertEquals(2901,balance,0.00);
    }
}
