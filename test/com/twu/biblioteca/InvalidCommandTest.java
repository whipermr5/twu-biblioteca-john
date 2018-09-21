package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvalidCommandTest {

    @Test
    public void testExecute() {
        Command command = Command.get("abc");
        assertEquals("Select a valid option!", command.execute(null));
    }
}
