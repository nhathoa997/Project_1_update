package com.company.system;

import com.company.Platform.Application;
import com.company.Platform.Screen;
import com.company.screens.WelcomeScreen;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//import org.apache.log4j.Logger;

public class BankApplication extends Application{
    private Screen currentScreen;
    private Scanner scanner;
    private Map<String, Object> serviceContext;
    //private final Logger LOG = Logger.getLogger(BankApplication.class);

    public BankApplication(){
        currentScreen = new WelcomeScreen();
        scanner = new Scanner(System.in);
        serviceContext = new HashMap<>();
    }
    public BankApplication(String title) {
        this.bank_title = title;
    }

    @Override
    public void run(String[] args) throws SQLException, ClassNotFoundException {
        //LOG.debug("Application Startup");
        //LOG.info("Application Startup");
        //initContext();
        while(currentScreen != null) {
            currentScreen = currentScreen.doScreen(scanner, this);
        }
    }

}
