package com.twu.biblioteca.library;

public class Book {
    private static int count;

    private int id;
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.id = ++count;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getId() {
        return Integer.toString(id);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
