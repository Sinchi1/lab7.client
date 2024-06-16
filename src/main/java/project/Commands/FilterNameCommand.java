package project.Commands;

import project.Common.Request;

/**
 * The class used to call the method and display its work
 */
public class FilterNameCommand extends AbstractCommand  {

    public FilterNameCommand(String name, String description) {
        super(name, description);
    }
    /**
     * The method used to print the number of matches in object names
     *
     * @return void
     */
    @Override
    public Request execute(String args) {
        return new Request("filter_by_name", args);

    }

}
