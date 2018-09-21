package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;

import java.io.InputStream;
import java.io.PrintStream;

public class CheckoutCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        if (library.getAvailableBooks().isEmpty()) {
            out.println(Ui.NO_BOOKS);
            return;
        }
        out.println(Ui.formatBookList(library.getAvailableBooks()));
        String bookId = Ui.getUserInput(in, out, Ui.SELECT_BOOK);
        boolean wasSuccessful = library.checkout(bookId, "user");
        out.println(wasSuccessful ? Ui.CHECKOUT_SUCCESS : Ui.CHECKOUT_FAILURE);
    }
}
