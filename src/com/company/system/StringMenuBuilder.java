package com.company.system;

import com.company.Platform.MenuBuilder;


import java.util.SortedMap;
import java.util.TreeMap;

public class StringMenuBuilder implements MenuBuilder {
    private SortedMap<String, String> menuMap = new TreeMap<>();
    private StringBuilder state;
    private String delimiter = "\n";


    public StringMenuBuilder() {
        state = new StringBuilder();
    }
    @Override
    public java.lang.String build() {
        return state.toString();
    }
    public StringMenuBuilder addOption(String key, String value) {
        state.append(String.format("%s. %s %s", key, value, delimiter));
        return this;
    }


}
