package com.ex;
import com.ex.app.system.BookstoreApplication;
import com.ex.platform.Application;
import com.ex.platform.TestClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static String className;
    private static String appTitle;

    public static void main(String[] args) {
        String[] config = loadConfig();
        parseArgs(config);
        Application app = init(className, appTitle);

        app.run(args);
    }

    private static String[] loadConfig() {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader("app.properties");
            br = new BufferedReader(fr);
            String[] args = new String[100];
            String line;
            int lineCount = 0;

            while((line = br.readLine()) != null) {
                args[lineCount++] = line; //***
            }

            return args;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return new String[]{};
    }

    private static void parseArgs(String[] args) {
        for(String s : args) {
            if(s != null) {
                String[] tokens = s.split("=");
                String key = tokens[0];
                String value = tokens[1];

                if("rootApp".equals(key)) {
                    className = value;

                } else if("title".equals(key)) {
                    appTitle = value;
                }
            }
        }
    }

    private static Application init(String className) {
        Object o;
        try {
            Class clazz = Class.forName(className); //***
            o = clazz.newInstance();
            return (Application)o;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Application init(String className, String title) {
        Application a = init(className);

        if(a != null) {
            try {
                Method setTitleMethod = a.getClass().getMethod("setTitle", String.class); //***
                if(setTitleMethod != null) {
                    setTitleMethod.invoke(a, appTitle);
                    // a.setTitle(appTitle)
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return a;
    }
}

