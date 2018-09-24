package com.twu.biblioteca.command;

import com.twu.biblioteca.Ui;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    @Test
    public void testGet() {
        assertEquals(ListBooksCommand.class, CommandFactory.get(Ui.ID_LIST_BOOKS).getClass());
        assertEquals(CheckoutBookCommand.class, CommandFactory.get(Ui.ID_CHECKOUT).getClass());
        assertEquals(ReturnBookCommand.class, CommandFactory.get(Ui.ID_RETURN).getClass());
        assertEquals(QuitCommand.class, CommandFactory.get(Ui.ID_QUIT).getClass());
        assertEquals(InvalidCommand.class, CommandFactory.get("abc").getClass());
    }
}
