package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    @Test
    public void testGet() {
        assertEquals(LoginCommand.class, CommandFactory.get(Ui.ID_LOGIN).getClass());
        assertEquals(LogoutCommand.class, CommandFactory.get(Ui.ID_LOGOUT).getClass());
        assertEquals(ListBooksCommand.class, CommandFactory.get(Ui.ID_LIST_BOOKS).getClass());
        assertEquals(ListRecordsCommand.class, CommandFactory.get(Ui.ID_LIST_RECORDS).getClass());
        assertEquals(ListMoviesCommand.class, CommandFactory.get(Ui.ID_LIST_MOVIES).getClass());
        assertEquals(CheckoutBookCommand.class, CommandFactory.get(Ui.ID_CHECKOUT_BOOK).getClass());
        assertEquals(CheckoutMovieCommand.class, CommandFactory.get(Ui.ID_CHECKOUT_MOVIE).getClass());
        assertEquals(ReturnBookCommand.class, CommandFactory.get(Ui.ID_RETURN_BOOK).getClass());
        assertEquals(ReturnMovieCommand.class, CommandFactory.get(Ui.ID_RETURN_MOVIE).getClass());
        assertEquals(QuitCommand.class, CommandFactory.get(Ui.ID_QUIT).getClass());
        assertEquals(InvalidCommand.class, CommandFactory.get("abc").getClass());
    }
}
