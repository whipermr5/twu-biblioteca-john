package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListBooksCommandTest {

    @Test
    public void testExecute() {
        Command command = CommandFactory.get(Ui.ID_LIST_BOOKS);
        Library library = new Library();
        String output = command.execute(library, null);
        assertEquals(Ui.formatBookList(library.getAvailableBooks()), output);
    }
}
