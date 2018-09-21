package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Book;
import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ReturnCommandTest {

    @Test
    public void testExecute() {
        Library library = new Library();
        Book book = library.getAvailableBooks().iterator().next();

        library.checkout(book.getId(), "user");
        assertEquals(Collections.singletonList(book), library.getCustomerBooks("user"));

        InputStream in = new ByteArrayInputStream(book.getId().getBytes());
        OutputStream out = new ByteArrayOutputStream();

        Command command = CommandFactory.get(Ui.ID_RETURN);
        String expected = Ui.formatBookList(library.getCustomerBooks("user")) + System.lineSeparator()
                + Ui.SELECT_BOOK + System.lineSeparator()
                + Ui.RETURN_SUCCESS + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());
        assertFalse(library.getCustomerBooks("user").contains(book));

        in = new ByteArrayInputStream(book.getId().getBytes());
        out = new ByteArrayOutputStream();
        expected = Ui.formatBookList(library.getCustomerBooks("user")) + System.lineSeparator()
                + Ui.SELECT_BOOK + System.lineSeparator()
                + Ui.RETURN_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());
    }
}
