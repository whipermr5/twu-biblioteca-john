package com.twu.biblioteca;

class ListBooksCommand extends Command {

    String execute(Library library) {
        return Ui.formatBookList(library.getBooks());
    }
}
