package ru.moskalets.socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * ClientOracleTest - tests the class ClientOracle.
 * @author Igor Moskalets.
 * @since 11.05.2017.
 */
public class ClientOracleTest {
    private static final String LS = System.getProperty("line.separator");
    /**
     * The method accepts a string from the input stream and output stream.
     * The purpose of the method is to check whether the client disconnected after receiving the keywords.
     */
    public void testRunClientrOracle(String input, String output) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        ClientOracle clientOracle = new ClientOracle(socket);
        System.setIn(new ByteArrayInputStream(output.getBytes()));
        clientOracle.runClientOracle();
        assertThat(socket.isClosed(), is(false));
    }
    /**
     * Test checks the shutdown of the client after receiving the key words.
     */
    @Test
    public void testExitClientOracle() throws IOException {
        this.testRunClientrOracle( Joiner.on(LS).join("Goodbye.",""),
                Joiner.on(LS).join("First",""));
    }
    /**
     * This test verifies the possibility of dialogue with the server and the client disconnects.
     */
    @Test
    public void testDialogAndExitClientOracle() throws IOException {
        this.testRunClientrOracle( Joiner.on(LS).join("First","Goodbye.",""),
                Joiner.on(LS).join("First","Second",""));
    }
}
