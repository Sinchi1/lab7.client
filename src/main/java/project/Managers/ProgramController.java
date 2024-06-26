package project.Managers;

import project.Common.Account;
import project.Common.Request;
import project.Common.Response;
import project.Common.User;
import project.Commands.AbstractCommand;
import project.ProgrammEnums.OperationCode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProgramController {
    private final CommandManager commandManager = new CommandManager();
    private final static User user = new User("localhost",2032); ;
    private final RequestSender requestSender;
    private final ResponseHandler  responseHandler = new ResponseHandler();;
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 2032;

    Scanner scan = new Scanner(System.in);

    private Account account = Account.getInstance();

    public ProgramController() {
        requestSender = new RequestSender(user);
    }

    Scanner scanner = new Scanner(System.in);

    public void run(){
        while(true) {
            while (true) {
                try {
                    user.run();
                    autihication();
                } catch (IOException e) {
                    ConsolePrinter.messageToConsole("Сервер не запущен, для попытки переподключения нажмите Enter");
                    scanner.nextLine();
                    continue;
                }
                break;
            }
            ConsolePrinter.messageToConsole("Подключение прошло успешно...");
            commandManager.cmdAdd();
            boolean isFirstCom = true;
            Thread thread = new Thread(() -> {
                ConsolePrinter.messageToConsole("\nВыход из программы");
            });
            Runtime.getRuntime().addShutdownHook(thread);
            while (true) {
                autihication();
                try {
                    if (!isFirstCom) {
                        ConsolePrinter.messageToConsoleWithoutLn("Ваша команда:");
                        String line = null;
                        try {
                            Thread.sleep(1);
                            line = scan.nextLine().trim();
                        } catch (NoSuchElementException | InterruptedException ignored) {
                            thread.interrupt();
                            System.exit(1);
                        }
                        if (line.equalsIgnoreCase("exit")){
                            Runtime.getRuntime().removeShutdownHook(thread);
                        }
                        String[] parts = line.split("\\s+", 2);
                        String commName = parts[0].toLowerCase();
                        if (commandManager.isCommandExists(commName)) {
                            AbstractCommand com = commandManager.getCommandByName(commName);
                            if (commandManager.isHavingArgument(commName) && (parts.length == 1)) {
                                ConsolePrinter.messageToConsole("Вы забыли аргумент команды!");
                                continue;
                            }
                            if ((commandManager.isHavingArgument(commName)) && (parts[1].split("\\s{1}", 2)).length > 1) {
                                ConsolePrinter.messageToConsole("Вы перестарались и ввели лишний аргумент для команды!");
                                continue;
                            }
                            String args = "";
                            if (commandManager.isHavingArgument(commName)) {
                                args = parts[1];
                            }
                            Request request = com.buildCommand(commName, args);

                            if (commName.equalsIgnoreCase("exit")){
                                Response response = requestSender.sendRequest(request);
                                ConsolePrinter.messageToConsole(responseHandler.handleResponse(response));
                                user.close();
                            }

                            if (request != null) {
                                Response response = requestSender.sendRequest(request);
                                ConsolePrinter.messageToConsole(responseHandler.handleResponse(response));

                            }

                        } else {
                            ConsolePrinter.messageToConsole("К сожалению, введённой команды не существует!");
                        }
                    } else {
                        ConsolePrinter.messageToConsole("Для использования программы нужно знать команды, чтобы ознакомиться с ними" +
                                " введите команду help.\nЕсли же вы их знаете в добрый путь!");
                        isFirstCom = false;
                    }
                } catch (SocketException e) {
                    ConsolePrinter.messageToConsole("Сервер был отключен.. Попытка переподключиться ");
                    while (true) {
                        try {
                            user.run();
                        } catch (IOException b) {
                            ConsolePrinter.messageToConsole("Сервер не запущен, для попытки переподключения нажмите Enter \nДля отключения напишите exit");
                            String answer = scanner.nextLine();
                            if (answer.equalsIgnoreCase("exit")){
                                System.exit(1);
                            }
                            continue;
                        }
                        break;
                    }
                } catch (IOException | ClassNotFoundException e) {
                    ConsolePrinter.messageToConsole("Произошла непредвиденная ошибка");
                    return;
                }
            }
        }
    }

    public void autihication(){
        if (account.getUserName() == null || account.getPassword() == null){
            ConsolePrinter.messageToConsole("Чтобы воспользоваться приложением нужно\n" +
                "пройти процесс аутентификации ");
        ArrayList<String> arguments = new ArrayList<>();
            try {
                while(true) {
                    ConsolePrinter.messageToConsole("Для регистрации или входа напишите reg/log соответственно");
                    String userInput = scan.nextLine();
                    String action;
                    if (userInput.equals("reg")) {
                        action = "registration";
                    } else if (userInput.equals("log")) {
                        action = "log";
                    } else {
                        continue;
                    }

                    ConsolePrinter.messageToConsole("Введите имя пользователя: ");
                    String userName = scan.nextLine().trim();
                    arguments.add(userName);
                    ConsolePrinter.messageToConsole("Введите пароль : ");
                    String password = scan.nextLine().trim();
                    arguments.add(password);
                    arguments.add(action);

                    account.setUserName(userName);
                    account.setPassword(password);

                    Response response;
                    try {
                        response = requestSender.sendRequest(new Request(action, arguments));
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Кажется сервер был отключен, попытка переподключиться...");
                        while (true) {
                            try {
                                user.run();
                            } catch (IOException b) {
                                ConsolePrinter.messageToConsole("Сервер не запущен, для попытки переподключения нажмите Enter \nДля отключения напишите exit");
                                String answer = scanner.nextLine();
                                if (answer.equalsIgnoreCase("exit")){
                                    System.exit(1);
                                }
                                continue;
                            }
                            break;
                        }
                        continue;
                    }

                    if (response.getOperationCode().equals(OperationCode.ok)) {
                        account.setUserName(arguments.get(0));
                        account.setPassword(arguments.get(1));
                        ConsolePrinter.messageToConsole(response.getResponseBody());
                        break;
                    } else {
                        ConsolePrinter.messageToConsole(response.getResponseBody());
                    }
                    arguments.clear();
                }
            } catch (Exception e) {
                ConsolePrinter.messageToConsole("Сервер был отключен.. Попытка переподключиться ");
                while (true) {
                    try {
                        user.run();
                    } catch (IOException b) {
                        ConsolePrinter.messageToConsole("Сервер не запущен, для попытки переподключения нажмите Enter \nДля отключения напишите exit");
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("exit")){
                            System.exit(1);
                        }
                        continue;
                    }
                    break;
                }
            }
        }
    }

    public User getUser(){
        return user;
    }
}
