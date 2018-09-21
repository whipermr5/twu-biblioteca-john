package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListBooksCommandTest {

    @Test
    public void testExecute() {
        Command command = Command.get("1");
        String output = command.execute(new Library());
        assertEquals("Books:\n" +
                "Title                                    | Author               | Year\n" +
                "----------------------------------------------------------------------\n" +
                "TDD                                      | Kent                 | 2002\n" +
                "Refactoring                              | Martin               | 1999",
                output);
    }
}
