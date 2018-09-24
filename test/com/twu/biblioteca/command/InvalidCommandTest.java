package com.twu.biblioteca.command;

import com.twu.biblioteca.Ui;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class InvalidCommandTest {

    @Test
    public void testExecute() {
        Command command = CommandFactory.get("abc");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        command.execute(null, null, out);
        assertEquals(Ui.INVALID_OPTION + System.lineSeparator(), out.toString());
    }
}
