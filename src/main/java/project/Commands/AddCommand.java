package project.Commands;


import project.Collections.Movie;
import project.Common.Request;
import project.Readers.MovieReader;

import java.io.IOException;
/**
 * The class used to call the method and display its work
 */
public class AddCommand extends AbstractCommand {

    MovieReader movieReader = new MovieReader();

    public AddCommand(String name, String description) {
        super(name, description);
    }
    /**
     * The method that admitting to user new files of collection
     * @return void
     */
    @Override
    public Request execute(String args) throws IOException {
        Movie mov1 = movieReader.readMovie();
    return new Request("add",mov1);
    }
}