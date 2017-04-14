package ru.moskalets.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerOracle - Server-side bot.
 * @author Igor Moskalets.
 * @since 14.04.2017.
 */
public class ServerOracle {
    private final int port;
    static final String EXIT = "exit";
    static final String HELLO = "hello";
    static final String NAME = "name";
    static final String COUNTRY = "country";

    public ServerOracle(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws IOException{
        ServerOracle serverOracle = new ServerOracle(7777);
        serverOracle.runServerOracle();
    }
    /**
     * The main method of the server-side.
     * @return void.
     */
    public void runServerOracle() throws IOException {
        ServerSocket serverSocket = new ServerSocket(this.port);
        Socket socket = serverSocket.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String answer = null;
        try {
            String ask = null;
            do {
                System.out.println("wait command ...");
                ask = in.readUTF();
                System.out.println(ask);
                answer = answerToQuestion(ask);
                out.writeUTF(answer);
                out.flush();
            } while (!"exit".equals(ask));
        }
        catch (Exception x) {
            x.printStackTrace();
        }
        finally {
            out.writeUTF(answer);
            in.close();
            socket.close();
        }
    }
    /**
     * The method returns the string for key words.
     * @param String ask.
     * @return String.
     */
    public String answerToQuestion(String ask){
        if (EXIT.equalsIgnoreCase(ask))
            return "Goodbye.";
        else if (HELLO.equalsIgnoreCase(ask))
                return "Hello, dear friend.";
             else if (NAME.equalsIgnoreCase(ask))
                 return "My name is Oracle.";
                 else if (COUNTRY.equalsIgnoreCase(ask))
                     return "I live in Russia.";
                     else return "I don't understand.";
    }
}
