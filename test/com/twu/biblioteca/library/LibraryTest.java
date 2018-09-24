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
    private static Item thirdItem;

    @Before
    public void setUpLibrary() {
        library = new Library();
        List<Item> items = library.getAvailableItems();
        firstItem = items.get(0);
        secondItem = items.get(1);
        thirdItem = items.get(2);
    }

    @Test
    public void testGetAvailableItems() {
        List<Item> originalItems = library.getAvailableItems();

        library.checkoutItem(firstItem.getId(), "user");

        assertTrue(originalItems.contains(firstItem));
        assertEquals(Arrays.asList(secondItem, thirdItem), library.getAvailableItems());
    }

    @Test
    public void testGetAvailableBooks() {
        assertEquals(Arrays.asList(firstItem, secondItem), library.getAvailableBooks());
        assertTrue(library.getAvailableItems().contains(firstItem));
        assertTrue(library.getAvailableItems().contains(secondItem));
    }

    @Test
    public void testGetAvailableMovies() {
        assertEquals(Collections.singletonList(thirdItem), library.getAvailableMovies());
        assertTrue(library.getAvailableItems().contains(thirdItem));
    }

    @Test
    public void testGetItemsBorrowedBy() {
        assertTrue(library.getItemsBorrowedBy("user").isEmpty());

        library.checkoutItem(firstItem.getId(), "user");
        assertEquals(Collections.singletonList(firstItem), library.getItemsBorrowedBy("user"));

        library.checkoutItem(secondItem.getId(), "user");
        assertEquals(Arrays.asList(firstItem, secondItem), library.getItemsBorrowedBy("user"));

        library.returnItem(firstItem.getId(), "user");
        assertEquals(Collections.singletonList(secondItem), library.getItemsBorrowedBy("user"));
    }

    @Test
    public void testGetBooksBorrowedBy() {
        library.checkoutItem(thirdItem.getId(), "user");
        assertTrue(library.getBooksBorrowedBy("user").isEmpty());

        library.checkoutItem(firstItem.getId(), "user");
        assertEquals(Collections.singletonList(firstItem), library.getBooksBorrowedBy("user"));
    }

    @Test
    public void testGetMoviesBorrowedBy() {
        library.checkoutItem(firstItem.getId(), "user");
        assertTrue(library.getMoviesBorrowedBy("user").isEmpty());

        library.checkoutItem(thirdItem.getId(), "user");
        assertEquals(Collections.singletonList(thirdItem), library.getMoviesBorrowedBy("user"));
    }

    @Test
    public void testCheckoutItem() {
        List<Item> originalItems = library.getAvailableItems();
        assertEquals(Arrays.asList(firstItem, secondItem, thirdItem), originalItems);

        assertTrue(library.checkoutItem(firstItem.getId(), "user"));
        assertEquals(Arrays.asList(secondItem, thirdItem), library.getAvailableItems());

        assertTrue(library.checkoutItem(thirdItem.getId(), "user"));
        assertEquals(Collections.singletonList(secondItem), library.getAvailableItems());

        assertTrue(library.checkoutItem(secondItem.getId(), "user"));
        assertTrue(library.getAvailableItems().isEmpty());

        assertFalse(library.checkoutItem(secondItem.getId(), "user"));
    }

    @Test
    public void testReturnItem() {
        library.checkoutItem(firstItem.getId(), "user");
        library.checkoutItem(secondItem.getId(), "user");
        assertEquals(Arrays.asList(firstItem, secondItem), library.getItemsBorrowedBy("user"));
        assertEquals(Collections.singletonList(thirdItem), library.getAvailableItems());

        assertTrue(library.returnItem(firstItem.getId(), "user"));
        assertEquals(Collections.singletonList(secondItem), library.getItemsBorrowedBy("user"));
        assertEquals(Arrays.asList(firstItem, thirdItem), library.getAvailableItems());

        assertTrue(library.returnItem(secondItem.getId(), "user"));
        assertTrue(library.getItemsBorrowedBy("user").isEmpty());
        assertEquals(Arrays.asList(firstItem, secondItem, thirdItem), library.getAvailableItems());

        assertFalse(library.returnItem(firstItem.getId(), "user"));
    }
}
