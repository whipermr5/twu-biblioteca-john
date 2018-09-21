package com.twu.biblioteca.common;

class Book {
    private static int count;

    private int id;
    private String title;
    private String author;
    private int year;
    private String owner;

    Book(String title, String author, int year) {
        this.id = ++count;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    void setOwner(String owner) {
        this.owner = owner;
    }

    int getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    int getYear() {
        return year;
    }

    String getOwner() {
        return owner;
    }

    boolean isAvailable() {
        return owner == null;
    }
}
