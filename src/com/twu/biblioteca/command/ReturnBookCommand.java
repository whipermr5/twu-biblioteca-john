package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.Ui;

import java.io.InputStream;
import java.io.PrintStream;

public class ReturnBookCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        if (library.getBooksBorrowedBy("user").isEmpty()) {
            out.println(Ui.NO_BOOKS_CHECKED_OUT);
            return;
        }
        out.println(Ui.formatBooksAvailable(library.getBooksBorrowedBy("user")));
        String bookId = Ui.getUserInput(in, out, Ui.SELECT_BOOK_RETURN);
        boolean wasSuccessful = library.returnItem(bookId, "user");
        out.println(wasSuccessful ? Ui.RETURN_SUCCESS : Ui.RETURN_FAILURE);
    }
}
