package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;

import java.io.InputStream;
import java.io.PrintStream;

public class ReturnCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        out.println(Ui.formatBookList(library.getCustomerBooks("user")));
        String bookId = Ui.getUserInput(in, out, Ui.SELECT_BOOK);
        boolean wasSuccessful = library.returnBook(bookId, "user");
        out.println(wasSuccessful ? Ui.RETURN_SUCCESS : Ui.RETURN_FAILURE);
    }
}
