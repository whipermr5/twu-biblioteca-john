package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    @Test
    public void testGet() {
        assertEquals(ListBooksCommand.class, CommandFactory.get("1").getClass());
        assertEquals(QuitCommand.class, CommandFactory.get("q").getClass());
        assertEquals(InvalidCommand.class, CommandFactory.get("abc").getClass());
    }
}
