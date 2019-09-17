package com.ex.app.system;

import com.ex.app.screens.WelcomeScreen;
import com.ex.platform.Application;
import com.ex.platform.Screen;

import java.util.Scanner;

public class BookstoreApplication extends Application {

    private Screen currentScreen;
    private Scanner scanner;

    public BookstoreApplication() {
        currentScreen = new WelcomeScreen();
        scanner = new Scanner(System.in);
    }

    @Override
    public void run(String[] args) {
        while(currentScreen != null) {//***
            currentScreen = currentScreen.doScreen(scanner, this); //***
        }
    }
}

