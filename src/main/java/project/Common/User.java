package project.Common;

import project.Commands.ExitCommand;
import project.Managers.ConsolePrinter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class User implements Serializable {
    private static final long serialVersionUID = 12312312312312321L;
    private String host;
    private int port;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public User(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws IOException{
        connect();
    }

    private void connect() throws  IOException{
        socket = new Socket();
        socket.connect(new InetSocketAddress(host, port));
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }

    public void close() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            ConsolePrinter.messageToConsole("Соединение было нарушено, отключение пользователя");
            ExitCommand exitCommand = new ExitCommand("","");
            exitCommand.execute("");
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
