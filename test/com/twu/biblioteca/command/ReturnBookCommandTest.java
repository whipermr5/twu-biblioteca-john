package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.Ui;
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
        Book firstBook = library.getAvailableBooks().get(0);
        Book secondBook = library.getAvailableBooks().get(1);

        OutputStream out = new ByteArrayOutputStream();

        Command command = CommandFactory.get(Ui.ID_RETURN);
        command.execute(library, null, out);
        assertEquals(Ui.NO_BOOKS_CHECKED_OUT + System.lineSeparator(), out.toString());

        library.checkoutItem(firstBook.getId(), "user");
        assertEquals(Collections.singletonList(firstBook), library.getBooksBorrowedBy("user"));

        InputStream in = new ByteArrayInputStream(secondBook.getId().getBytes());
        out = new ByteArrayOutputStream();

        String expected = Ui.formatBooksCheckedOut(
                library.getBooksBorrowedBy("user")) + System.lineSeparator()
                + Ui.SELECT_BOOK_RETURN + System.lineSeparator()
                + Ui.RETURN_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        in = new ByteArrayInputStream(firstBook.getId().getBytes());
        out = new ByteArrayOutputStream();

        expected = Ui.formatBooksCheckedOut(
                library.getBooksBorrowedBy("user")) + System.lineSeparator()
                + Ui.SELECT_BOOK_RETURN + System.lineSeparator()
                + Ui.RETURN_SUCCESS + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());
        assertFalse(library.getBooksBorrowedBy("user").contains(firstBook));
    }
}
