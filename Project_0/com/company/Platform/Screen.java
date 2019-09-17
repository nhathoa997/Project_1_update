package com.company.Platform;

import java.util.Scanner;

public interface Screen {
    Screen doScreen(Scanner scanner, Application app);
    default void log() {
        System.out.println("Screen.Log");
    }

    default boolean shouldQuit(String input, String flag) {
        return input.equals(flag);
    }
}
