package project.Readers;

import project.Managers.ConsolePrinter;

import java.util.HashMap;
import java.util.Scanner;
/**
 * The Class that helps to read data types
 */
public class Reader{
    /**
     * int reading
     * @param message
     * @return int
     */
    public int readInt(String message){
        while(true) {
            ConsolePrinter.messageToConsole("Введите "+ message);
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            return x;
        }
    }
    /**
     * long reading
     * @param message
     * @return long
     */
    public long readlong(String message){
        while(true) {
            ConsolePrinter.messageToConsole("Введите "+ message);
            Scanner scanner = new Scanner(System.in);
            long x = scanner.nextLong();
            return x;
        }
    }
    /**
     * double reading
     * @param message
     * @return double
     */
    public double readDouble(String message){
        while(true) {
            ConsolePrinter.messageToConsole("Введите "+ message);
            Scanner scanner = new Scanner(System.in);
            Double x = scanner.nextDouble();
            return x;
        }
    }
    /**
     * String reading
     * @param message
     * @return String
     */
    public String readString(String message){
        while(true) {
            ConsolePrinter.messageToConsole("Введите "+ message);
            Scanner scanner = new Scanner(System.in);
            String x = scanner.nextLine();
            return x;
        }
    }
    /**
     * float reading
     * @param message
     * @return float
     */
    public float readFloat(String message){
        while(true) {
            ConsolePrinter.messageToConsole("Введите "+ message);
            Scanner scanner = new Scanner(System.in);
            float x = scanner.nextFloat();
            return x;
        }
    }
    /**
     * Enum reading
     * @param message, enumClass
     * @return Enum
     */
    public <T extends Enum<T>> T readEnum(String message, Class<T> enumClass) {
        T genre = null;
        HashMap<Integer,String> EnumList = new HashMap<>();
        int count = 0;
        try {
            Scanner scan = new Scanner(System.in);
            while (true) {
                ConsolePrinter.messageToConsole("Выберите "+message+":");
                T[] enumConstants = enumClass.getEnumConstants();
                for (T enumConstant : enumConstants) {
                    ConsolePrinter.messageToConsole(count +" " + String.valueOf(enumConstant));
                    EnumList.put(count,String.valueOf(enumConstant));
                    count +=1;
                }
                var genreInput = scan.nextLine().toUpperCase();
                boolean flag = false;
                //java.lang.String
                do {
                    for (T gen : enumClass.getEnumConstants()) {
                        try {
                        if (gen.name().equals(genreInput)) {
                            ConsolePrinter.messageToConsole("Строка соответствует одной из констант Enum");
                            genre = T.valueOf(enumClass, genreInput);
                            flag = true;
                            break;
                        } else if (genreInput.matches("-?\\d+(\\.\\d+)?")) {
                                genre = T.valueOf(enumClass, EnumList.get(Integer.parseInt(genreInput)));
                                flag = true;
                                break;
                            }
                        }catch (NullPointerException ignored){

                        }
                    }
                    if (flag) {
                        break;
                    }
                    else {
                        ConsolePrinter.messageToConsole("Вы ввели несуществующий тип, попробуйте ещё раз!");
                        ConsolePrinter.messageToConsole("Выберите "+ message+":");
                        count = 0;
                        for (T enumConstant : enumConstants) {
                            ConsolePrinter.messageToConsole(count +" " + String.valueOf(enumConstant));
                            EnumList.put(count,String.valueOf(enumConstant));
                            count +=1;
                        }
                        genreInput = scan.nextLine().toUpperCase();
                    }
                } while (!flag);
                break;
            }
        } catch (IllegalArgumentException e) {
            ConsolePrinter.messageToConsole("Вы ввели неверный тип!");
        }
        return genre;
    }



}