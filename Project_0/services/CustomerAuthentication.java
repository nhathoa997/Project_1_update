package services;

import com.company.io.AuthenticationDAO;

public class CustomerAuthentication {
    private AuthenticationDAO client = new AuthenticationDAO();
    public boolean authenticate(String userName, String password){
        return client.Authenticate(userName,password);
    }
}

