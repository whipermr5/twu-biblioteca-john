package com.twu.biblioteca.library;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<Book> books = Arrays.asList(
            new Book("TDD", "Kent", 2002), new Book("Refactoring", "Martin", 1999));

    private HashMap<String, String> itemBorrowerMap = new HashMap<>();

    public List<Book> getAvailableBooks() {
        return books.stream().filter(this::isAvailable).collect(Collectors.toList());
    }

    public List<Book> getCustomerBooks(String ownerId) {
        return books.stream().filter(book -> ownerId.equals(getBorrower(book))).collect(Collectors.toList());
    }

    public boolean checkout(String bookId, String ownerId) {
        for (Book book : getAvailableBooks()) {
            if (book.getId().equals(bookId)) {
                itemBorrowerMap.put(book.getId(), ownerId);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookId, String ownerId) {
        for (Book book : getCustomerBooks(ownerId)) {
            if (book.getId().equals(bookId)) {
                itemBorrowerMap.remove(book.getId());
                return true;
            }
        }
        return false;
    }

    private boolean isAvailable(Book book) {
        return !itemBorrowerMap.containsKey(book.getId());
    }

    private String getBorrower(Book book) {
        return itemBorrowerMap.get(book.getId());
    }
}
