package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    @Test
    public void testGet() {
        assertEquals(ListBooksCommand.class, CommandFactory.get(Ui.ID_LIST_BOOKS).getClass());
        assertEquals(QuitCommand.class, CommandFactory.get(Ui.ID_QUIT).getClass());
        assertEquals(InvalidCommand.class, CommandFactory.get("abc").getClass());
    }
}
