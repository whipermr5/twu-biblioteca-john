package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;

public class ListRecordsCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        if (!library.getSession().isAdminLoggedIn()) {
            new InvalidCommand().execute(library, in, out);
            return;
        }
        out.println(Ui.formatBookRecords(BookCommand.getUnavailableBooks(library), library));
    }
}
