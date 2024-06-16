package project.Managers;

import project.Common.Request;
import project.Common.Response;

import java.io.*;
import java.nio.ByteBuffer;

public class DeSerializer {

    public static Request deSerializeRequest(ByteBuffer buffer) {
        try {
            ByteArrayInputStream byteArray = new ByteArrayInputStream(buffer.array());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArray);
            return (Request) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException ignored){
            ConsolePrinter.errorMessage("Ошибка Чтения Запроса");
            return null;
        }
    }
}
