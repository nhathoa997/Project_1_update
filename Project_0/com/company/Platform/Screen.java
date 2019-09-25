package com.company.Platform;

import java.sql.SQLException;
import java.util.Scanner;

public interface Screen {
    Screen doScreen(Scanner scanner, Application app) throws SQLException, ClassNotFoundException;
    default void log() {
        System.out.println("Screen.Log");
    }

    default boolean shouldQuit(String input, String flag) {
        return input.equals(flag);
    }
}
