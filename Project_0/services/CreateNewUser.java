package services;

import com.company.Models.AccountInfo;
import com.company.io.DAOClass;

public class CreateNewUser {
    private DAOClass dao = new DAOClass();

    public void create(String userName, String password){
        AccountInfo newUser = new AccountInfo(userName, password);
        dao.Write(userName,newUser);
        System.out.println("A new user has been created.");
        System.out.println(dao.Read(userName));
    }
}
