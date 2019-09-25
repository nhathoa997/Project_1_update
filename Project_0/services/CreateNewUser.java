package services;

import com.company.Models.AccountInfo;
import com.company.Models.CustomerInfo;
import com.company.data.dao.UserRepositoryImpl;

import java.sql.SQLException;

public class CreateNewUser {
    UserRepositoryImpl dao = new UserRepositoryImpl();
    CustomerInfo newUserInfo;

    public CreateNewUser() throws SQLException, ClassNotFoundException {
    }

    public void create(String userName, String password){
        AccountInfo newUser = new AccountInfo(userName, password);
        dao.save(newUser);
        newUserInfo = new CustomerInfo(newUser);
        System.out.println("A new user has been created.");
    }
}
