package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public abstract class Command {

    public abstract void execute(Library library, InputStream in, PrintStream out);

    public void execute(Library library, InputStream in, OutputStream out) {
        execute(library, in, new PrintStream(out));
    }
}
