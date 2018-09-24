package com.twu.biblioteca.library;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<Item> items = Arrays.asList(
            new Book("TDD", "Kent", 2002), new Book("Refactoring", "Martin", 1999));

    private HashMap<String, String> itemBorrowerMap = new HashMap<>();

    public List<Book> getAvailableBooks() {
        return items.stream().filter(this::isAvailable).map(Book.class::cast).collect(Collectors.toList());
    }

    public List<Book> getBooksBorrowedBy(String borrowerId) {
        return items.stream().filter(book -> borrowerId.equals(getBorrower(book)))
                .map(Book.class::cast).collect(Collectors.toList());
    }

    public boolean checkout(String bookId, String borrowerId) {
        for (Item item : getAvailableBooks()) {
            if (item.getId().equals(bookId)) {
                itemBorrowerMap.put(item.getId(), borrowerId);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookId, String borrowerId) {
        for (Item item : getBooksBorrowedBy(borrowerId)) {
            if (item.getId().equals(bookId)) {
                itemBorrowerMap.remove(item.getId());
                return true;
            }
        }
        return false;
    }

    private boolean isAvailable(Item item) {
        return !itemBorrowerMap.containsKey(item.getId());
    }

    private String getBorrower(Item item) {
        return itemBorrowerMap.get(item.getId());
    }
}
