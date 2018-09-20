package com.twu.biblioteca;

class Book {
    private String title;
    private String author;
    private int year;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
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

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }

        Book otherBook = (Book) other;
        return title.equals(otherBook.title) && author.equals(otherBook.author) && year == otherBook.year;
    }
}
