package project.Common;

import project.Collections.Movie;
import project.Commands.AbstractCommand;
import project.Managers.CommandManager;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 1404L;
    private final String commandName;
    private String commandStringArgument;
    private Serializable commandObjectArgument;

    public Request(String commandName, Movie commandObjectArgument) {
        this.commandName = commandName;
        this.commandObjectArgument = commandObjectArgument;
    }

    public Request(String commandName, ArrayList<String> commandObjectArgument) {
        this.commandName = commandName;
        this.commandObjectArgument = commandObjectArgument;
    }

    public Request(String commandName, String commandStringArgument) {
        this.commandName = commandName;
        this.commandStringArgument = commandStringArgument;
    }

    public String getCommandName() {
        return commandName;
    }

    public Serializable getCommandObjectArgument() {
        return commandObjectArgument;
    }

}
