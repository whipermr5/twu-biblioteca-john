package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Session;
import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;

public class UserInfoCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        Session session = library.getSession();
        if (!session.isUserLoggedIn()) {
            new InvalidCommand().execute(library, in, out);
            return;
        }
        out.println(Ui.formatUserInfo(session.getCurrentUser()));
    }
}
