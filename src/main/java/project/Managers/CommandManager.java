package project.Managers;

import project.Commands.*;
import project.Common.Request;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
/**
 * The class that contains information about Commands
 */
public class CommandManager implements Serializable {
@Serial
    private static final long serialVersionUID = 1454L;

    public void cmdAdd() {
        registerCommand("help", new HelpCommand("Help", "вывести справку по доступным командам"));
        registerCommand("info", new InfoCommand("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)"));
        registerCommand("show", new ShowCommand("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении"));
        registerCommand("clear", new ClearCommand("clear", "очистить коллекцию"));
        registerCommand("add", new AddCommand("add", "добавить новый элемент в коллекцию"));
        registerCommand("exit", new ExitCommand("exit", "Отключается от сервера и сохраняет файл"));
        registerCommand("remove_by_id", new RemoveByIdCommand("remove_by_id", "удалить элемент из коллекции по его id"));
        registerCommand("head", new HeadCommand("head", "вывести первый элемент коллекции"));
        registerCommand("print_genre", new PrintGenreCommand("print_genre", "Выводит все жанры использованные в коллекции"));
        registerCommand("filter_by_name", new FilterNameCommand("filter_by_name", "Показывает количество элементов начинающихся c указанной подстроки"));
        registerCommand("remove_lower", new RemoveLowerCommand("remove_lower", "Удаляет все элементы коллекции, чьё id < указанного пользователем"));
        registerCommand("remove_any_by_oscars_count", new RemoveOscarCountCommand("remove_any_by_oscars_count", "удалить из коллекции один элемент, значение поля oscarsCount которого эквивалентно заданному"));
        registerCommand("update_id", new UpdateIdCommand("update_id", "обновить значение элемента коллекции, id которого равен заданному"));
        registerCommand("execute_script", new ExecuteScriptCommand("execute_script", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде в котором их вводит пользователь в интерактивном режиме."));
    }

    private static final LinkedHashMap<String, AbstractCommand> commandHashMap = new LinkedHashMap<>();
    public LinkedHashMap<String, AbstractCommand> getCommands() {
        return commandHashMap;
    }

    public AbstractCommand getCommandByName(String name){
        return commandHashMap.get(name);
    }

    public void registerCommand(String commandName, AbstractCommand command){
        commandHashMap.put(commandName, command);
    }

    public boolean isCommandExists(String command) {
        return commandHashMap.containsKey(command);
    }

    public boolean isHavingArgument(String command){
        switch (command){
            case "update_id","remove_by_id","execute_script",
                 "remove_any_by_oscars_count",
                 "remove_lower","filter_by_name"-> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }


    public boolean insertNeededObject(String command){
        switch (command){
            case "add","update_id" ->{
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public HashMap<String, AbstractCommand> getCommandHashMap(){
        return commandHashMap;
    }

}
