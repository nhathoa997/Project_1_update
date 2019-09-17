package com.ex.app.screens;

import com.ex.platform.Application;
import com.ex.platform.Screen;

import java.util.Scanner;

public class LoginScreen implements Screen {
    @Override
    public Screen doScreen(Scanner scanner, Application app) {
        System.out.println("Please enter your credentials");
        return null;
    }
}

