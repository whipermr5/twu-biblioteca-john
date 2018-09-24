package com.twu.biblioteca.library;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<Item> items = Arrays.asList(
            new Book("TDD", "Kent", 2002), new Book("Refactoring", "Martin", 1999));

    private HashMap<String, String> itemBorrowerMap = new HashMap<>();

    public List<Item> getAvailableItems() {
        return items.stream().filter(this::isAvailable).collect(Collectors.toList());
    }

    public List<Book> getAvailableBooks() {
        return getAvailableItems().stream().map(Book.class::cast).collect(Collectors.toList());
    }

    public List<Item> getItemsBorrowedBy(String borrowerId) {
        return items.stream().filter(item -> borrowerId.equals(getBorrower(item))).collect(Collectors.toList());
    }

    public List<Book> getBooksBorrowedBy(String borrowerId) {
        return getItemsBorrowedBy(borrowerId).stream().map(Book.class::cast).collect(Collectors.toList());
    }

    public boolean checkoutItem(String itemId, String borrowerId) {
        for (Item item : getAvailableItems()) {
            if (item.getId().equals(itemId)) {
                itemBorrowerMap.put(item.getId(), borrowerId);
                return true;
            }
        }
        return false;
    }

    public boolean returnItem(String itemId, String borrowerId) {
        for (Item item : getItemsBorrowedBy(borrowerId)) {
            if (item.getId().equals(itemId)) {
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
