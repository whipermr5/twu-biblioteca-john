package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;

public class ListBooksCommand extends Command {

    public String execute(Library library) {
        return Ui.formatBookList(library.getAvailableBooks());
    }
}
