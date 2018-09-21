package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Book;
import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CheckoutCommandTest {

    @Test
    public void testExecute() {
        Library library = new Library();
        Book book = library.getAvailableBooks().iterator().next();
        InputStream in = new ByteArrayInputStream(book.getId().getBytes());

        Command command = CommandFactory.get(Ui.ID_CHECKOUT);
        String output = command.execute(library, in);
        assertEquals(Ui.CHECKOUT_SUCCESS, output);
        assertFalse(library.getAvailableBooks().contains(book));

        in = new ByteArrayInputStream(book.getId().getBytes());
        output = command.execute(library, in);
        assertEquals(Ui.CHECKOUT_FAILURE, output);
    }
}
