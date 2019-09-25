package com.company.screens;

import com.company.Platform.Application;
import com.company.Platform.Screen;
import com.company.system.StringMenuBuilder;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

//import org.apache.log4j.Logger;

public class WelcomeScreen implements Screen {
    //private final Logger LOG = Logger.getLogger(WelcomeScreen.class);
    @Override
    public Screen doScreen(Scanner scanner, Application app) {
        //LOG.debug("Enter Screen");
        System.out.println("Welcome to " + app.getTitle()+" Are you a customer or an employee?");
        String menuText = "";
        menuText = new StringMenuBuilder()
                .addOption("1. ", "Customer")
                .addOption("2. ", "Employee")
                .build();
        System.out.println(menuText);
        Screen screen = null;
        try{
            screen = doInput(scanner);
        } catch (InputMismatchException ex) {
            System.out.println("Input Mismatch, please enter your role again");
            scanner.next();
            screen = new WelcomeScreen();
        } catch(RuntimeException ex){

        }catch(Exception ex) {

        }
        return screen;
    }

    public Screen doInput(Scanner scanner){
        int i = scanner.nextInt();
        Screen newScreen = null;
        switch (i){
            case 1:
                //LOG.debug("Leaving screen for CustomerScreen");
                try {
                    newScreen = new CustomerLoginScreen();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                //LOG.debug("Leaving screen for EmployeeScreen");
                newScreen = new EmployeeLoginScreen();
                break;
            default:
        }
        return newScreen;
    }

}
