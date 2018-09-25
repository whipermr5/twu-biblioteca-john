package com.twu.biblioteca.library;

import com.twu.biblioteca.common.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class LibraryTest {

    private static Library library;
    private static Item firstItem;
    private static Item secondItem;
    private static Item thirdItem;
    private static Item fourthItem;

    @Before
    public void setUpLibrary() {
        library = new Library();
        List<Item> items = library.getAvailableItems();
        firstItem = items.get(0);
        secondItem = items.get(1);
        thirdItem = items.get(2);
        fourthItem = items.get(3);
    }

    @Test
    public void testGetAvailableItems() {
        List<Item> originalItems = library.getAvailableItems();

        library.checkoutItem(firstItem.getId(), "user");

        assertTrue(originalItems.contains(firstItem));
        assertEquals(Arrays.asList(secondItem, thirdItem, fourthItem), library.getAvailableItems());
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
    public void testGetItem() {
        assertEquals(firstItem, library.getItem(firstItem.getId()));
        assertNull(library.getItem(""));
    }

    @Test
    public void testCheckoutItem() {
        List<Item> originalItems = library.getAvailableItems();
        assertEquals(Arrays.asList(firstItem, secondItem, thirdItem, fourthItem), originalItems);

        assertTrue(library.checkoutItem(fourthItem.getId(), "user"));
        assertEquals(Arrays.asList(firstItem, secondItem, thirdItem), library.getAvailableItems());

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
        assertEquals(Arrays.asList(thirdItem, fourthItem), library.getAvailableItems());

        assertTrue(library.returnItem(firstItem.getId(), "user"));
        assertEquals(Collections.singletonList(secondItem), library.getItemsBorrowedBy("user"));
        assertEquals(Arrays.asList(firstItem, thirdItem, fourthItem), library.getAvailableItems());

        assertTrue(library.returnItem(secondItem.getId(), "user"));
        assertTrue(library.getItemsBorrowedBy("user").isEmpty());
        assertEquals(Arrays.asList(firstItem, secondItem, thirdItem, fourthItem), library.getAvailableItems());

        assertFalse(library.returnItem(firstItem.getId(), "user"));
    }

    @Test
    public void testGetSession() {
        Session session1 = library.getSession();
        assertNotNull(session1);

        Session session2 = library.getSession();
        assertEquals(session1, session2);
    }
}
