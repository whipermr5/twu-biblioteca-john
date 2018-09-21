package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListBooksCommandTest {

    @Test
    public void testExecute() {
        Command command = CommandFactory.get(Ui.ID_LIST_BOOKS);
        Library library = new Library();
        String output = command.execute(library);
        assertEquals(Ui.formatBookList(library.getBooks()), output);
    }
}
