package project.Managers;

import project.Common.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class Serializer {

    public static ByteBuffer serialize(Response response) throws IOException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(byteArray);
        objectOut.writeObject(response);
        objectOut.close();
        ByteBuffer buffer = ByteBuffer.allocate(byteArray.size());
        buffer.put(byteArray.toByteArray());
        return buffer;

    }
}
