package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;

import java.io.InputStream;

public class InvalidCommand extends Command {

    public String execute(Library library, InputStream in) {
        return Ui.INVALID_OPTION;
    }
}
