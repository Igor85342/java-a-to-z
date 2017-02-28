package ru.moskalets.inputOutput;

import org.junit.Test;
import org.junit.Assert;

import java.io.*;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.assertEquals;


/**
 * ServiceDropAbusesTest  - tests the class ServiceDropAbuses
 * @author Igor Moskalets.
 * @since 28.02.2017
 */
public class ServiceDropAbusesTest  {
    /*
    * When one word in the list of forbidden words.
    * Testing method dropAbuses.
     */
    @Test
    public void WhenDeleteOneWorldStream() throws IOException {
       ServiceDropAbuses sda = new ServiceDropAbuses();
        String[] abuse = {"aaa"};
        InputStream in = new ByteArrayInputStream("aaa Bbb".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        sda.dropAbuses(in,out,abuse);
        assertEquals(" Bbb", out.toString());
    }
    /*
    * When few words in the list of forbidden words.
    * Testing method dropAbuses.
     */
    @Test
    public void WhenDeleteFewWorldStream() throws IOException {
        ServiceDropAbuses sda = new ServiceDropAbuses();
        String[] abuse = {"aaa","cds","rabs"};
        InputStream in = new ByteArrayInputStream("aaa Bbb eew cds ases rabs gig".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        sda.dropAbuses(in,out,abuse);
        assertEquals(" Bbb eew  ases  gig", out.toString());
    }
}
