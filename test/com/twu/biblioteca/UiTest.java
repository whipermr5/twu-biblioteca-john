package com.twu.biblioteca;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UiTest {

    private static final String NO_BOOKS = "No books!";

    private static final String BOOK_DETAILS_FORMAT_STRING = "%n%-40s | %-20s | %4s";

    private static final String BOOK_LIST_HEADER = "Books:"
            + String.format(BOOK_DETAILS_FORMAT_STRING, "Title", "Author", "Year")
            + "\n----------------------------------------------------------------------";

    private static final String BOOK1_TITLE = "TDD";
    private static final String BOOK1_AUTHOR = "Kent";
    private static final int BOOK1_YEAR = 2002;

    private static final String BOOK2_TITLE = "Refactoring";
    private static final String BOOK2_AUTHOR = "Martin";
    private static final int BOOK2_YEAR = 1999;

    @Test
    public void testFormatBookList() {
        assertNull(Ui.formatBookList(null));

        assertEquals(NO_BOOKS, Ui.formatBookList(Collections.emptyList()));

        assertEquals(BOOK_LIST_HEADER
                        + String.format(BOOK_DETAILS_FORMAT_STRING, BOOK1_TITLE, BOOK1_AUTHOR, BOOK1_YEAR),
                Ui.formatBookList(Collections.singletonList(new Book(BOOK1_TITLE, BOOK1_AUTHOR, BOOK1_YEAR))));

        assertEquals(BOOK_LIST_HEADER
                        + String.format(BOOK_DETAILS_FORMAT_STRING, BOOK1_TITLE, BOOK1_AUTHOR, BOOK1_YEAR)
                        + String.format(BOOK_DETAILS_FORMAT_STRING, BOOK2_TITLE, BOOK2_AUTHOR, BOOK2_YEAR),
                Ui.formatBookList(Arrays.asList(
                        new Book(BOOK1_TITLE, BOOK1_AUTHOR, BOOK1_YEAR),
                        new Book(BOOK2_TITLE, BOOK2_AUTHOR, BOOK2_YEAR))));
    }
}
