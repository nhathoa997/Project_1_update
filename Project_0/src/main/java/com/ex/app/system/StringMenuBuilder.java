package com.ex.app.system;

import com.ex.platform.MenuBuilder;

public class StringMenuBuilder implements MenuBuilder {
    private StringBuilder state;
    private String delimiter = "\n";

    public StringMenuBuilder() {
        state = new StringBuilder();
    }

    @Override
    public String build() {
        return state.toString();
    }

    /*
        add an option to the state with the following format
        key. value delimiter
        addOption("1", "Exit")
        1. Exit

     */
    public StringMenuBuilder addOption(String key, String value) {
        state.append(String.format("%s. %s %s", key, value, delimiter));
        return this; //**
    }
}

