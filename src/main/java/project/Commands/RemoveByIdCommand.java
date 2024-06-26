package project.Commands;

import project.Common.Request;
import project.Common.Response;
import project.Managers.ConsolePrinter;
import project.Managers.ProgramController;
import project.Managers.RequestSender;

import java.io.IOException;

/**
 * The class used to call the method and display its work
 */
public class RemoveByIdCommand extends AbstractCommand {

    ProgramController programController = new ProgramController();

    public RemoveByIdCommand(String name, String description) {
        super(name, description);
    }

    /**
     * The method that printing information about deleted element of collection
     * @return void
     */
    @Override
    public Request execute(String args) throws IOException, ClassNotFoundException {
        if (checkId(args)){
            return new Request("remove_by_id", args);
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
