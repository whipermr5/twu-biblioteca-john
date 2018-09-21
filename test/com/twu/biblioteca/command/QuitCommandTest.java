package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class QuitCommandTest {

    @Test
    public void testExecute() {
        Command command = CommandFactory.get(Ui.ID_QUIT);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        command.execute(null, null, out);
        assertEquals(Ui.GOODBYE + System.lineSeparator(), out.toString());
    }
}
