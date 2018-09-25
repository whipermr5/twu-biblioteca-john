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
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReturnBookCommandTest {

    @Test
    public void testExecute() {
        Library library = new Library();
        Command command = CommandFactory.get(Ui.ID_RETURN_BOOK);

        String credentials = "invalid username" + System.lineSeparator() + "some password";
        InputStream in = new ByteArrayInputStream(credentials.getBytes());
        OutputStream out = new ByteArrayOutputStream();
        String expected = Ui.LOGIN_PROMPT_USERNAME + Ui.LOGIN_PROMPT_PASSWORD + System.lineSeparator()
                + Ui.LOGIN_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        String username = "valid username";
        assertTrue(library.getSession().login(username, "valid password"));

        Book firstBook = BookCommand.getAvailableBooks(library).get(0);
        Book secondBook = BookCommand.getAvailableBooks(library).get(1);
        out = new ByteArrayOutputStream();
        command.execute(library, null, out);
        assertEquals(Ui.NO_BOOKS_CHECKED_OUT + System.lineSeparator(), out.toString());

        library.checkoutItem(firstBook.getId(), username);
        assertEquals(Collections.singletonList(firstBook), BookCommand.getBooksBorrowedBy(library, username));
        in = new ByteArrayInputStream(secondBook.getId().getBytes());
        out = new ByteArrayOutputStream();
        expected = Ui.formatBooksCheckedOut(
                BookCommand.getBooksBorrowedBy(library, username)) + System.lineSeparator()
                + Ui.SELECT_BOOK_RETURN + System.lineSeparator()
                + Ui.RETURN_BOOK_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        Movie movie = MovieCommand.getAvailableMovies(library).iterator().next();
        library.checkoutItem(movie.getId(), username);
        in = new ByteArrayInputStream(movie.getId().getBytes());
        out = new ByteArrayOutputStream();
        expected = Ui.formatBooksCheckedOut(
                BookCommand.getBooksBorrowedBy(library, username)) + System.lineSeparator()
                + Ui.SELECT_BOOK_RETURN + System.lineSeparator()
                + Ui.RETURN_BOOK_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        in = new ByteArrayInputStream(firstBook.getId().getBytes());
        out = new ByteArrayOutputStream();
        expected = Ui.formatBooksCheckedOut(
                BookCommand.getBooksBorrowedBy(library, username)) + System.lineSeparator()
                + Ui.SELECT_BOOK_RETURN + System.lineSeparator()
                + Ui.RETURN_BOOK_SUCCESS + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());
        assertFalse(BookCommand.getBooksBorrowedBy(library, username).contains(firstBook));
    }
}
