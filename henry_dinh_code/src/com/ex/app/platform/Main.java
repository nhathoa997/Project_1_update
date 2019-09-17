package com.ex.models;
import com.ex.models.Book;
import com.ex.models.platform.Application;
import com.ex.models.platform.TestClass;

public class Main {



    public static void main(String[] args) {
        Application app = new TestClass();
        app.setTitle("My Application");
        app.run(args);

    }
}
