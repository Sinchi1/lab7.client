package project.Commands;

import project.Common.Request;
import project.Managers.CommandManager;

import java.io.IOException;

/**
 * Abstract class for all Commands
 */
public abstract class AbstractCommand implements InterCommand {

    CommandManager commandManager = new CommandManager();

    private final String name;

    private final String description;

    public AbstractCommand(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Request buildCommand(String commandName, String args) throws IOException {
        AbstractCommand com = commandManager.getCommandByName(commandName);
        Request request = com.execute(args);
        return request;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + "(" + description + ")";
    }
    


}
