package com.company.screens;

import com.company.Platform.Application;
import com.company.Platform.Screen;
import services.Authentication;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerLoginScreen implements Screen {
    private String userName = "";
    private String password = "";
    private Screen nextScreen;
    private Authentication authService = new Authentication();

    public CustomerLoginScreen() throws SQLException, ClassNotFoundException {
    }


    @Override
    public Screen doScreen(Scanner scanner, Application app) throws SQLException, ClassNotFoundException {
        System.out.println("Welcome to Customer's Login Page! Please enter your credentials: ");
        System.out.println("User Name: ");
        nextScreen = null;
        while(userName.isEmpty()) {
            userName = scanner.nextLine();
        }
        System.out.println("Password: ");
        while(password.isEmpty()) {
            password = scanner.nextLine();
        }
        if (authService.authenticate(userName,password,"customer")){
            System.out.println("Successfully Authenticate!");
            try {
                nextScreen = new CustomerScreen(userName);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (!authService.authenticate(userName,password,"customer")){
            System.out.println("Your Account doesn't exist. Please log in again.");
            try {
                nextScreen = new CustomerLoginScreen();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return nextScreen;
    }
}
