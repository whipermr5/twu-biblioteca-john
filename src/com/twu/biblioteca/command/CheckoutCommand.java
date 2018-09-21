package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;

import java.io.InputStream;
import java.io.PrintStream;

public class CheckoutCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        String bookId = Ui.getUserInput(in, out, "");
        boolean wasSuccessful = library.checkout(bookId, "user");
        out.println(wasSuccessful ? Ui.CHECKOUT_SUCCESS : Ui.CHECKOUT_FAILURE);
    }
}
