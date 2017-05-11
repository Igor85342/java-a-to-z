package ru.moskalets.socket;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * ServerOracleTest - tests the class ServerOracle.
 * @author Igor Moskalets.
 * @since 21.04.2017.
 */
public class ServerOracleTest {
    private static final String LS = System.getProperty("line.separator");


    /**
     * Checks to see how the server responds to the questions.
     * Keywords will be obtained a definite answer.
     * Testing method runServerOracle().
     */
    public void testRunServerOracle(String input, String excepted) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        ServerOracle server = new ServerOracle(socket);
        server.runServerOracle();
        assertThat(out.toString(),is(excepted));
    }

    @Test
    public void WhenAskExitReturnGoodbyu() throws IOException {
        this.testRunServerOracle( Joiner.on(LS).join("exit",""),
                Joiner.on(LS).join("Goodbye.",""));
    }
    @Test
    public void WhenAskHelloReturnHelloDearFriend() throws IOException {
        this.testRunServerOracle( Joiner.on(LS).join("HellO","exit"),
                Joiner.on(LS).join("Hello, dear friend.","Goodbye.",""));
    }
    @Test
    public void WhenAskNameReturnMyNameOracle() throws IOException {
        this.testRunServerOracle( Joiner.on(LS).join("Name","exit"),
                Joiner.on(LS).join("My name is Oracle.","Goodbye.",""));
    }
    @Test
    public void WhenAskCountryReturnLiveRussia() throws IOException {
        this.testRunServerOracle( Joiner.on(LS).join("CoUntry","exit"),
                Joiner.on(LS).join("I live in Russia.","Goodbye.",""));
    }
    @Test
    public void WhenAskRandomReturnNotUnderstand() throws IOException {
        this.testRunServerOracle( Joiner.on(LS).join("Random","exit"),
                Joiner.on(LS).join("I don't understand.","Goodbye.",""));
    }


}
