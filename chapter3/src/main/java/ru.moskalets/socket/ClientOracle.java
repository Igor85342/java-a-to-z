package ru.moskalets.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * ClientOracle - Client-side bot.
 * @author Igor Moskalets.
 * @since 14.04.2017.
 */
public class ClientOracle {
    private final int port;
    private final String ip;

    public ClientOracle(int port, String ip ) {
        this.port = port;
        this.ip = ip;
    }
    public static void main(String[] args) throws IOException{
        ClientOracle clientOracle = new ClientOracle(7777, "127.0.0.1");
        clientOracle.runClientOracle();
    }
    /**
     * The main method of the client-side.
     * @return void.
     */
    public void runClientOracle() throws IOException {
        InetAddress inetAddress = InetAddress.getByName(ip);
        System.out.println("The connection to the server" + this.port);
        Socket socket = new Socket(inetAddress, port);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String tempString = null;
            String answer = "";
            while (!answer.equalsIgnoreCase("Goodbye.")) {
                tempString = reader.readLine();
                out.writeUTF(tempString);
                answer = in.readUTF();
                System.out.println(answer);
                out.flush();
            }
        } catch (Exception x) {
            x.printStackTrace();
        } finally {
            in.close();
            out.close();
            reader.close();
            socket.close();
        }
    }
}
