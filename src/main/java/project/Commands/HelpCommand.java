package project.Commands;

import project.Common.Request;

/**
 * The class used to call the method and display its work
 */
public class HelpCommand extends AbstractCommand  {

    String commname = "help";

    public HelpCommand(String name, String description) {
        super(name, description);
    }

    /**
     * The method that printing all commands of the programm
     * @return void
     */


    @Override
    public Request execute(String args) {
        return new Request(commname, args);
    }

}
