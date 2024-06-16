package project.Commands;


import project.Common.Request;

/**
 * The class used to call the method and display its work
 */
public class RemoveLowerCommand extends AbstractCommand {

    public RemoveLowerCommand(String name, String description) {
        super(name, description);
    }


    /**
     * The method that printing all removed elements above under integer
     * @return void
     */
    @Override
    public Request execute(String args) {
        return new Request("remove_lower", args);

    }


}
