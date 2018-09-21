package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UiTest {

    private static final String BOOK1_TITLE = "TDD";
    private static final String BOOK1_AUTHOR = "Kent";
    private static final int BOOK1_YEAR = 2002;

    private static final String BOOK2_TITLE = "Refactoring";
    private static final String BOOK2_AUTHOR = "Martin";
    private static final int BOOK2_YEAR = 1999;

    @Test
    public void testGetUserInput() {
        String expectedInput = "Abc def G";
        ByteArrayInputStream inStream = new ByteArrayInputStream(expectedInput.getBytes());
        String actualInput = Ui.getUserInput(inStream);
        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void testFormatBookList() {
        assertNull(Ui.formatBookList(null));

        assertEquals(Ui.NO_BOOKS, Ui.formatBookList(Collections.emptyList()));

        assertEquals(Ui.BOOK_LIST_HEADER
                        + String.format(Ui.BOOK_DETAILS_FORMAT_STRING, BOOK1_TITLE, BOOK1_AUTHOR, BOOK1_YEAR),
                Ui.formatBookList(Collections.singletonList(new Book(BOOK1_TITLE, BOOK1_AUTHOR, BOOK1_YEAR))));

        assertEquals(Ui.BOOK_LIST_HEADER
                        + String.format(Ui.BOOK_DETAILS_FORMAT_STRING, BOOK1_TITLE, BOOK1_AUTHOR, BOOK1_YEAR)
                        + String.format(Ui.BOOK_DETAILS_FORMAT_STRING, BOOK2_TITLE, BOOK2_AUTHOR, BOOK2_YEAR),
                Ui.formatBookList(Arrays.asList(
                        new Book(BOOK1_TITLE, BOOK1_AUTHOR, BOOK1_YEAR),
                        new Book(BOOK2_TITLE, BOOK2_AUTHOR, BOOK2_YEAR))));
    }
}
