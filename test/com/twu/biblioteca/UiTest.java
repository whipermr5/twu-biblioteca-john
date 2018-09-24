package com.twu.biblioteca;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Movie;
import com.twu.biblioteca.library.Rating;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UiTest {

    @Test
    public void testGetUserInput() {
        String expectedInput = "Abc def G";
        ByteArrayInputStream inStream = new ByteArrayInputStream(expectedInput.getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        String messageToUser = "Message to user";
        String actualInput = Ui.getUserInput(inStream, outStream, messageToUser);
        assertEquals(expectedInput, actualInput);
        assertEquals(messageToUser + System.lineSeparator(), outStream.toString());
    }

    @Test
    public void testFormatBookList() {
        assertNull(Ui.formatBookList(null));

        assertEquals(Ui.NO_BOOKS_AVAILABLE, Ui.formatBookList(Collections.emptyList()));

        Book book1 = new Book("TDD", "Kent", 2002);
        Book book2 = new Book("Refactoring", "Martin", 1999);

        assertEquals(Ui.BOOK_LIST_HEADER + expectedFormat(book1),
                Ui.formatBookList(Collections.singletonList(book1)));

        assertEquals(Ui.BOOK_LIST_HEADER + expectedFormat(book1) + expectedFormat(book2),
                Ui.formatBookList(Arrays.asList(book1, book2)));
    }

    @Test
    public void testFormatMovieList() {
        assertNull(Ui.formatMovieList(null));

        assertEquals(Ui.NO_MOVIES, Ui.formatMovieList(Collections.emptyList()));

        Movie movie = new Movie("TDAD", 2004, "Roland", Rating.UNRATED);

        assertEquals(Ui.MOVIE_LIST_HEADER + expectedFormat(movie),
                Ui.formatMovieList(Collections.singletonList(movie)));
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
