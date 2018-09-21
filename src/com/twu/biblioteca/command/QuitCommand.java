package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;

public class QuitCommand extends Command {

    public String execute(Library library) {
        return Ui.GOODBYE;
    }
}
