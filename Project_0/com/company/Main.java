package com.company;


import com.company.io.AuthenticationDAO;

public class Main {
    static String bankTitle =  "Loanly Peoples Credit Union";

    public static void main(String[] args) {
        //CreateNewUser newUser = new CreateNewUser();
        //newUser.create("Henry Dinh", "Henry8354392.");
        //Application app = new BankApplication();
        //app.setTitle(bankTitle);
        //app.run(args);
        //AccountInfo newUser = new AccountInfo("Henry Dinh", "Henry8354392.");
        //DAOClass dao = new DAOClass();
        //dao.createNewUser("Henry Dinh");
        //dao.Write();
        //dao.Read();

        //CreateNewUser newUser = new CreateNewUser();
        //newUser.create("Henry Dinh", "Henry8354392.");
        AuthenticationDAO dao = new AuthenticationDAO();
        System.out.println(dao.Authenticate("Henry Dinh", "Henry8354392."));




    }
}
