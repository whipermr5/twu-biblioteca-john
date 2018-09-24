package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;

public class ListBooksCommand extends BookCommand {

    public void execute(Library library, InputStream in, PrintStream out) {
        out.println(Ui.formatBooksAvailable(getAvailableBooks(library)));
    }
}
