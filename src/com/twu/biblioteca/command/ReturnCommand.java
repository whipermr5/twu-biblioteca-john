package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.Ui;

import java.io.InputStream;
import java.io.PrintStream;

public class ReturnCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        if (library.getBooksBorrowedBy("user").isEmpty()) {
            out.println(Ui.NO_BOOKS);
            return;
        }
        out.println(Ui.formatBookList(library.getBooksBorrowedBy("user")));
        String bookId = Ui.getUserInput(in, out, Ui.SELECT_BOOK);
        boolean wasSuccessful = library.returnBook(bookId, "user");
        out.println(wasSuccessful ? Ui.RETURN_SUCCESS : Ui.RETURN_FAILURE);
    }
}
