package project.Commands;


import project.Collections.Movie;
import project.Common.Request;
import project.Common.Response;
import project.Common.User;
import project.Managers.ConsolePrinter;
import project.Managers.ProgramController;
import project.Managers.RequestSender;
import project.Readers.MovieReader;

import java.io.IOException;

/**
 * The class used to call the method and display its work
 */
public class UpdateIdCommand extends AbstractCommand {
    String commname = "update_id";

    MovieReader movieReader = new MovieReader();

    ProgramController programController = new ProgramController();



    public UpdateIdCommand(String name, String description) {
        super(name, description);
    }

    /**
     * The method that printing updated element of collection
     *
     * @return void
     */
    @Override
    public Request execute(String args) throws IOException, ClassNotFoundException {
        int id = Integer.parseInt(args);
        if (checkId(args)){
            Movie mov1 = movieReader.readMovie();
            mov1.setId(id);
            return new Request(commname,mov1);
        }
        else {
            ConsolePrinter.messageToConsole("Указанного id не существует или вы пытаетесь модифицировать чужой файл!");
            return null;
        }
    }


    public boolean checkId(String args) throws IOException, ClassNotFoundException {
        RequestSender requestSender = new RequestSender(programController.getUser());
        Response response = requestSender.sendRequest(new Request("check_id",args));
        return response.getResponseBody().equals("true");
    }
}
