package project.Commands;

import project.Common.Request;

/**
 * The class used to call the method and display its work
 */
public class PrintGenreCommand extends AbstractCommand  {

    public PrintGenreCommand(String name, String description) {
        super(name, description);
    }

    /**
     * The method that creates new files of collection
     * @return void
     */
    @Override
    public Request execute(String args) {
        return new Request("print_genre", args);
    }
}
