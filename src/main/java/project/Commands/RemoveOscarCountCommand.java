package project.Commands;

import project.Common.Request;

/**
 * The class used to call the method and display its work
 */
public class RemoveOscarCountCommand extends AbstractCommand {

    public RemoveOscarCountCommand(String name, String description) {
        super(name, description);
    }

    /**
     * The method that printing information about deleted elements,which contained right amout of Oscars
     * @return void
     */
    @Override
    public Request execute(String args) {
        return new Request("remove_any_by_oscars_count", args);

    }

}
