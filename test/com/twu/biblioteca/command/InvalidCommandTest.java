package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvalidCommandTest {

    @Test
    public void testExecute() {
        Command command = CommandFactory.get("abc");
        assertEquals(Ui.INVALID_OPTION, command.execute(null, null));
    }
}
