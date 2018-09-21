package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuitCommandTest {

    @Test
    public void testExecute() {
        Command command = CommandFactory.get(Ui.ID_QUIT);
        assertEquals(Ui.GOODBYE, command.execute(null, null));
    }
}
