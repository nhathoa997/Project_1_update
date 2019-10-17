package com.company.comparable;

public class Book implements Comparable<Book>{
    private String title;
    private String[] authors;
    private String isbn;

    public Book(String title, String[] authors, String isbn){
        this.authors = authors;
        this.title = title;
        this.isbn = isbn;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book that) {
        return this.isbn.compareTo(that.isbn);
    }
}
