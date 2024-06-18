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
    private final String password;

    private final String userName;

    Account account = Account.getInstance();

    public Request(String commandName, Movie commandObjectArgument) {
        this.commandName = commandName;
        this.commandObjectArgument = commandObjectArgument;
        userName = account.getUserName();
        password = account.getPassword();
    }

    public Request(String commandName, ArrayList<String> commandObjectArgument) {
        this.commandName = commandName;
        this.commandObjectArgument = commandObjectArgument;
        userName = account.getUserName();
        password = account.getPassword();
    }

    public Request(String commandName, String commandStringArgument) {
        this.commandName = commandName;
        this.commandStringArgument = commandStringArgument;
        userName = account.getUserName();
        password = account.getPassword();
    }

    public String getCommandName() {
        return commandName;
    }

    public Serializable getCommandObjectArgument() {
        return commandObjectArgument;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
