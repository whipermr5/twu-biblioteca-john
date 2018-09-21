package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;

import java.io.InputStream;
import java.io.PrintStream;

public class QuitCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        out.println(Ui.GOODBYE);
    }
}
