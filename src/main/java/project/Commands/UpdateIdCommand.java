package project.Commands;


import project.Collections.Movie;
import project.Common.Request;
import project.Common.Response;
import project.Common.User;
import project.Managers.ConsolePrinter;
import project.Managers.RequestSender;
import project.Readers.MovieReader;

import java.io.IOException;

/**
 * The class used to call the method and display its work
 */
public class UpdateIdCommand extends AbstractCommand {
    String commname = "update_id";

    MovieReader movieReader = new MovieReader();



    public UpdateIdCommand(String name, String description) {
        super(name, description);
    }

    /**
     * The method that printing updated element of collection
     *
     * @return void
     */
    @Override
    public Request execute(String args){
        int id = Integer.parseInt(args);
        
        Movie mov1 = movieReader.readMovie();
        mov1.setId(id);
        return new Request(commname,mov1);
    }


    public boolean checkId(String args) throws IOException, ClassNotFoundException {
        int id = Integer.parseInt(args);
        boolean flag = false;
        RequestSender requestSender = new RequestSender(new User("localhost",1000));
        Response response = requestSender.sendRequest(new Request("check_id",args));
        return flag;
    }
}
