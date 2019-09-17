package com.company.screens;

import com.company.Models.AccountInfo;
import com.company.Platform.Application;
import com.company.Platform.Screen;
import com.company.io.DAOClass;
import com.company.system.StringMenuBuilder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerScreen implements Screen {
    private AccountInfo userInfo;
    private double amount;
    private String userName;
    private DAOClass dao;

    public CustomerScreen(String userName){
        this.userName = userName;
        this.userInfo = dao.Read(userName);
    }

    @Override
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Welcome! Verify your action below: ");
        String menuText = "";
        menuText = new StringMenuBuilder()
                .addOption("1", "View Balance")
                .addOption("2", "Deposit")
                .addOption("3", "Withdrawal")
                .addOption("4", "Make transfer between accounts at " + app.getTitle())
                .addOption("5", "Apply for a credit line")
                .addOption("6", "Log out")
                .build();
        System.out.println(menuText);
        Screen screen = null;

        try {
            screen = doInput(scanner, userInfo);
        }catch(InputMismatchException ex) {
            System.out.println("Input Mismatch. Please specify your action.");
            screen = new CustomerScreen(this.userName);
        } catch(RuntimeException ex){
            System.out.println(ex);

        }catch(Exception ex) {
            System.out.println(ex);
        }
        return screen;
    }
    public Screen doInput(Scanner scanner, AccountInfo userInfo) throws Exception{
        int choice = scanner.nextInt();
        Screen newScreen = null;
        switch(choice) {
            case 1:
                System.out.println("Your balance is: $" + userInfo.getBalance());
                break;
            case 2:
                System.out.println("Please enter amount: ");
                amount = scanner.nextDouble();
                userInfo.deposit(amount);
                break;
            case 3:
                System.out.println("Please enter amount: ");
                amount = scanner.nextDouble();
                userInfo.withdraw(amount);
                break;
            case 4:
                System.out.println("This function is not available at the moment");
                break;
            case 5:
                System.out.println("This function is not available at the moment.");
                break;
            case 6:
                System.out.println("Log out successful. You are now taken back to the Home Page");
                newScreen = new WelcomeScreen();
                break;
            default:
        }
        return newScreen;
        }


    }


