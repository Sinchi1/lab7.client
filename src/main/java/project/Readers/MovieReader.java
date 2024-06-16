package project.Readers;

import project.Collections.*;
import project.Managers.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
/**
 * Class for simple reading element
 */
public class MovieReader {

    IntegerChecker integerChecker = (x, y ,z) -> {
        if (z){
            return x < y;
        }
        else{
            return x > y;
        }
    };

    LongChecker longCheck = (x, y ,z) -> {
        if (z){
            return x < y;
        }
        else{
            return x > y;
        }
    };

    DoubleCheck doubleCheck = (x, y ,z) -> {
        if (z){
            return x < y;
        }
        else{
            return x > y;
        }
    };

    Reader reader = new Reader();

    /**
     * The method to read element of Collection from input device
     */
    public Movie readMovie() {
        int id = 0;
        Coordinates cor = null;
        ZonedDateTime creationDate1 = null;
        int oscarCount = 0;
        long goldenPalmCount = 0;
        Person operator = null;
        MovieGenre genre = null;
        long length = 0;
        String filmname = null;
        try {
            // Координаты
            int intX; // net
            int intY;
            while (true) {
                try {
                    filmname = reader.readString("Название фильма").trim();
                    if (filmname.isEmpty()) {
                        ConsolePrinter.messageToConsole("Вы ввели название");
                    } else {
                        break;
                    }
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }

            }
            do {
                try {
                    intX = reader.readInt("Координата X (<985, int)");
                    if (!integerChecker.checkint(intX, 985, true)) {
                        ConsolePrinter.messageToConsole("Координата должна быть меньше 985");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            do {
                try {
                    intY = reader.readInt("Координата Y");
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            cor = new Coordinates(intX, intY);
            // Дата создания
            creationDate1 = ZonedDateTime.now();
            // Количество Оскаров
            do {
                try {
                    oscarCount = reader.readInt("Количество Оскаров (>0, int)");
                    if (!integerChecker.checkint(oscarCount, 0, false)) {
                        ConsolePrinter.messageToConsole("Количество Оскаров должно быть больше 0");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            // Количество goldenPalmCount
            do {
                try {
                    goldenPalmCount = reader.readlong("Количество Золотых Пальм (>0, long)");
                    if (!longCheck.checkLong(goldenPalmCount, 0, false)) {
                        ConsolePrinter.messageToConsole("Количество Золотых Пальм должно быть больше 0");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            // Длина
            do {
                try {
                    length = reader.readlong("Длину фильма (>0, long)");
                    if (!longCheck.checkLong(length, 0, false)) {
                        ConsolePrinter.messageToConsole("Длина должна быть больше 0");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            // Жанр Кино
            genre = reader.readEnum("Введите Жанр Кино", MovieGenre.class);
            // name
            String PersonName;
            while (true) {
                try {
                    PersonName = reader.readString("Имя режиссёра").trim();
                    if (PersonName.isEmpty()) {
                        ConsolePrinter.messageToConsole("Вы ввели пустое имя");
                    } else {
                        break;
                    }
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }

            }
            // height
            double height;
            do {
                try {
                    height = reader.readDouble("Рост (double, >60)");
                    if (doubleCheck.checkDouble(height, 60, true)) {
                        ConsolePrinter.messageToConsole("Вы ввели число меньшее 60");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }
            } while (true);
            // Цвет волос режиссёра
            Color col = reader.readEnum("Введите цвет глаз режиссёра", Color.class);
            //Цвет волос режиссёра
            Color hairCol = reader.readEnum("Введите цвет волос режиссёра", Color.class);
            // Национальность
            Country country = reader.readEnum("Введите Место рождения режиссёра", Country.class);
            // Локация
            float x;
            double y;
            int z;
            do {
                try {
                    x = reader.readFloat("Введите координату x (Float)");
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }

            } while (true);
            do {
                try {
                    y = reader.readDouble("Введите координату y (Double)");
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }

            } while (true);
            do {
                try {
                    z = reader.readInt("Введите координату z (Int)");
                    break;
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }

            } while (true);
            String name;
            while (true) {
                try {
                    name = reader.readString("Название Города").trim();
                    if (name.isEmpty()) {
                        ConsolePrinter.messageToConsole("Название города должно содержать больше 0 букв");
                    } else {
                        break;
                    }
                } catch (InputMismatchException ignored) {
                    ConsolePrinter.messageToConsole("Неправильный тип данных");
                }

            }
            Location location = new Location(x, y, z, name);
            operator = new Person(PersonName, height, col, hairCol, country, location);
            return new Movie(id, filmname, cor, creationDate1, oscarCount, goldenPalmCount, length, genre, operator);
        } catch (NoSuchElementException e) {
            ConsolePrinter.messageToConsole("Введена запрещённая комбинация клавиш! Файл сохранится, а программа " +
                    "завершит свою работу!");
        }
        return new Movie(id, filmname, cor, creationDate1, oscarCount, goldenPalmCount, length, genre, operator);
    }
}
