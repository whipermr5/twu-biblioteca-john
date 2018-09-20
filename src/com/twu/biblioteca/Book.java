package com.twu.biblioteca;

class Book {
    private String title;

    Book(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }

        Book otherBook = (Book) other;
        return title.equals(otherBook.title);
    }
}
