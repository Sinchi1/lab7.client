package project.Commands;


import project.Common.Request;
import project.Managers.ConsolePrinter;

import java.io.*;
import java.util.ArrayList;

/**
 * The class used to call the method and display its work
 */
public class ExecuteScriptCommand extends AbstractCommand {
    public ExecuteScriptCommand(String name, String description) {
        super(name, description);
    }
    /**
     * The method used to execute scripts
     *
     * @return void
     */
    @Override
    public Request execute(String args) throws IOException {
        BufferedReader reader = null;
        ArrayList<String> result = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(args));
        } catch (FileNotFoundException e) {
            ConsolePrinter.messageToConsole("Такого файла скрипта не существует!");
        }
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            } else if (line.contains("execute_script")) {
                result.addAll(readScript(line));
            } else {
                result.add(line);
            }
        }
        return new Request("execute_script", result );
    }

    public ArrayList<String> readScript(String args) throws IOException {
        String[] parts = args.split("\\s+", 2);
        BufferedReader reader = null;
        ArrayList<String> result = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(parts[1]));
        } catch (FileNotFoundException e) {
            ConsolePrinter.messageToConsole("Такого файла скрипта не существует!");
            return result;
        }
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            } else {
                result.add(line);
            }
        }
        return result;
    }
}