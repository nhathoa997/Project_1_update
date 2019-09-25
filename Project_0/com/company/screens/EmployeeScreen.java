package com.company.screens;

import com.company.Platform.Application;
import com.company.Platform.Screen;
import com.company.io.DAOClass;
import com.company.system.StringMenuBuilder;
import services.Authentication;
import services.CreateNewUser;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeScreen implements Screen {
    private DAOClass dao = new DAOClass();
    private String userName = "";
    private String password = "";
    private CreateNewUser newUser;
    private Authentication auth;

    {
        try {
            auth = new Authentication();
            newUser = new CreateNewUser();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Welcome! Verify your action below: ");
        String menuText = "";
        menuText = new StringMenuBuilder()
                .addOption("1. ", "Create New Customer Account")
                .addOption("2. ", "Open New Credit Line")
                .addOption("3. ", "Log out")
                .build();
        System.out.println(menuText);
        Screen screen = null;

        try {
            screen = doInput(scanner);
        }catch(InputMismatchException ex) {
            System.out.println("Input Mismatch. Please specify your action.");
            screen = new EmployeeScreen();
        } catch(RuntimeException ex){
            System.out.println(ex);

        }catch(Exception ex) {
            System.out.println(ex);
        }
        return screen;
    }
    public Screen doInput(Scanner scanner) throws Exception{
        Screen newScreen = null;
        boolean invalid = true;
        while (invalid){
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter Customer's User Name: ");
                    while(userName.isEmpty()) {
                        userName = scanner.nextLine();
                    }
                    System.out.println("Password: ");
                    while(password.isEmpty()) {
                        password = scanner.nextLine();
                    }
                    do{
                        System.out.println("User Name has been taken. Please enter a different User Name: ");
                        userName = scanner.nextLine();
                        System.out.println("Password: ");
                        password = scanner.nextLine();
                    }while(auth.authenticate(userName,password,"customer"));
                    newUser.create(userName,password);
                    invalid = false;
                    newScreen = new EmployeeScreen();
                    break;
                case 2:
                    System.out.println("Feature is still being developed");
//                    this.userName = scanner.next();
//                    while(dao.Read(this.userName) == null){
//                        if (dao.Read(this.userName) != null) break;
//                        System.out.println("Invalid User Name. Try again: ");
//                        this.userName = scanner.next();
//                    }
//                    invalid = false;
//                    newScreen = new EmployeeScreen();
//                    dao.Read(this.userName).getUserInfo();
                    break;
                case 3:
                    System.out.println("Log out successful");
                    invalid = false;
                    newScreen = new WelcomeScreen();
                    break;
                default:
                    System.out.println("Not a valid input. Please enter a valid choice.");
                    break;
            }
        }

        return newScreen;
    }

}
