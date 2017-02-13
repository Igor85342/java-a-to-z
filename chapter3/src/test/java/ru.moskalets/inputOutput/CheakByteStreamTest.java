package ru.moskalets.inputOutput;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.hamcrest.core.Is.is;
/**
 * CheakByteStreamTest - Tests the class CheakByteStream.
 * @author Igor Moskalets
 * @since 13.02.2017
 */
public class CheakByteStreamTest {
    /**
     * Tests if the number in the stream is even.
     * Testing method isNumber().
     */
    @Test
    public void whenNumberThreadEvenReturnTrue() throws IOException {
        CheakByteStream cbs = new CheakByteStream();
        ByteArrayInputStream bais = new ByteArrayInputStream("4".getBytes() );
        boolean result = cbs.isNumber(bais);
        Assert.assertThat(result, is(true));
    }
    /**
     * Tests if the number in the stream is not even.
     * Testing method isNumber().
     */
    @Test
    public void whenNumberThreadNotEvenReturnFalse() throws IOException {
        CheakByteStream cbs = new CheakByteStream();
        ByteArrayInputStream bais = new ByteArrayInputStream("5".getBytes() );
        boolean result = cbs.isNumber(bais);
        Assert.assertThat(result, is(false));
    }
}
