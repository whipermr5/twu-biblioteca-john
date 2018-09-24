package com.twu.biblioteca.library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void testId() {
        Item item1 = new Book(null, null, 0);
        int book1NumericalId = Integer.parseInt(item1.getId());

        Item item2 = new Book(null, null, 0);
        assertEquals(String.valueOf(book1NumericalId + 1), item2.getId());

        assertEquals(String.valueOf(book1NumericalId), item1.getId());
    }
}
