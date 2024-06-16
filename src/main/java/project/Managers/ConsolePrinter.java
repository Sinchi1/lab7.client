package project.Managers;
/**
 * The class that used instead of System.out
 */
public class ConsolePrinter {

    public static void messageToConsole(String message){
        System.out.println(message);
    }
    public static void messageToConsoleWithoutLn(String message){
        System.out.print(message);
    }

    public static void errorMessage(String message){
        System.out.println("Произошла ошибка" + message);
    }
}
