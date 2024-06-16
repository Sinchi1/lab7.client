package project.Commands;


import project.Common.Request;

/**
 * The class used to call the method and display its work
 */
public class ShowCommand extends AbstractCommand {
    String commname = "show";

    public ShowCommand(String name, String description) {
        super(name, description);
    }
    /**
     * The method that printing all elements of collection
     * @return void
     */
    @Override
    public Request execute(String args) {
        return new Request(commname, args);
    }

}
