package com.twu.biblioteca.common;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Movie;
import com.twu.biblioteca.library.Rating;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UiTest {

    @Test
    public void testGetUserInput() {
        String expectedInput = "Abc def G";
        ByteArrayInputStream inStream = new ByteArrayInputStream(expectedInput.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream outStream = new PrintStream(out);

        String messageToUser = "Message to user";
        String actualInput = Ui.getUserInput(inStream, outStream, messageToUser);
        assertEquals(expectedInput, actualInput);
        assertEquals(messageToUser + System.lineSeparator(), out.toString());
    }

    @Test
    public void testGetUserInputs() {
        String[] expectedInputs = new String[] {"abc", "def"};
        String[] messagesToUser = new String[] {"message 1", "message 2"};

        String combinedInputs = String.join(System.lineSeparator(), expectedInputs);
        ByteArrayInputStream inStream = new ByteArrayInputStream(combinedInputs.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream outStream = new PrintStream(out);

        String[] actualInputs = Ui.getUserInputs(inStream, outStream, messagesToUser);
        assertArrayEquals(expectedInputs, actualInputs);
        String combinedMessagesToUser = String.join("", messagesToUser);
        assertEquals(combinedMessagesToUser + System.lineSeparator(), out.toString());
    }

    @Test
    public void testFormatBooksAvailable() {
        assertNull(Ui.formatBooksAvailable(null));

        assertEquals(Ui.NO_BOOKS_AVAILABLE, Ui.formatBooksAvailable(Collections.emptyList()));

        Book book1 = new Book("TDD", "Kent", 2002);
        Book book2 = new Book("Refactoring", "Martin", 1999);

        assertEquals(Ui.BOOKS_AVAILABLE + Ui.BOOK_LIST_HEADER + expectedFormat(book1),
                Ui.formatBooksAvailable(Collections.singletonList(book1)));

        assertEquals(Ui.BOOKS_AVAILABLE + Ui.BOOK_LIST_HEADER + expectedFormat(book1) + expectedFormat(book2),
                Ui.formatBooksAvailable(Arrays.asList(book1, book2)));
    }

    @Test
    public void testFormatBooksCheckedOut() {
        assertEquals(Ui.NO_BOOKS_CHECKED_OUT, Ui.formatBooksCheckedOut(Collections.emptyList()));

        Book book = new Book("TDD", "Kent", 2002);

        assertEquals(Ui.BOOKS_CHECKED_OUT + Ui.BOOK_LIST_HEADER + expectedFormat(book),
                Ui.formatBooksCheckedOut(Collections.singletonList(book)));
    }

    @Test
    public void testFormatMoviesAvailable() {
        assertNull(Ui.formatMoviesAvailable(null));

        assertEquals(Ui.NO_MOVIES_AVAILABLE, Ui.formatMoviesAvailable(Collections.emptyList()));

        Movie movie = new Movie("TDAD", 2004, "Roland", Rating.UNRATED);

        assertEquals(Ui.MOVIES_AVAILABLE + Ui.MOVIE_LIST_HEADER + expectedFormat(movie),
                Ui.formatMoviesAvailable(Collections.singletonList(movie)));
    }

    @Test
    public void testFormatMoviesCheckedOut() {
        assertEquals(Ui.NO_MOVIES_CHECKED_OUT, Ui.formatMoviesCheckedOut(Collections.emptyList()));

        Movie movie = new Movie("TDAD", 2004, "Roland", Rating.UNRATED);

        assertEquals(Ui.MOVIES_CHECKED_OUT + Ui.MOVIE_LIST_HEADER + expectedFormat(movie),
                Ui.formatMoviesCheckedOut(Collections.singletonList(movie)));
    }

    private static String expectedFormat(Book book) {
        return String.format(Ui.BOOK_DETAILS_FORMAT_STRING,
                book.getId(), book.getTitle(), book.getAuthor(), book.getYear());
    }

    private static String expectedFormat(Movie movie) {
        return String.format(Ui.MOVIE_DETAILS_FORMAT_STRING,
                movie.getId(), movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating());
    }
}
