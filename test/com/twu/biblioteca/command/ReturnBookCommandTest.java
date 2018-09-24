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

public class ReturnBookCommandTest {

    @Test
    public void testExecute() {
        Library library = new Library();
        Book firstBook = BookCommand.getAvailableBooks(library).get(0);
        Book secondBook = BookCommand.getAvailableBooks(library).get(1);

        OutputStream out = new ByteArrayOutputStream();

        Command command = CommandFactory.get(Ui.ID_RETURN);
        command.execute(library, null, out);
        assertEquals(Ui.NO_BOOKS_CHECKED_OUT + System.lineSeparator(), out.toString());

        library.checkoutItem(firstBook.getId(), "user");
        assertEquals(Collections.singletonList(firstBook), BookCommand.getBooksBorrowedBy(library, "user"));

        InputStream in = new ByteArrayInputStream(secondBook.getId().getBytes());
        out = new ByteArrayOutputStream();

        String expected = Ui.formatBooksCheckedOut(
                BookCommand.getBooksBorrowedBy(library, "user")) + System.lineSeparator()
                + Ui.SELECT_BOOK_RETURN + System.lineSeparator()
                + Ui.RETURN_BOOK_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        Movie movie = MovieCommand.getAvailableMovies(library).iterator().next();
        library.checkoutItem(movie.getId(), "user");

        in = new ByteArrayInputStream(movie.getId().getBytes());
        out = new ByteArrayOutputStream();

        expected = Ui.formatBooksCheckedOut(
                BookCommand.getBooksBorrowedBy(library, "user")) + System.lineSeparator()
                + Ui.SELECT_BOOK_RETURN + System.lineSeparator()
                + Ui.RETURN_BOOK_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        in = new ByteArrayInputStream(firstBook.getId().getBytes());
        out = new ByteArrayOutputStream();

        expected = Ui.formatBooksCheckedOut(
                BookCommand.getBooksBorrowedBy(library, "user")) + System.lineSeparator()
                + Ui.SELECT_BOOK_RETURN + System.lineSeparator()
                + Ui.RETURN_BOOK_SUCCESS + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());
        assertFalse(BookCommand.getBooksBorrowedBy(library, "user").contains(firstBook));
    }
}
