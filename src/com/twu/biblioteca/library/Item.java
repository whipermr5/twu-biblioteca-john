package com.twu.biblioteca.library;

public abstract class Item {

    private static int count;
    private int id;

    Item() {
        this.id = ++count;
    }

    public String getId() {
        return Integer.toString(id);
    }
}
