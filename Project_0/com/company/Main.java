package com.company;


import com.company.Platform.Application;
import com.company.system.BankApplication;
import services.CreateNewUser;

public class Main {
    static String bankTitle =  "Loanly Peoples Credit Union";

    public static void main(String[] args) {
        //CreateNewUser newUser = new CreateNewUser();
        //newUser.create("Henry Dinh", "Henry8354392.");
        //Application app = new BankApplication();
        //app.setTitle(bankTitle);
        //app.run(args);
        CreateNewUser newUser = new CreateNewUser();
        newUser.create("rjsargent", "password1");
        Application app = new BankApplication();
        app.setTitle(bankTitle);
        app.run(args);




    }
}
