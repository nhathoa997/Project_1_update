package com.company.screens;

import com.company.Platform.Application;
import com.company.Platform.Screen;
import services.Authentication;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeLoginScreen implements Screen {
    private String userName = "";
    private String password = "";
    private Screen nextScreen;
    private Authentication authService;

    {
        try {
            authService = new Authentication();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Screen doScreen(Scanner scanner, Application app) throws SQLException, ClassNotFoundException {
        System.out.println("Welcome to Employee's Login Page! Please enter your credentials: ");
        System.out.println("User Name: ");
        nextScreen = null;
        while(userName.isEmpty()) {
            userName = scanner.nextLine();
        }
        System.out.println("Password: ");
        while(password.isEmpty()) {
            password = scanner.nextLine();
        }
        if (authService.authenticate(userName,password,"employee")){
            System.out.println("Successfully Authenticate!");
            nextScreen = new EmployeeScreen();
        }
        else{
            System.out.println("Your Account doesn't exist. Please log in again.");
            nextScreen = new EmployeeLoginScreen();
        }
        return nextScreen;
    }

}

