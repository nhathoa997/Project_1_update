package com.company.screens;

import com.company.Models.AccountInfo;
import com.company.Platform.Application;
import com.company.Platform.Screen;
import com.company.data.dao.UserRepositoryImpl;
import com.company.system.StringMenuBuilder;
import services.AccountTransaction;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerScreen implements Screen {
    private AccountInfo userInfo;
    private double amount;
    private String userName;
    private UserRepositoryImpl dao = new UserRepositoryImpl();
    private AccountTransaction transaction = new AccountTransaction();

    public CustomerScreen(String userName) throws SQLException, ClassNotFoundException {
        this.userName = userName;
        userInfo = dao.findUserName(userName);
    }

    @Override
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Welcome! Verify your action below: ");
        String menuText = "";
        menuText = new StringMenuBuilder()
                .addOption("1. ", "View Balance")
                .addOption("2. ", "Deposit")
                .addOption("3. ", "Withdrawal")
                .addOption("4. ", "Make transfer between accounts at " + app.getTitle())
                .addOption("5. ", "Apply for a credit line")
                .addOption("6. ", "View Transaction History")
                .addOption("7. ", "Log out")
                .build();
        System.out.println(menuText);
        Screen screen = null;

        try {
            screen = doInput(scanner, userInfo);
        }catch(InputMismatchException ex) {
            System.out.println("Input Mismatch. Please specify your action.");
            try {
                screen = new CustomerScreen(this.userName);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
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
        char ans;
        boolean invalid = true;
        switch(choice) {
            case 1:
                System.out.println("Your balance is: $" + userInfo.getBalance());
                newScreen = new CustomerScreen(userName);
                break;
            case 2:
                System.out.println("Please enter amount: ");
                amount = scanner.nextDouble();
                transaction.deposit(this.userInfo,amount);
                System.out.println("Would you like to make another transaction? (Y/N)");
                ans = scanner.next().charAt(0);
                while (invalid){
                    switch(ans){
                        case 'Y':
                            newScreen = new CustomerScreen(userName);
                            invalid = false;
                            break;
                        case 'y':
                            newScreen = new CustomerScreen(userName);
                            invalid = false;
                            break;
                        case 'N':
                            System.out.println("Thank you for using Loanly Peoples Bank!");
                            newScreen = new WelcomeScreen();
                            invalid = false;
                            break;
                        case 'n':
                            System.out.println("Thank you for using Loanly Peoples Bank!");
                            newScreen = new WelcomeScreen();
                            invalid = false;
                            break;
                        default:
                            System.out.println("Invalid input. Please re-enter:");
                            ans = scanner.next().charAt(0);
                    }
                }
                break;
            case 3:
                System.out.println("Please enter amount: ");
                amount = scanner.nextDouble();
                transaction.withdrawal(this.userInfo,amount);
                System.out.println("Would you like to make another transaction? (Y/N)");
                ans = scanner.next().charAt(0);
                while (invalid){
                    switch(ans){
                        case 'Y':
                            newScreen = new CustomerScreen(userName);
                            invalid = false;
                            break;
                        case 'y':
                            newScreen = new CustomerScreen(userName);
                            invalid = false;
                            break;
                        case 'N':
                            System.out.println("Thank you for using Loanly Peoples Bank!");
                            newScreen = new WelcomeScreen();
                            invalid = false;
                            break;
                        case 'n':
                            System.out.println("Thank you for using Loanly Peoples Bank!");
                            newScreen = new WelcomeScreen();
                            invalid = false;
                            break;
                        default:
                            System.out.println("Invalid input. Please re-enter:");
                            ans = scanner.next().charAt(0);
                    }
                }
                break;
            case 4:
                System.out.println("This function is not available at the moment");
                newScreen = new CustomerScreen(userName);
                break;
            case 5:
                System.out.println("This function is not available at the moment.");
                newScreen = new CustomerScreen(userName);
                break;
            case 6:
                dao.viewHistory(userName);
                newScreen = new CustomerScreen(userName);
                break;
            case 7:
                System.out.println("Log out successful. You are now taken back to the Home Page");
                newScreen = new WelcomeScreen();
                break;
            default:
                System.out.println("Invalid Input.");
                newScreen = new CustomerScreen(userName);
        }
        return newScreen;
        }
    }


