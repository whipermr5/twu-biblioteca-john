package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;

import java.io.InputStream;
import java.io.OutputStream;

public class QuitCommand extends Command {

    public String execute(Library library, InputStream in, OutputStream out) {
        return Ui.GOODBYE;
    }
}
