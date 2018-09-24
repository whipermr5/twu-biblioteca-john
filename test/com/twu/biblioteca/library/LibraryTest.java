package com.twu.biblioteca.library;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LibraryTest {

    private static Library library;
    private static Item firstItem;
    private static Item secondItem;

    @Before
    public void setUpLibrary() {
        library = new Library();
        List<Item> items = (List) library.getAvailableBooks();
        firstItem = items.get(0);
        secondItem = items.get(1);
    }

    @Test
    public void testGetAvailableBooks() {
        List<Item> originalItems = (List) library.getAvailableBooks();

        library.checkoutBook(firstItem.getId(), "user");

        assertTrue(originalItems.contains(firstItem));
        assertFalse(library.getAvailableBooks().contains(firstItem));
    }

    @Test
    public void testGetBooksBorrowedBy() {
        assertTrue(library.getBooksBorrowedBy("user").isEmpty());

        library.checkoutBook(firstItem.getId(), "user");
        assertEquals(Collections.singletonList(firstItem), library.getBooksBorrowedBy("user"));

        library.checkoutBook(secondItem.getId(), "user");
        assertEquals(Arrays.asList(firstItem, secondItem), library.getBooksBorrowedBy("user"));

        library.returnBook(firstItem.getId(), "user");
        assertEquals(Collections.singletonList(secondItem), library.getBooksBorrowedBy("user"));
    }

    @Test
    public void testCheckout() {
        List<Item> originalItems = (List) library.getAvailableBooks();
        assertEquals(Arrays.asList(firstItem, secondItem), originalItems);
        assertTrue(library.checkoutBook(firstItem.getId(), "user"));
        assertEquals(Collections.singletonList(secondItem), library.getAvailableBooks());

        assertTrue(library.checkoutBook(secondItem.getId(), "user"));
        assertTrue(library.getAvailableBooks().isEmpty());

        assertFalse(library.checkoutBook(secondItem.getId(), "user"));
    }

    @Test
    public void testReturnBook() {
        library.checkoutBook(firstItem.getId(), "user");
        library.checkoutBook(secondItem.getId(), "user");
        assertEquals(Arrays.asList(firstItem, secondItem), library.getBooksBorrowedBy("user"));
        assertTrue(library.getAvailableBooks().isEmpty());

        assertTrue(library.returnBook(firstItem.getId(), "user"));
        assertEquals(Collections.singletonList(secondItem), library.getBooksBorrowedBy("user"));
        assertEquals(Collections.singletonList(firstItem), library.getAvailableBooks());

        assertTrue(library.returnBook(secondItem.getId(), "user"));
        assertTrue(library.getBooksBorrowedBy("user").isEmpty());
        assertEquals(Arrays.asList(firstItem, secondItem), library.getAvailableBooks());

        assertFalse(library.returnBook(firstItem.getId(), "user"));
    }
}
