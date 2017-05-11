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
    private final Socket socket;
    static final String EXIT = "exit";
    static final String HELLO = "hello";
    static final String NAME = "name";
    static final String COUNTRY = "country";

    public ServerOracle(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws IOException{
        try (final Socket socket = new ServerSocket(7777).accept()) {
            ServerOracle serOracl =new ServerOracle(socket);
            serOracl.runServerOracle();
        }
    }
    /**
     * The main method of the server-side.
     * @return void.
     */
    public void runServerOracle() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String answer = null;
        try {
            String ask = null;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                answer = answerToQuestion(ask);
                out.println(answer);
                out.flush();
            } while (!"exit".equals(ask));
        }
        catch (Exception x) {
            x.printStackTrace();
        }
        finally {
            //out.writeUTF(answer);
            //out.println(answer);
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
