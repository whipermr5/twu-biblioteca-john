package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.library.Movie;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CheckoutBookCommandTest {

    @Test
    public void testExecute() {
        Library library = new Library();
        Command command = CommandFactory.get(Ui.ID_CHECKOUT);

        Book book = BookCommand.getAvailableBooks(library).iterator().next();
        InputStream in = new ByteArrayInputStream(book.getId().getBytes());
        OutputStream out = new ByteArrayOutputStream();
        String expected = Ui.formatBooksAvailable(BookCommand.getAvailableBooks(library)) + System.lineSeparator()
                + Ui.SELECT_BOOK_CHECKOUT + System.lineSeparator()
                + Ui.CHECKOUT_BOOK_SUCCESS + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());
        assertFalse(BookCommand.getAvailableBooks(library).contains(book));

        in = new ByteArrayInputStream(book.getId().getBytes());
        out = new ByteArrayOutputStream();
        expected = Ui.formatBooksAvailable(BookCommand.getAvailableBooks(library)) + System.lineSeparator()
                + Ui.SELECT_BOOK_CHECKOUT + System.lineSeparator()
                + Ui.CHECKOUT_BOOK_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        Movie movie = MovieCommand.getAvailableMovies(library).iterator().next();
        in = new ByteArrayInputStream(movie.getId().getBytes());
        out = new ByteArrayOutputStream();
        expected = Ui.formatBooksAvailable(BookCommand.getAvailableBooks(library)) + System.lineSeparator()
                + Ui.SELECT_BOOK_CHECKOUT + System.lineSeparator()
                + Ui.CHECKOUT_BOOK_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        Book remainingBook = BookCommand.getAvailableBooks(library).iterator().next();
        in = new ByteArrayInputStream(remainingBook.getId().getBytes());
        out = new ByteArrayOutputStream();
        expected = Ui.formatBooksAvailable(BookCommand.getAvailableBooks(library)) + System.lineSeparator()
                + Ui.SELECT_BOOK_CHECKOUT + System.lineSeparator()
                + Ui.CHECKOUT_BOOK_SUCCESS + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        out = new ByteArrayOutputStream();
        command.execute(library, null, out);
        assertEquals(Ui.NO_BOOKS_AVAILABLE + System.lineSeparator(), out.toString());
    }
}
