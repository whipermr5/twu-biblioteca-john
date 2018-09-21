package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;

public abstract class Command {

    public abstract String execute(Library library);
}
