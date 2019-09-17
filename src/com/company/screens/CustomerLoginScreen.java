package com.company.screens;

import com.company.Platform.Application;
import com.company.Platform.Screen;
import com.company.system.Session;
import services.CustomerAuthentication;

import java.util.Scanner;

public class CustomerLoginScreen implements Screen {
    private String userName = "";
    private String password = "";
    private Screen nextScreen;
    private Session session;
    private CustomerAuthentication authService;



    @Override
    public Screen doScreen(Scanner scanner, Application app) {
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
        if (authService.authenticate(userName,password)){
            nextScreen = new CustomerScreen(userName);
        }
        else{
            System.out.println("Your Account doesn't exist. Please log in again.");
            nextScreen = new CustomerLoginScreen();
        }
        return nextScreen;
    }

}
