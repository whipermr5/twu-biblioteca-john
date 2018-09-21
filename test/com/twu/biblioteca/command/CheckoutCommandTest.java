package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Book;
import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CheckoutCommandTest {

    @Test
    public void testExecute() {
        Library library = new Library();
        Book book = library.getAvailableBooks().iterator().next();
        InputStream in = new ByteArrayInputStream(book.getId().getBytes());
        OutputStream out = new ByteArrayOutputStream();

        Command command = CommandFactory.get(Ui.ID_CHECKOUT);
        command.execute(library, in, out);
        assertEquals(System.lineSeparator() + Ui.CHECKOUT_SUCCESS + System.lineSeparator(), out.toString());
        assertFalse(library.getAvailableBooks().contains(book));

        in = new ByteArrayInputStream(book.getId().getBytes());
        out = new ByteArrayOutputStream();
        command.execute(library, in, out);
        assertEquals(System.lineSeparator() + Ui.CHECKOUT_FAILURE + System.lineSeparator(), out.toString());
    }
}
