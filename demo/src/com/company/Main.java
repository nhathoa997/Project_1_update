package com.company;
import com.company.comparable.Book;
public class Main {

    public static void main(String[] args) {
        Book b1 = new Book("My Book", null, "123456789-1");
	    Book b2 = new Book("My Book", null, "123456789-1");
        Book[] books = new Book[]{b1,b2};

    }
}
