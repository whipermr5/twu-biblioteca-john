package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandTest {

    @Test
    public void testFactory() {
        assertEquals(ListBooksCommand.class, Command.get("1").getClass());
        assertEquals(QuitCommand.class, Command.get("q").getClass());
        assertEquals(InvalidCommand.class, Command.get("abc").getClass());
    }
}
