package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class InvalidCommand extends Command {

    public void execute(Library library, InputStream in, OutputStream out) {
        new PrintStream(out).println(Ui.INVALID_OPTION);
    }
}
