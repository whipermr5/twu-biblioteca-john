package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.common.Ui;

import java.io.InputStream;
import java.io.PrintStream;

public class ReturnBookCommand extends BookCommand {

    public void execute(Library library, InputStream in, PrintStream out) {
        if (getBooksBorrowedBy(library, "user").isEmpty()) {
            out.println(Ui.NO_BOOKS_CHECKED_OUT);
            return;
        }
        out.println(Ui.formatBooksCheckedOut(getBooksBorrowedBy(library, "user")));
        String bookId = Ui.getUserInput(in, out, Ui.SELECT_BOOK_RETURN);
        if (!isBook(library.getItem(bookId))) {
            out.println(Ui.RETURN_BOOK_FAILURE);
            return;
        }
        boolean wasSuccessful = library.returnItem(bookId, "user");
        out.println(wasSuccessful ? Ui.RETURN_BOOK_SUCCESS : Ui.RETURN_BOOK_FAILURE);
    }
}
