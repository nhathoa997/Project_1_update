package com.company.screenDirectory;

import com.company.services.Authenticate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class screenRequest {
    public String nextScreen(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        switch(request.getRequestURI()){
            case "/Project_1_war/LoginServlet":
                Authenticate auth = new Authenticate();
                return auth.authenticate(request);
//            case "/Project1/ViewTable.do":
//                return ViewTable.view(request);
//            case "/Project1/Update.do":
//                return UpdateTable.update(request);
//            case "/Project1/Create.do":
//                return CreateTable.create(request);
        }
        return "home.html";
    }
}
