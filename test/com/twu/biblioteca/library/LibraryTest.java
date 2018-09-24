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
        List<Item> items = library.getAvailableItems();
        firstItem = items.get(0);
        secondItem = items.get(1);
    }

    @Test
    public void testGetAvailableItems() {
        List<Item> originalItems = library.getAvailableItems();

        library.checkoutItem(firstItem.getId(), "user");

        assertTrue(originalItems.contains(firstItem));
        assertFalse(library.getAvailableItems().contains(firstItem));
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
    public void testCheckoutItem() {
        List<Item> originalItems = library.getAvailableItems();
        assertEquals(Arrays.asList(firstItem, secondItem), originalItems);
        assertTrue(library.checkoutItem(firstItem.getId(), "user"));
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
        assertTrue(library.getAvailableItems().isEmpty());

        assertTrue(library.returnItem(firstItem.getId(), "user"));
        assertEquals(Collections.singletonList(secondItem), library.getItemsBorrowedBy("user"));
        assertEquals(Collections.singletonList(firstItem), library.getAvailableItems());

        assertTrue(library.returnItem(secondItem.getId(), "user"));
        assertTrue(library.getItemsBorrowedBy("user").isEmpty());
        assertEquals(Arrays.asList(firstItem, secondItem), library.getAvailableItems());

        assertFalse(library.returnItem(firstItem.getId(), "user"));
    }
}
