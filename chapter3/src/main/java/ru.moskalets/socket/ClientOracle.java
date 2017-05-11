package ru.moskalets.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ClientOracle - Client-side bot.
 * @author Igor Moskalets.
 * @since 14.04.2017.
 */
public class ClientOracle {
    private final Socket socket;
    static final String GOODBYE = "Goodbye.";

    public ClientOracle(Socket socket ) {
        this.socket = socket;
    }
    public static void main(String[] args) throws IOException{
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress,7777);
        ClientOracle clientOracle =new ClientOracle(socket);
        clientOracle.runClientOracle();
    }
    /**
     * The main method of the client-side.
     * @return void.
     */
    public void runClientOracle() throws IOException {
        System.out.println("The connection to the server");
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try {
            String tempString;
            String answer = "";
            while (!GOODBYE.equals(answer)) {
                tempString = console.readLine();
                out.println(tempString);
                answer = in.readLine();
                System.out.println(answer);
                out.flush();
            }
        } catch (Exception x) {
            x.printStackTrace();
        } finally {
            in.close();
            out.close();
            socket.close();
        }
    }
}
