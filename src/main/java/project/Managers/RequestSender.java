package project.Managers;

import project.Common.Request;
import project.Common.Response;
import project.Common.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RequestSender {
    private final User user;

    public RequestSender(User user) {
        this.user = user;
    }

    public Response sendRequest(Request request) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(request);
        outputStream.close();

        user.getOutputStream().write(byteArrayOutputStream.toByteArray());

        ObjectInputStream objectInputStream = new ObjectInputStream(user.getInputStream());

        return (Response) objectInputStream.readObject();
    }
}