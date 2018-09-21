package com.twu.biblioteca;

class Book {
    private String title;
    private String author;
    private int year;
    private String owner;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    void setOwner(String owner) {
        this.owner = owner;
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
