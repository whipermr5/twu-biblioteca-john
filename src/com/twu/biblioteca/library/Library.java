package com.twu.biblioteca.library;

import com.twu.biblioteca.common.Session;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<Item> items;

    private HashMap<String, String> itemBorrowerMap = new HashMap<>();

    private Session session = new Session();

    public Library() {
        items = Arrays.asList(
                new Book("Test-driven Development: By Example", "Kent Beck", 2002),
                new Book("Refactoring", "Martin Fowler", 1999),
                new Movie("The Day After Tomorrow", 2004, "Roland Emmerich", Rating.SIX),
                new Movie("The Incredibles", 2004, "Brad Bird", Rating.EIGHT)
        );
    }

    public List<Item> getAvailableItems() {
        return items.stream().filter(this::isAvailable).collect(Collectors.toList());
    }

    public List<Item> getItemsBorrowedBy(String borrowerId) {
        return items.stream().filter(item -> borrowerId.equals(getBorrower(item))).collect(Collectors.toList());
    }

    public Item getItem(String itemId) {
        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        return null;
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

    public Session getSession() {
        return session;
    }

    public String getBorrower(Item item) {
        return itemBorrowerMap.get(item.getId());
    }

    private boolean isAvailable(Item item) {
        return !itemBorrowerMap.containsKey(item.getId());
    }
}
