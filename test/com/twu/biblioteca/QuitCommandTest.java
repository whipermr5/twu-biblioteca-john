package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuitCommandTest {

    @Test
    public void testExecute() {
        Command command = Command.get("q");
        assertEquals("Goodbye!", command.execute(null));
    }
}
