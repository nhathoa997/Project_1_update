package com.ex.app.screens;

import com.ex.app.system.StringMenuBuilder;
import com.ex.platform.Application;
import com.ex.platform.Screen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomeScreen implements Screen {
    @Override
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Welcome to " + app.getTitle());
        String menuText = "";
        menuText = new StringMenuBuilder()
                .addOption("1", "Login")
                .addOption("2", "Exit")
                .build();

        System.out.println(menuText);
        Screen screen = null;

        try {
            screen = doInput(scanner); //***
        }catch(InputMismatchException ex) {
            System.out.println("Input Mismatch");
            scanner.next();
            screen = new WelcomeScreen();
        } catch(RuntimeException ex){

        }catch(Exception ex) {

        } finally {
            //will always run
            System.out.println("Finally");
        }

        return screen;
    }

    private Screen doInput(Scanner scanner) throws Exception {
        int i = scanner.nextInt();
        Screen newScreen = null;

        switch (i) {
            case 1:
                newScreen = new LoginScreen();
                break;
            case 2:
            default:
        }
        return newScreen;
    }
}

