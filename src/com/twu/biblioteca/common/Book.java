package com.twu.biblioteca.common;

public class Book {
    private static int count;

    private int id;
    private String title;
    private String author;
    private int year;
    private String owner;

    public Book(String title, String author, int year) {
        this.id = ++count;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
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

    public String getOwner() {
        return owner;
    }

    public boolean isAvailable() {
        return owner == null;
    }
}
