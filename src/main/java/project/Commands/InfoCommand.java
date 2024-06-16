package project.Commands;


import project.Common.Request;

/**
 * The class used to call the method and display its work
 */
public class InfoCommand extends AbstractCommand {

    String commname = "info";
    public InfoCommand(String name, String description) {
        super(name, description);
    }

    /**
     * The method that printing all information about collection
     * @return void
     */
    @Override
    public Request execute(String args) {
        return new Request(commname, args);
    }

}
